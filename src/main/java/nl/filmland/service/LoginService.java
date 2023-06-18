package nl.filmland.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import nl.filmland.dto.LoginDto;
import nl.filmland.repository.CustomerDao;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

  private final CustomerDao customerDao;

  public boolean validateUser(LoginDto loginDto) {
    return Optional.ofNullable(loginDto)
        .filter(this::userExists)
        .map(this::passwordIsValid)
        .orElse(false);
  }

  private boolean userExists(LoginDto loginDto) {
    return customerDao.existsByEmailAsUsername(loginDto.getEmailAsUsername());
  }

  private boolean passwordIsValid(LoginDto loginDto) {
    return customerDao
        .findCustomerByEmailAsUsername(loginDto.getEmailAsUsername())
        .getPassword()
        .equals(loginDto.getPassword());
  }
}
