package nl.filmland.filmland.testobjects;

import nl.filmland.model.Customer;

public class TestCustomer {

  public static Customer createTestCustomer() {
    return Customer.builder()
        .emailAsUsername("Holland@gmail.com")
        .password("12345")
        .build();
  }

}
