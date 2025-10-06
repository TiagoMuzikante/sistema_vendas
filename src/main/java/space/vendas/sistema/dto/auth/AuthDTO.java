package space.vendas.sistema.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthDTO {

  @NotBlank(message = "O email precisa ser preenchido")
  private String email;
  @NotBlank(message = "A senha precisa ser preenchido")
  private String senha;

}
