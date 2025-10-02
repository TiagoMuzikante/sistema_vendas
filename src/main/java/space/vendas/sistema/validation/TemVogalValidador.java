package space.vendas.sistema.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TemVogalValidador implements ConstraintValidator<DeveTerVogal, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value.toLowerCase().substring(value.length()-(value.length()%2!=0 ? 9 : 10)).matches("[aeiou].[aeiou].[aeiou].[aeiou].[aeiou]"+(value.length()%2==0?".":""));
  }
}
