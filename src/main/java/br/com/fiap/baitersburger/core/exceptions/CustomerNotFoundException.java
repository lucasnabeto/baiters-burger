package br.com.fiap.baitersburger.core.exceptions;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException() {
        super("Cliente não encontrado.");
    }

}
