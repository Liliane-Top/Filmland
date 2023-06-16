package nl.filmland.filmland.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import nl.filmland.filmland.model.Subscription;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SubscriptionServiceTest {

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
    List<Subscription> response = new ArrayList<>(subscriptions);
    assertEquals(2, subscriptions.size());
    assertEquals("Dutch Films", response.get(0).getCategory().getCategoryName());
    assertEquals(5, response.get(1).getMaxToWatch());
    assertEquals("2023-06-16 00:00:00.0", response.get(1).getStartDate().toString());
    assertEquals(4.0, response.get(0).getCategory().getCategoryPrice());
  }


}
