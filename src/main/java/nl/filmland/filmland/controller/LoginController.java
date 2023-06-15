package nl.filmland.filmland.controller;

import lombok.RequiredArgsConstructor;
import nl.filmland.filmland.model.User;
import nl.filmland.filmland.repository.UserDao;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class LoginController {

  private final UserDao userDao;

  @PostMapping(produces = "application/json", path = "/login")
  public String login(@RequestBody User mpUser) {

    if (!userDao.existsByEmailAsUsername(mpUser.getEmailAsUsername())) {
      return "User unknown";
    }

    User user = userDao.findUserByEmailAsUsername(mpUser.getEmailAsUsername());
    if (!user.getPassword().equals(mpUser.getPassword())){
      return "Combination username and password invalid";
    }
    return String.valueOf(user.getId());

  }


}
