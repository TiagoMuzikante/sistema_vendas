package space.vendas.sistema.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
  private UUID id;
  @Column(nullable = false, unique = true)
  private String email;
  @Column(nullable = false)
  private String password;
  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private String phone_number;
  @Column(nullable = false, unique = true)
  private String document_cpf;
  @Column(nullable = false)
  private UserType type;
  @Column(nullable = false)
  private Date birthday;
  private LocalDateTime created_at;
  private LocalDateTime updated_at;

  @OneToMany(mappedBy = "user")
  private List<Inscription> inscriptions;

}
