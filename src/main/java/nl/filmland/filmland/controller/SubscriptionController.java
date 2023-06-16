package nl.filmland.filmland.controller;

import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import nl.filmland.filmland.model.Subscription;
import nl.filmland.filmland.service.SubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SubscriptionController {

  private final SubscriptionService subscriptionService;

  @GetMapping(produces = "application/json", path = "/subscription")
  public ResponseEntity<List<Subscription>> getAllSubscriptions() {
    var subscriptions = subscriptionService.getAllSubscriptions();
    if (subscriptions.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(subscriptions);
  }
//TODO: only validated customers can retrieve their subscriptions
  @GetMapping(produces = "application/json", path = "/subscription/{customer_id}")
  public ResponseEntity<Set<Subscription>> getAllSubscriptionsByCustomerId(
      @PathVariable("customer_id") Long id) {
    var subscriptions = subscriptionService.getAllSubscriptionsByCustomer(id);
    if (subscriptions.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(subscriptions);
  }

//TODO: only validated customers can retrieve their subscriptions
  @GetMapping(produces = "application/json", path = "/subscription/{email_as_username}")
  public ResponseEntity<Set<Subscription>> getAllSubscriptionsByUserName(
      @PathVariable("email_as_username") String emailAsUsername) {
    var subscriptions = subscriptionService.getAllSubscriptionsByUsername(emailAsUsername);
    if (subscriptions.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(subscriptions);
  }
}
