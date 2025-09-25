package space.vendas.sistema.dto.inscription;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InscriptionDTO {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private Long id;
  
  @NotNull(message = "O ID no evento precisa ser preenchido")
  private Long event_id;
  @NotNull(message = "O ID no usuario precisa ser preenchido")
  private Long user_id;


}
