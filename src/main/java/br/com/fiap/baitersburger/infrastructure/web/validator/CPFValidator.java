package br.com.fiap.baitersburger.infrastructure.web.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class CPFValidator implements ConstraintValidator<ValidCPF, String> {
    @Override
    public void initialize(ValidCPF constraintAnnotation) {
    }

    // Método de validação
    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        if (cpf == null || cpf.isEmpty()) {
            return false;
        }

        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            return false;
        }

        int sum = 0;
        int weight = 10;
        for (int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0') * weight--;
        }
        int firstDigit = sum % 11;
        firstDigit = (firstDigit < 2) ? 0 : 11 - firstDigit;
        if (cpf.charAt(9) - '0' != firstDigit) {
            return false;
        }

        sum = 0;
        weight = 11;
        for (int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0') * weight--;
        }
        int secondDigit = sum % 11;
        secondDigit = (secondDigit < 2) ? 0 : 11 - secondDigit;
        return cpf.charAt(10) - '0' == secondDigit;
    }
}
