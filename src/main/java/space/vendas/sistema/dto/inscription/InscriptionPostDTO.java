package space.vendas.sistema.dto.inscription;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import space.vendas.sistema.domain.paymentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InscriptionPostDTO {

  private Long event_id;
  private UUID user_id;
  private paymentStatus paymentStatus;
  private LocalDateTime created_at;
  private LocalDateTime updated_at;

  {
    this.created_at = LocalDateTime.now();
    this.updated_at = LocalDateTime.now();
  }

}
