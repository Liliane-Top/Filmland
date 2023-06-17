package nl.filmland.filmland.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "customer_id")
  private Long id;

  @NotBlank
  @Email
  @Column(name = "email_as_username", unique = true)
  private String emailAsUsername;

  @NotBlank
  @Size(max = 120)
  private String password;
  @ManyToMany(fetch = FetchType.EAGER, mappedBy = "customers", cascade = CascadeType.PERSIST)
  private Set<Subscription> subscriptions = new HashSet<>();

}
