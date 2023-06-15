package nl.filmland.filmland.unittests;

import static org.junit.jupiter.api.Assertions.*;

import nl.filmland.filmland.model.User;
import nl.filmland.filmland.repository.UserDao;
import nl.filmland.filmland.service.LoginService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoginTests {

  @Autowired
  LoginService subject;
  @Autowired
  UserDao userDao;


  @Test
  void getUserNameFromH2() {
    assertEquals("France@gmail.com", userDao.findUserById(2L).getEmailAsUsername());

  }
  @Test
   void getPassword() {
    assertEquals("34567", userDao.findUserByEmailAsUsername("Brazil@gmail.com").getPassword());
  }

  @Test
  void validatePassword_withUnknownUser(){
    User unknownUser = User.builder().build();
    assertEquals("User unknown", subject.executeLogin(unknownUser));
  }

  @Test
  void validatePassword_withKnownUser_InvalidPassword() {
    User knownUserWithInvalidPassword = User.builder()
        .emailAsUsername("Italy@gmail.com")
        .password("12345").build();
    assertEquals("Combination username and password invalid", subject.executeLogin(knownUserWithInvalidPassword));
  }

  @Test
  void validatePassword_withValidCredentials() {
    User knownUserWithInvalidPassword = User.builder()
        .emailAsUsername("Italy@gmail.com")
        .password("45678").build();
    assertEquals("You login is successful", subject.executeLogin(knownUserWithInvalidPassword));
  }

}
