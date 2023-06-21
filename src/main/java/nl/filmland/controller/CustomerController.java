package nl.filmland.controller;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;
import lombok.RequiredArgsConstructor;
import nl.filmland.model.Customer;
import nl.filmland.repository.CustomerDao;
import nl.filmland.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerService customerService;

  @PostMapping(produces = "application/json", path = "/register")
  public ResponseEntity<String> registerUser(@RequestBody Customer newCustomer) {

    var response = customerService.findCustomer(newCustomer.getEmailAsUsername());

    if (response != null) {
      return new ResponseEntity<>("User registration failed", BAD_REQUEST);
    }
    return new ResponseEntity<>("User registration successful", CREATED);
  }

}
