package nl.filmland.filmland.controller;

import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import nl.filmland.filmland.model.Customer;
import nl.filmland.filmland.model.Subscription;
import nl.filmland.filmland.service.CustomerService;
import nl.filmland.filmland.service.SubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class SubscriptionController {

  private final SubscriptionService subscriptionService;
  private final CustomerService customerService;

  @GetMapping(produces = "application/json", path = "/subscription")
  public ResponseEntity<List<Subscription>> getAllSubscriptions() {
    var subscriptions = subscriptionService.getAllSubscriptions();
    if (subscriptions.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(subscriptions);
  }

  @GetMapping(produces = "application/json", path = "/subscription/{email_as_username}")
  public ResponseEntity<Set<Subscription>> getAllSubscriptionsByUserName(
      @PathVariable("email_as_username") String emailAsUsername) {
    var subscriptions = subscriptionService.getAllSubscriptionsByUsername(emailAsUsername);
    if (subscriptions.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(subscriptions);
  }

  @PostMapping(produces = "application/json", path = "/subscription/{email_as_username}/{subscription_id}")
  public ResponseEntity<Subscription> addSubscription(
      @PathVariable("email_as_username") String emailAsUsername,
      @PathVariable("subscription_id") Long id) {
    Subscription subscription = subscriptionService.findSubscription(id);
    Customer customer = customerService.findCustomer(emailAsUsername);
    subscriptionService.addSubscription(customer, subscription);
    return new ResponseEntity<>(subscription, HttpStatus.CREATED);
  }
}
