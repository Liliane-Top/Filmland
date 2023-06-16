package nl.filmland.filmland.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Subscription")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subscription {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "subscription_id")
  private Long id;
  @NotBlank
  @Column(name = "start_date")
  private Date startDate;
  @NotBlank
  @Column(name = "max_to_watch")
  private Integer maxToWatch;
  @NotBlank
  @OneToOne
  @JoinColumn(name = "category_id", referencedColumnName = "category_id")
  private Category category;

  // @ManyToMany(cascade = CascadeType.ALL)
  //    @JoinTable(
  //            name = "USERS_GROUPS",
  //            joinColumns = @JoinColumn(name = "GROUP_ID"),
  //            inverseJoinColumns = @JoinColumn(name = "USER_ID")
  //    )
  //    public Set<User> getUsers() {

  @ManyToMany
  @JoinTable(name = "Customer_Subscription",
      joinColumns = @JoinColumn(name = "subscription_id"),
      inverseJoinColumns = @JoinColumn(name = "customer_id"))
  private Set<Customer> customers = new HashSet<>();

}
