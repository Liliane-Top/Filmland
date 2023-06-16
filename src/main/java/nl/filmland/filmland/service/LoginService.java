package nl.filmland.filmland.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import nl.filmland.dto.LoginDto;
import nl.filmland.filmland.model.User;
import nl.filmland.filmland.repository.UserDao;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
  private final UserDao userDao;

  public boolean validateUser(LoginDto loginDto){
    if(loginDto == null || loginDto.getEmailAsUsername() == null || loginDto.getPassword()  == null){
      return false;
    }
    if (!userExists(loginDto)) {
      return false;
    }
    if(!passwordIsValid(loginDto)) {
      return false;
    }
    return true;
  }

  private boolean userExists(LoginDto loginDto) {
    return userDao.existsByEmailAsUsername(loginDto.getEmailAsUsername());
    }
  private boolean passwordIsValid(LoginDto loginDto) {
    User user = userDao.findUserByEmailAsUsername(loginDto.getEmailAsUsername());
    return user.getPassword().equals(loginDto.getPassword());
  }



}
