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
        .authorizeHttpRequests(
            (requests -> requests.requestMatchers("/", "/heartbeat", "/login")
                .permitAll()
                .anyRequest()
                .authenticated()));
    return http.build();
  }

  //FIXME: authorization is not persisted

//  @Bean
//  public DataSource dataSource() {
//    return new EmbeddedDatabaseBuilder()
//        .setType(EmbeddedDatabaseType.H2)
//        .addScript("data.sql")
//        .build();
//  }

//  @Bean
//  public UserDetailsManager users(DataSource dataSource) {
//    UserDetails user = User.withDefaultPasswordEncoder()
//        .username("emailAsUsername")
//        .password("password")
////        .roles("USER")
//        .build();
//    JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//    users.createUser(user);
//    return users;
//  }


}
