package nl.filmland.filmland.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import nl.filmland.controller.CustomerController;
import nl.filmland.filmland.testobjects.TestCustomer;
import nl.filmland.model.Customer;
import nl.filmland.repository.CustomerDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerControllerTest {

  @Autowired
  CustomerController subject;

  @Autowired
  CustomerDao customerDao;

  @Test
  void call_registerUser_with_validCredentials() {
    Customer newCustomer = TestCustomer.createTestCustomer();
    var response = subject.registerUser(newCustomer);
    assertEquals(201, response.getStatusCode().value());

    var customer = customerDao.findCustomerByEmailAsUsername("Holland@gmail.com");
    customer.ifPresent(value -> assertEquals(1, value.getId()));

  }

  @Test
  void call_registerUser_with_existingCredentials() {
    Customer existingCustomer = Customer.builder()
        .emailAsUsername("France@gmail.com")
        .id(12L)
        .build();

    var response = subject.registerUser(existingCustomer);
    assertEquals(400, response.getStatusCode().value());
  }

}
