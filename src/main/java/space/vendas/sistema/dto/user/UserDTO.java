package space.vendas.sistema.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import space.vendas.sistema.enums.UserType;
import space.vendas.sistema.validation.DeveTerNumeros;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

  @NotBlank(message = "O nome precisa ser preenchido")
  @Size(min = 3, max = 150, message = "O nome deve ter no maximo 150 caracteres")
  private String name;

  @Email(message = "O email é invalido")
  @NotBlank(message = "O email precisa ser preenchido")
  @Size(min = 10, max = 150, message = "O email deve ter no maximo 150 caracteres")
  private String email;

  @DeveTerNumeros
  @NotBlank(message = "a senha precisa ser preenchida")
  @Size(min = 6, max = 150, message = "O email deve ter entre 6 e 150 caracteres")
  private String password;

  @NotBlank(message = "a senha precisa ser preenchida")
  @Size(min = 14, max = 20, message = "O numero de telefone deve ter entre 14 e 20 caracteres")
  @JsonFormat(pattern = "## #####-####")
  private String phoneNumber;

  @NotBlank(message = "O CPF precisa ser preenchido")
  @CPF
  private String documentCpf;

  @NotNull(message = "O tipo de usuario precisa ser preenchido")
  private UserType type;

  @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
  @NotNull(message = "A daa de aniversario precisa ser preenchida")
  private LocalDateTime birthday;

}
