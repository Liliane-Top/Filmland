package nl.filmland.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginDto {

  private String emailAsUsername;
  private String password;

}
