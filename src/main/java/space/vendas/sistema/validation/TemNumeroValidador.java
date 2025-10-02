package space.vendas.sistema.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TemNumeroValidador implements ConstraintValidator<DeveTerNumeros, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if(value == null || value.isEmpty()) return false;
    return value.matches(".*\\d.");
  }


}
