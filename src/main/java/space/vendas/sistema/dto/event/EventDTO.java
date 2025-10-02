package space.vendas.sistema.dto.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import space.vendas.sistema.enums.EventEnum;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventDTO {
  @NotBlank(message = "O nome deve ser preenchido.")
  @Size(max = 150, message = "O nome deve ter no maximo 150 caracteres.")
  private String name;

  @NotBlank(message = "A descrição deve ser preenchido.")
  @Size(max = 150, message = "A descrição deve ter no maximo 500 caracteres.")
  private String description;

  @NotNull(message = "O tipo do evento deve ser preenchido.")
  private EventEnum type;

  @NotBlank(message = "O endereço deve ser preenchido.")
  @Size(max = 150, message = "O endereço deve ter no maximo 150 caracteres.")
  private String address;

  @NotNull(message = "A data de inicio do evento deve ser preenchido.")
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
  private LocalDateTime dateStart;

  @NotNull(message = "A data de finalização do evento deve ser preenchido.")
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
  private LocalDateTime dateEnd;

  private String linkEvent;
  private String linkImage;

}
