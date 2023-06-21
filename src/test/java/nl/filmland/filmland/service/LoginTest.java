package nl.filmland.filmland.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import nl.filmland.dto.LoginDto;
import nl.filmland.repository.CustomerDao;
import nl.filmland.filmland.testobjects.TestLoginDto;
import nl.filmland.service.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoginTest {

  @Autowired
  LoginService subject;
  @Autowired
  CustomerDao customerDao;


  @Test
  void getUserNameFromH2() {
    assertEquals("France@gmail.com", customerDao.findCustomerById(12L).getEmailAsUsername());
  }

  @Test
  void getPassword() {
    customerDao.findCustomerByEmailAsUsername("Brazil@gmail.com").ifPresent(value -> assertEquals("34567", value.getPassword()));
  }

  @Test
  void validateUser_withoutCredentials() {
    assertFalse(subject.validateUser(null));
  }

  @Test
  void validateUser_withoutInvalidUserName() {
    LoginDto userWithInvalidUsername = TestLoginDto.createUserWithInvalidUsername();
    assertFalse(subject.validateUser(userWithInvalidUsername));
  }

  @Test
  void validatePassword_withUnknownUser() {
    LoginDto unknownUser = TestLoginDto.createUnknownUser();
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
