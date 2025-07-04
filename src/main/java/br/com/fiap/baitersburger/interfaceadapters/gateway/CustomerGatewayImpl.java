package br.com.fiap.baitersburger.interfaceadapters.gateway;

import br.com.fiap.baitersburger.domain.model.Customer;
import br.com.fiap.baitersburger.domain.port.out.gateway.CustomerGateway;
import br.com.fiap.baitersburger.domain.port.out.repository.CustomerDataSource;

import java.util.Optional;

public class CustomerGatewayImpl implements CustomerGateway {
    private final CustomerDataSource dataSource;

    public CustomerGatewayImpl(CustomerDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Customer customer) {
        this.dataSource.insert(customer);
    }

    @Override
    public Optional<Customer> findByCpf(String cpf) {
        return this.dataSource.findByCpf(cpf);
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return this.dataSource.findByEmail(email);
    }
}
