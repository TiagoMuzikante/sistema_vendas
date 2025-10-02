package space.vendas.sistema.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import space.vendas.sistema.enums.EventEnum;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "event")
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Evento {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 150)
  private String name;

  @Column(nullable = false, length = 500)
  private String description;

  @Column(nullable = false)
  @Enumerated(EnumType.ORDINAL)
  private EventEnum type;

  @Column(nullable = false, length = 150)
  private String address;

  @Column(nullable = false)
  private LocalDateTime dateStart;

  @Column(nullable = false)
  private LocalDateTime dateEnd;

  @Column(nullable = true)
  private String linkEvent;

  @Column(nullable = true)
  private String linkImage;

  @CreatedDate
  @Column(updatable = false, nullable = false)
  private LocalDateTime createdAt;

  @LastModifiedDate
  @Column(updatable = true, nullable = false)
  private LocalDateTime updatedAt;

  @OneToMany(mappedBy = "event")
  private List<Inscription> inscriptions;

}