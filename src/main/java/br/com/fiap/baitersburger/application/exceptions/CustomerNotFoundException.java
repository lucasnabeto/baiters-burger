package br.com.fiap.baitersburger.application.exceptions;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException() {
        super("Cliente não encontrado.");
    }

}
