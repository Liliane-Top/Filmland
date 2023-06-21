package nl.filmland.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import nl.filmland.model.Customer;
import nl.filmland.model.MyUserPrincipal;
import nl.filmland.repository.CustomerDao;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService implements UserDetailsService {

  private final CustomerDao customerDao;

  private final PasswordEncoder passwordEncoder;

  public Customer findCustomer(String emailAsUsername) {
    return customerDao.findCustomerByEmailAsUsername(emailAsUsername)
        .orElse(null);
  }


  public Customer addCustomer(Customer newCustomer) {
    return customerDao.save(Customer.builder().emailAsUsername(newCustomer.getEmailAsUsername())
        .password(passwordEncoder.encode(newCustomer.getPassword()))
        .id(newCustomer.getId())
        .build());
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Optional<Customer> optionalCustomer = customerDao.findCustomerByEmailAsUsername(username);

    if (optionalCustomer.isEmpty()) {
      throw new UsernameNotFoundException("user with email: " + username + " not found");
    } else {
      return new MyUserPrincipal(optionalCustomer.get());
    }
  }


}
