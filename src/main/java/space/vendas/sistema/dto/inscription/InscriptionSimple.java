package space.vendas.sistema.dto.inscription;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InscriptionSimple {

  private Long id;
  private String event_name;
  private String user_name;
  private Date inscription_date;

}
