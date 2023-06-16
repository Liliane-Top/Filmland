package nl.filmland.filmland.service;

import static org.junit.jupiter.api.Assertions.*;

import nl.filmland.dto.LoginDto;
import nl.filmland.filmland.repository.UserDao;
import nl.filmland.filmland.testobjects.TestLoginDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoginTest {

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
    LoginDto unknownUser = TestLoginDto.createUnknowUser();
    assertFalse(subject.validateUser(unknownUser));
  }

  @Test
  void validatePassword_withKnownUser_InvalidPassword() {
    LoginDto knownUserWithInvalidPassword = TestLoginDto.createUserWithInvalidPassword();
    assertFalse(subject.validateUser(knownUserWithInvalidPassword));
  }

  @Test
  void validatePassword_withValidCredentials() {
   LoginDto knownUserWithInvalidPassword = TestLoginDto.createUserWithValidPassword();
    assertTrue(subject.validateUser(knownUserWithInvalidPassword));
  }

}
