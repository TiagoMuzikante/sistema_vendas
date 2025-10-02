package space.vendas.sistema.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TemNumeroValidador.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface DeveTerNumeros {

  String message() default "A senha deve conter pelo menos 1 numero.";

  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};


}
