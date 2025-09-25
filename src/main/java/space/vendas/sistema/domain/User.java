package space.vendas.sistema.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import space.vendas.sistema.enums.UserType;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true, length = 150)
  private String email;

  @Column(nullable = false, length = 150)
  private String password;

  @Column(nullable = false, length = 150)
  private String name;

  @Column(nullable = false, length = 50)
  private String phoneNumber;

  @Column(nullable = false, unique = true)
  private String documentCpf;

  @Column(nullable = false)
  @Enumerated(EnumType.ORDINAL)
  private UserType type;

  @Column(nullable = false)
  private Date birthday;

  @CreatedDate
  @Column(updatable = false, nullable = false)
  private LocalDateTime createdAt;

  @LastModifiedDate
  @Column(updatable = true, nullable = false)
  private LocalDateTime updatedAt;

  @OneToMany(mappedBy = "user")
  private List<Inscription> inscriptions;

}
