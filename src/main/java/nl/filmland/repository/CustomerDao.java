package nl.filmland.repository;

import nl.filmland.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {

  Customer findCustomerByEmailAsUsername(String emailAsUsername);

  Customer findCustomerById(Long id);

  Boolean existsByEmailAsUsername(String emailAsUsername);

}
