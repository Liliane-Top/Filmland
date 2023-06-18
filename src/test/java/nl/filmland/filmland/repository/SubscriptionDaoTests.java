package nl.filmland.filmland.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SubscriptionDaoTests {

  @Autowired
  SubscriptionDao subject;

  @Test
  void getAllSubscriptions() {
    var response = subject.findAll();
    assertEquals(3, response.size());
  }
}
