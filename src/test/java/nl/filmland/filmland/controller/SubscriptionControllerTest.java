package nl.filmland.filmland.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;
import nl.filmland.filmland.model.Subscription;
import nl.filmland.filmland.repository.CustomerDao;
import nl.filmland.filmland.repository.SubscriptionDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest
public class SubscriptionControllerTest {

  @Autowired
  SubscriptionController subject;

  @Autowired
  CustomerDao customerDao;

  @Autowired
  SubscriptionDao subscriptionDao;

  @Test
  void call_getAllSubscriptions() {
    var response = subject.getAllSubscriptions();
    assertEquals(3, response.getBody().size());
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
    assertEquals(3, response.getBody().size());
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
    var response = subject.getAllSubscriptionsByUserName("Italy@gmail.com");
    assertEquals(2, response.getBody().size());
    assertEquals(HttpStatus.OK, response.getStatusCode());
  }

  @Test
  void call_addSubscription_with_valid_parameters() {
    //FIXME: returns error java.lang.NullPointerException: Cannot invoke "org.hibernate.sql.ast.tree.expression.Expression.getColumnReference()" because "pathSqlExpression" is null
    var response = subject.addSubscription("Italy@gmail.com", 3L);
    assertEquals("International Films", response.getBody().getCategory().getCategoryName());

    Set<Subscription> subscriptions = subject.getAllSubscriptionsByCustomerId(2L).getBody();
    //FIXME: why is this empty?
    assertEquals(1, subscriptions.size());
  }
}
