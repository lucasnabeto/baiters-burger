package br.com.fiap.baitersburger.adapters.out.mongodb.adapter.customer;

import br.com.fiap.baitersburger.adapters.out.mongodb.repository.CustomerRepository;
import br.com.fiap.baitersburger.adapters.out.mongodb.repository.mappers.CustomerEntityMapper;
import br.com.fiap.baitersburger.core.domain.model.Customer;
import br.com.fiap.baitersburger.core.domain.ports.out.customer.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper customerEntityMapper;

    public InsertCustomerAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public void insert(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.insert(customerEntity);
    }
}
