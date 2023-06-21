package nl.filmland.filmland.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import nl.filmland.controller.CustomerController;
import nl.filmland.filmland.testobjects.TestCustomer;
import nl.filmland.model.Customer;
import nl.filmland.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class CustomerServiceTest {

  @Autowired
  CustomerService subject;

  @Autowired
  CustomerController customerController;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Test
  void call_addCustomer_with_validCredentials() {
    Customer newCustomer = TestCustomer.createTestCustomer();

    var response = subject.addCustomer(newCustomer);
    assertEquals("Holland@gmail.com", response.getUsername());
    assertTrue(passwordEncoder.matches("12345", response.getPassword()));
    assertEquals(1, response.getId());

  }

  @Test
  void call_addCustomer_with_invalidCredentials() {

  }

  @Test
  void call_findCustomer_which_exists() {

  }

  @Test
  void call_findCustomer_which_not_exists() {

  }

  @Test
  void call_loadUserByUsername_which_exists() {

  }

  @Test
  void call_loadUserByUsername_which_not_exists() {

  }
}
