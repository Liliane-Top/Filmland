package nl.filmland.filmland.service;

import lombok.RequiredArgsConstructor;
import nl.filmland.filmland.model.Customer;
import nl.filmland.filmland.repository.CustomerDao;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

  private final CustomerDao customerDao;

  public Customer findCustomer(String emailAsUsername) {
    return customerDao.findCustomerByEmailAsUsername(emailAsUsername);
  }
}
