package br.senac.tads.dsw.dadospessoais;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RepeticaoSenhaValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RepeticaoSenha {

    String message() default "A senha e a repetição devem ser iguais";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
