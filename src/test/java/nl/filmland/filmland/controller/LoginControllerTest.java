package nl.filmland.filmland.controller;


import nl.filmland.dto.LoginDto;
import nl.filmland.filmland.repository.UserDao;
import nl.filmland.filmland.service.LoginService;
import nl.filmland.filmland.testobjects.TestLoginDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginControllerTest {

  @Autowired
  LoginController subject;

  @Autowired
  UserDao userDao;

  @Autowired
  LoginService loginService;

  @Test
  void call_login_with_unknownUser(){
    LoginDto unknownUser = TestLoginDto.createUnknowUser();
    var response = subject.login(unknownUser);
    Assertions.assertEquals("User login failed", response.getBody());
    Assertions.assertEquals(401, response.getStatusCode().value());
  }

  @Test
  void call_login_with_invalidPassword(){
    LoginDto userWithInvalidPassword = TestLoginDto.createUserWithInvalidPassword();
    var response = subject.login(userWithInvalidPassword);
    Assertions.assertEquals("User login failed", response.getBody());
    Assertions.assertEquals(401, response.getStatusCode().value());
  }

  @Test
  void call_login_with_validCredentials(){
    LoginDto userWithValidPassword = TestLoginDto.createUserWithValidPassword();
    var response = subject.login(userWithValidPassword);
    Assertions.assertEquals("User login successful", response.getBody());
    Assertions.assertEquals(200, response.getStatusCode().value());
  }


}
