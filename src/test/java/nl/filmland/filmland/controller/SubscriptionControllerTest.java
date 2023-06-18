package nl.filmland.filmland.controller;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;
import nl.filmland.filmland.model.Subscription;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest
class SubscriptionControllerTest {

  @Autowired
  SubscriptionController subject;

  @Test
  void call_getAllSubscriptions() {
    var response = subject.getAllSubscriptions();
    assertEquals(3, requireNonNull(response.getBody()).size());
    assertEquals(HttpStatus.OK, response.getStatusCode());
  }

  @Test
  void call_getAllSubscriptionsByCustomerWithOutSubscriptions() {
    var response = subject.getAllSubscriptionsByCustomerId(2L);
    assertNull(response.getBody());
    assertEquals(204, response.getStatusCode().value());
  }

  @Test
  void call_getAllSubscriptionsByCustomerWithSubscriptions() {
    var response = subject.getAllSubscriptionsByCustomerId(5L);
    assertEquals(3, requireNonNull(response.getBody()).size());
    assertEquals(HttpStatus.OK, response.getStatusCode());
  }

  @Test
  void call_getAllSubscriptionsByUnknownCustomer() {
    var response = subject.getAllSubscriptionsByCustomerId(6L);
    assertNull(response.getBody());
    assertEquals(204, response.getStatusCode().value());
  }

  @Test
  void call_getAllSubscriptionsByValidUsername() {
    var response = subject.getAllSubscriptionsByUserName("Canada@gmail.com");
    assertEquals(3, requireNonNull(response.getBody()).size());
    assertEquals(HttpStatus.OK, response.getStatusCode());
  }

  @Test
  void call_addSubscription_with_valid_parameters() {
    var response = subject.addSubscription("Brazil@gmail.com", 3L);
    assertEquals("International Films", requireNonNull(response.getBody()).getCategory().getCategoryName());
    Set<Subscription> subscriptions = subject.getAllSubscriptionsByCustomerId(3L).getBody();
    assert subscriptions != null;
    assertEquals(1, subscriptions.size());
  }
}
