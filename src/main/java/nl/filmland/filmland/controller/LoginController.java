package nl.filmland.filmland.controller;

import lombok.RequiredArgsConstructor;
import nl.filmland.dto.LoginDto;
import nl.filmland.filmland.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

  private final LoginService loginService;

  @PostMapping(produces = "application/json", path = "/login_test")
  public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
    boolean isLoginSuccessful = loginService.validateUser(loginDto);

    if (!isLoginSuccessful) {
      return new ResponseEntity<>("Customer login failed", HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity<>("Customer login successful", HttpStatus.OK);
  }
}
