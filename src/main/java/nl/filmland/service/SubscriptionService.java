package nl.filmland.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import nl.filmland.model.Customer;
import nl.filmland.model.CustomerSubscription;
import nl.filmland.model.Subscription;
import nl.filmland.repository.CustomerDao;
import nl.filmland.repository.CustomerSubscriptionDao;
import nl.filmland.repository.SubscriptionDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

  private final SubscriptionDao subscriptionDao;
  private final CustomerDao customerDao;
  private final CustomerSubscriptionDao customerSubscriptionDao;

  public List<Subscription> getAllSubscriptions() {
    return subscriptionDao.findAll();
  }

  @Transactional
  public Set<Subscription> getAllSubscriptionsByUsername(String emailAsUsername) {
    return Optional.ofNullable(customerDao.findCustomerByEmailAsUsername(emailAsUsername))
        .map(customer -> customer.getSubscriptions()
            .stream()
            .map(CustomerSubscription::getSubscription)
            .collect(Collectors.toSet()))
        .orElse(Set.of());
  }

  public void addSubscription(Customer customer, Subscription subscription) {
    var customerSubscription = CustomerSubscription.builder()
        .customer(customer)
        .subscription(subscription)
        .build();
    customerSubscriptionDao.save(customerSubscription);
  }

  public Subscription findSubscription(Long id) {
    return subscriptionDao.findSubscriptionsById(id);
  }
}
