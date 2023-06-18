package nl.filmland.repository;

import java.util.List;
import nl.filmland.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionDao extends JpaRepository<Subscription, Long> {

  List<Subscription> findAll();

  Subscription findSubscriptionsById(Long id);


}
