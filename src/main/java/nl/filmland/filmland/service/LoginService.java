package nl.filmland.filmland.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import nl.filmland.dto.LoginDto;
import nl.filmland.filmland.repository.UserDao;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

  private final UserDao userDao;

  public boolean validateUser(LoginDto loginDto) {
    return Optional.ofNullable(loginDto)
        .filter(this::userExists)
        .map(this::passwordIsValid)
        .orElse(false);
  }

  private boolean userExists(LoginDto loginDto) {
    return userDao.existsByEmailAsUsername(loginDto.getEmailAsUsername());
  }

  private boolean passwordIsValid(LoginDto loginDto) {
    return userDao
        .findUserByEmailAsUsername(loginDto.getEmailAsUsername())
        .getPassword()
        .equals(loginDto.getPassword());
  }
}
