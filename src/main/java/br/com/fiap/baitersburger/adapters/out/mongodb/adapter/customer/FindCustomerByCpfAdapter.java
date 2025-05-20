package br.com.fiap.baitersburger.adapters.out.mongodb.adapter.customer;

import br.com.fiap.baitersburger.adapters.out.mongodb.repository.CustomerRepository;
import br.com.fiap.baitersburger.adapters.out.mongodb.repository.mappers.CustomerEntityMapper;
import br.com.fiap.baitersburger.core.domain.model.Customer;
import br.com.fiap.baitersburger.core.domain.ports.out.customer.FindCustomerByCpfOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByCpfAdapter implements FindCustomerByCpfOutputPort {

    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper customerEntityMapper;

    public FindCustomerByCpfAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public Optional<Customer> find(String cpf) {
        var customerEntity = customerRepository.findByCpf(cpf);
        return customerEntity.map(customerEntityMapper::toCustomer);
    }
}
