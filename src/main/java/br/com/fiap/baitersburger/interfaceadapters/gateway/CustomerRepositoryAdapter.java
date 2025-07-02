package br.com.fiap.baitersburger.interfaceadapters.gateway;

import br.com.fiap.baitersburger.domain.model.Customer;
import br.com.fiap.baitersburger.domain.port.out.repository.CustomerRepository;
import br.com.fiap.baitersburger.infrastructure.persistence.mapper.CustomerEntityMapper;
import br.com.fiap.baitersburger.infrastructure.persistence.repository.CustomerMongoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerRepositoryAdapter implements CustomerRepository { // <= Implementa a porta do domínio

    private final CustomerMongoRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public CustomerRepositoryAdapter(CustomerMongoRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public void insert(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.insert(customerEntity);
    }

    @Override
    public Optional<Customer> findByCpf(String cpf) {
        var customerEntity = customerRepository.findByCpf(cpf);
        return customerEntity.map(customerEntityMapper::toCustomer);
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        var customerEntity = customerRepository.findByEmail(email);
        return customerEntity.map(customerEntityMapper::toCustomer);
    }
}
