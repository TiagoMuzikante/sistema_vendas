package space.vendas.sistema.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = TemVogalValidador.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface DeveTerVogal {


  String message() default "A senha deve terminar com vogais nas ultimas 5 casas impares.";

  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};



}
