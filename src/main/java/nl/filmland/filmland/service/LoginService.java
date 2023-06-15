package nl.filmland.filmland.service;

import lombok.RequiredArgsConstructor;
import nl.filmland.filmland.model.User;
import nl.filmland.filmland.repository.UserDao;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
  private final UserDao userDao;

  public String executeLogin(User mpUser){
    if (!userDao.existsByEmailAsUsername(mpUser.getEmailAsUsername())) {
      return "User unknown";
    }

    User user = userDao.findUserByEmailAsUsername(mpUser.getEmailAsUsername());
    if (!user.getPassword().equals(mpUser.getPassword())){
      return "Combination username and password invalid";
    }

    return "You login is successful";
  }



}
