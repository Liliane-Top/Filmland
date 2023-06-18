package nl.filmland.filmland.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(AbstractHttpConfigurer::disable)
        .cors(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests((requests -> requests.requestMatchers("/", "/heartbeat", "/login")
            .permitAll()
            .anyRequest()
            .authenticated()));
    return http.build();
  }


//  @Bean
//  public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
//    UserDetails user = User.withUsername("")
//        .password(passwordEncoder.encode(""))
//        .roles("User")
//        .build();
//    return new InMemoryUserDetailsManager(user);
//  }

//  @Bean
//  public BCryptPasswordEncoder passwordEncoder() {
//    return new BCryptPasswordEncoder();
//  }

}
