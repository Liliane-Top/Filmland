package nl.filmland.repository;

import nl.filmland.model.CustomerSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerSubscriptionDao extends JpaRepository<CustomerSubscription, Long> {

}
