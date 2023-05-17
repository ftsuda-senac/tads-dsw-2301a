package br.senac.tads.dsw.dadospessoais;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RepeticaoSenhaValidator
        implements ConstraintValidator<RepeticaoSenha, Senha> {
    @Override
    public boolean isValid(Senha senha, ConstraintValidatorContext context) {
        return senha.getValor().equals(senha.getRepeticao());
    }
}
