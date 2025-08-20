package space.vendas.sistema.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import space.vendas.sistema.domain.UserType;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPostDTO {
  private String email;
  private String password;
  private String name;
  private String phone_number;
  private String document_cpf;
  private UserType type;
  private Date birthday;
  private LocalDateTime created_at;
  private LocalDateTime updated_at;

  {
    this.created_at = LocalDateTime.now();
    this.updated_at = LocalDateTime.now();
  }

}
