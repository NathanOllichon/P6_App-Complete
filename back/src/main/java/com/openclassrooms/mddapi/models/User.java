package com.openclassrooms.mddapi.models;

import lombok.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity(name = "user")
@Table(name = "user", uniqueConstraints = {
    @UniqueConstraint(columnNames = "email")
})
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  //@Email
  @NonNull
  @Size(max = 50)
  @Column(name = "email")
  private String email;

  @NonNull
  @Size(max = 50)
  @Column(name = "username")
  private String username;

  @NonNull
  @Size(max = 50)
  @Column(name = "password")
  private String password;

  @OneToMany(
          mappedBy = "user",
          cascade = CascadeType.ALL,
  fetch = FetchType.LAZY)
  private List<Subscription> themes;

}
