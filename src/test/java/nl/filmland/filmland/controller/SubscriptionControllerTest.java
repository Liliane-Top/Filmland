package nl.filmland.filmland.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.awt.image.RescaleOp;
import java.util.List;
import nl.filmland.filmland.model.Subscription;
import nl.filmland.filmland.repository.CategoryDao;
import nl.filmland.filmland.service.SubscriptionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class SubscriptionControllerTest {

  @Autowired
  SubscriptionController subject;

  @Test
  void call_getAllSubscriptions() {
    var response = subject.getAllSubscriptions();
    assertEquals(3, response.getBody().size() );
    assertEquals(HttpStatus.OK, response.getStatusCode() );
  }

  @Test
  void call_getAllSubscriptionsByCustomerWithOutSubscriptions(){
    var response = subject.getAllSubscriptionsByCustomerId(2L);
    assertNull(response.getBody());
    assertEquals(204, response.getStatusCode().value() );
  }

  @Test
  void call_getAllSubscriptionsByCustomerWithSubscriptions(){
    var response = subject.getAllSubscriptionsByCustomerId(5L);
    assertEquals(3, response.getBody().size() );
    assertEquals(HttpStatus.OK, response.getStatusCode() );
  }

  @Test
  void call_getAllSubscriptionsByUnknownCustomer() {
    var response = subject.getAllSubscriptionsByCustomerId(6L);
    assertNull(response.getBody());
    assertEquals(204, response.getStatusCode().value());
  }

  @Test
  void call_getAllSubscriptionsByValidUsername(){
    var response = subject.getAllSubscriptionsByUserName("Italy@gmail.com");
    assertEquals(2, response.getBody().size());
    assertEquals(HttpStatus.OK, response.getStatusCode());
  }
}
