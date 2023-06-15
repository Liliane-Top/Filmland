package nl.filmland.filmland.controller;

import lombok.RequiredArgsConstructor;
import nl.filmland.filmland.model.User;
import nl.filmland.filmland.repository.UserDao;
import nl.filmland.filmland.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class LoginController {

  LoginService loginService;


  @PostMapping(produces = "application/json", path = "/login")

  //Todo: change returning String to ResponseBody
  //Todo: change RequestBody to username and password
  public String login(@RequestBody User mpUser) {
    return loginService.executeLogin(mpUser);
  }


}
