package nl.filmland.filmland.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import nl.filmland.filmland.model.Customer;
import nl.filmland.filmland.model.Subscription;
import nl.filmland.filmland.repository.CustomerDao;
import nl.filmland.filmland.repository.SubscriptionDao;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

  private final SubscriptionDao subscriptionDao;
  private final CustomerDao customerDao;

  public List<Subscription> getAllSubscriptions() {
    return subscriptionDao.findAll();
  }

  public Set<Subscription> getAllSubscriptionsByCustomer(Long id) {
    return subscriptionDao.findByCustomers(customerDao.findCustomerById(id));
  }

  public Set<Subscription> getAllSubscriptionsByUsername(String emailAsUsername) {
    return subscriptionDao.findByCustomers(
        customerDao.findCustomerByEmailAsUsername(emailAsUsername));
  }

  public void addSubscription(Customer customer, Subscription subscription) {
    Set<Subscription> subscriptions = new HashSet<>(customer.getSubscriptions());
    subscriptions.add(subscription);
    customerDao.updateCustomer(customer.getEmailAsUsername(), subscriptions);
  }
}
