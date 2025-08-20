package space.vendas.sistema.dto.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import space.vendas.sistema.domain.EventEnum;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventPostDTO {
  private String name;
  private String description;
  private EventEnum type;
  private String address;
  private Date date_start;
  private Date date_end;
  private String link_event;
  private String link_image;
  private LocalDateTime created_at;
  private LocalDateTime updated_at;

  {
    this.created_at = LocalDateTime.now();
    this.updated_at = LocalDateTime.now();
  }

}
