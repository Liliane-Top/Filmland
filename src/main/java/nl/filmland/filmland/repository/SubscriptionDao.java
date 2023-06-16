package nl.filmland.filmland.repository;

import java.util.List;
import java.util.Set;
import nl.filmland.filmland.model.Customer;
import nl.filmland.filmland.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionDao extends JpaRepository<Subscription, Long> {

  List<Subscription> findAll();
  Set<Subscription> findByCustomers(Customer customer);



}
