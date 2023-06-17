package nl.filmland.filmland.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;
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

  @OneToMany(mappedBy = "subscription")
  private Set<CustomerSubscription> customerSubscriptions;

}
