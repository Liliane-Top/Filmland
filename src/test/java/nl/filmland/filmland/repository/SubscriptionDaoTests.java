package nl.filmland.filmland.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import nl.filmland.filmland.model.Subscription;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SubscriptionDaoTests {

  @Autowired
  SubscriptionDao subject;

  @Autowired
  CustomerDao customerDao;

  @Test
  void getAllSubscriptions(){
    var response = subject.findAll();
    assertEquals(3, response.size());

  }
  @Test
  void getAllSubscriptionsPerCustomer(){
    var response = subject.findByCustomers(customerDao.findCustomerById(4L));
    Assertions.assertEquals(2 , response.size());
  }

}
