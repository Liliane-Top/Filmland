package nl.filmland.filmland.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Customer_Subscription")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerSubscription implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "customer_subscription_id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @ManyToOne
  @JoinColumn(name = "subscription_id")
  private Subscription subscription;

  //TODO: add a timestamp as a subscription is only valid for 1 month and first month is free

}
