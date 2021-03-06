package br.com.braz.rui.bootcamp01.mercadolivre.annotation;

import br.com.braz.rui.bootcamp01.mercadolivre.config.validator.NomeUnicoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NomeUnicoValidator.class)
public @interface NomeUnico {

    String message() default "Já cadastrado no banco.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName();

    Class<?> domainClass();

}
