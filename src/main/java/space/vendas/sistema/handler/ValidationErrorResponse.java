package space.vendas.sistema.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
@Builder
public class ValidationErrorResponse {

  private Integer status;
  private String message;
  private Map<String, String> errors;



}
