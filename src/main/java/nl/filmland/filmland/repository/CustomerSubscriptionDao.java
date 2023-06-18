package nl.filmland.filmland.repository;

import nl.filmland.filmland.model.CustomerSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerSubscriptionDao extends JpaRepository<CustomerSubscription, Long> {

}
