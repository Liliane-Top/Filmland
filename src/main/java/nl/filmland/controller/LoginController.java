package nl.filmland.controller;

import lombok.RequiredArgsConstructor;
import nl.filmland.dto.LoginDto;
import nl.filmland.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

  private final LoginService loginService;

  @PostMapping(produces = "application/json", path = "/login")
  public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
    boolean isLoginSuccessful = loginService.validateUser(loginDto);

    if (!isLoginSuccessful) {
      return new ResponseEntity<>("Customer login failed", HttpStatus.UNAUTHORIZED);
    }

    //FIXME: persist with either Token or with Spring Security

//    String token = Base64Coder.encodeString(loginDto.getEmailAsUsername() + "secret");
//    HttpHeaders responseHeaders = new HttpHeaders();
//    responseHeaders.set(HttpHeaders.AUTHORIZATION, token);
//    return new ResponseEntity<>("Customer login successful", responseHeaders, HttpStatus.OK);

    return new ResponseEntity<>("Customer login successful", HttpStatus.OK);
  }
}
