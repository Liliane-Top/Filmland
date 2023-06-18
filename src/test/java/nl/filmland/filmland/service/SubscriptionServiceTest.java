package nl.filmland.filmland.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import nl.filmland.model.Subscription;
import nl.filmland.service.SubscriptionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SubscriptionServiceTest {

  //FIXME: create a setup and breakdown after each test


  @Autowired
  SubscriptionService subject;

  @Test
  void getAllSubscriptions() {
    var subscriptions = subject.getAllSubscriptions();
    assertEquals(3, subscriptions.size());
  }

  @Test
  void getAllSubscriptionsByUsername() {
    Set<Subscription> subscriptions = subject.getAllSubscriptionsByUsername("Italy@gmail.com");
    List<Subscription> response = subscriptions.stream()
        .sorted(Comparator.comparing(Subscription::getId)).toList();
    assertEquals(2, subscriptions.size());
    assertEquals("Dutch Films", response.get(0).getCategory().getCategoryName());
    assertEquals(5, response.get(1).getMaxToWatch());
    assertEquals(4.0, response.get(0).getCategory().getCategoryPrice());
  }


}
