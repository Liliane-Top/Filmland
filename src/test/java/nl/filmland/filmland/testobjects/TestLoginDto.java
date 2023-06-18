package nl.filmland.filmland.testobjects;

import nl.filmland.dto.LoginDto;

public class TestLoginDto {

  public static LoginDto createUnknownUser() {
    return LoginDto.builder().build();
  }

  public static LoginDto createUserWithInvalidPassword() {
    return LoginDto.builder()
        .emailAsUsername("Italy@gmail.com")
        .password("12345").build();
  }

  public static LoginDto createUserWithValidPassword() {
    return LoginDto.builder()
        .emailAsUsername("Italy@gmail.com")
        .password("45678").build();
  }


  public static LoginDto createUserWithInvalidUsername() {
    return LoginDto.builder()
        .emailAsUsername("LilianeTop")
        .password("45678").build();
  }
}
