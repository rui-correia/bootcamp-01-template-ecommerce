package br.com.braz.rui.bootcamp01.mercadolivre.annotation;

import br.com.braz.rui.bootcamp01.mercadolivre.config.validator.ExisteCadastradoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ExisteCadastradoValidator.class)
public @interface ExisteCadastrado {

    String message() default "não existe no banco.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName();

    Class<?> domainClass();
}
