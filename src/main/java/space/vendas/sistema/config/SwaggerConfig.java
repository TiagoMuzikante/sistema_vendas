package space.vendas.sistema.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI eventManagerOpenAPI(){
    return new OpenAPI()
        .info(new Info()
            .title("EventManager API")
            .version("1.0.0")
            .description("Documentação gerada automaticamente para o projeto EventManager.")
            .contact(new Contact().name("Tiago").email("tiago@hotmail.com"))
        );
  }

}
