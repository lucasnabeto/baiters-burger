package br.com.fiap.baitersburger.adapters.in.controller.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// A anotação de validação personalizada para CPF
@Constraint(validatedBy = CPFValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCPF {

    // Mensagem de erro padrão
    String message() default "CPF inválido";

    // Grupos de validação, útil para agrupamentos de regras
    Class<?>[] groups() default {};

    // Carregar informações adicionais sobre a carga útil
    Class<? extends Payload>[] payload() default {};
}
