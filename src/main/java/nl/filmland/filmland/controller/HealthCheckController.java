package nl.filmland.filmland.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

  @GetMapping(produces = "text/plain", path = "/heartbeat")
  ResponseEntity<String> get() {
    return ResponseEntity.ok("Pong!");
  }

}
