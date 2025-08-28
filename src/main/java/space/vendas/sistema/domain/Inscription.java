package space.vendas.sistema.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inscription {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "event_id", nullable = false)
  private Evento event;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  private paymentStatus paymentStatus;
  private LocalDateTime created_at;
  private LocalDateTime updated_at;

}
