package nl.filmland.filmland.repository;

import jakarta.transaction.Transactional;
import java.util.Set;
import nl.filmland.filmland.model.Customer;
import nl.filmland.filmland.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {

  Customer findCustomerByEmailAsUsername(String emailAsUsername);

  Customer findCustomerById(Long id);

  Boolean existsByEmailAsUsername(String emailAsUsername);

  //FIXME: this query throws np
  @Transactional
  @Modifying
  @Query("update Customer c set c.subscriptions = ?2 where c.emailAsUsername = ?1")
  void updateCustomer(String emailAsUsername, Set<Subscription> subscriptions);


}
