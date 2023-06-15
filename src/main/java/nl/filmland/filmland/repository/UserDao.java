package nl.filmland.filmland.repository;

import nl.filmland.filmland.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

  User findUserByEmailAsUsername(String emailAsUsername);

  User findUserById(Long id);

  Boolean existsByEmailAsUsername(String emailAsUsername);

}
