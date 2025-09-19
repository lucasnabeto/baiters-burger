package br.com.fiap.baitersburger.interfaceadapters.repository;

import br.com.fiap.baitersburger.domain.model.Customer;
import br.com.fiap.baitersburger.domain.port.out.repository.CustomerDataSource;
import br.com.fiap.baitersburger.infrastructure.persistence.mapper.CustomerEntityMapper;
import br.com.fiap.baitersburger.infrastructure.persistence.repository.CustomerMySqlRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CustomerDataSourceMySqlImpl implements CustomerDataSource {

    private final CustomerMySqlRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;


    public CustomerDataSourceMySqlImpl(CustomerMySqlRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public void insert(Customer customer) {
        var customerMySqlEntity = customerEntityMapper.toCustomerMySqlEntity(customer);
        customerMySqlEntity.setId(UUID.randomUUID().toString());
        customerRepository.save(customerMySqlEntity);
    }

    @Override
    public Optional<Customer> findByCpf(String cpf) {
        var customerMySqlEntity = customerRepository.findByCpf(cpf);
        return customerMySqlEntity.map(customerEntityMapper::toCustomer);
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        var customerMySqlEntity = customerRepository.findByEmail(email);
        return customerMySqlEntity.map(customerEntityMapper::toCustomer);
    }
}
