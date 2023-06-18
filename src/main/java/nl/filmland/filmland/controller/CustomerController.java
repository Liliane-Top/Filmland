package nl.filmland.filmland.controller;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

import lombok.RequiredArgsConstructor;
import nl.filmland.filmland.model.Customer;
import nl.filmland.filmland.repository.CustomerDao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerDao customerDao;


  @PostMapping(produces = "application/json", path = "/register")
  public ResponseEntity<String> registerUser(@RequestBody Customer newCustomer) {

    var response = customerDao.findAll()
        .stream()
        .filter(customer -> !customer.getEmailAsUsername().equals(newCustomer.getEmailAsUsername()))
        .map(customerDao::save).findFirst();

    if (response.isEmpty()) {
      return new ResponseEntity<>("user registration failed", BAD_REQUEST);
    }
    return new ResponseEntity<>("User registration successful", CREATED);
  }

}
