package br.com.fiap.baitersburger.application.core.domain;

public class Customer {

    private String cpf;
    private String name;
    private String email;

    public Customer(final String id, final String cpf, final String name, final String email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
