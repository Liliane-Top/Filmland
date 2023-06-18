package nl.filmland.service;

import lombok.RequiredArgsConstructor;
import nl.filmland.model.Customer;
import nl.filmland.repository.CustomerDao;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService implements UserDetailsService {

  private final CustomerDao customerDao;

  public Customer findCustomer(String emailAsUsername) {
    return customerDao.findCustomerByEmailAsUsername(emailAsUsername);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return findCustomer(username);
  }

  public void addCustomer(Customer newCustomer) {
    customerDao.save( Customer.builder()
        .emailAsUsername(newCustomer.getEmailAsUsername())
        .password(newCustomer.getPassword())
        .build());
  }


}
