package br.com.fiap.baitersburger.adapters.out;

import br.com.fiap.baitersburger.adapters.out.repository.CustomerRepository;
import br.com.fiap.baitersburger.adapters.out.repository.mappers.CustomerEntityMapper;
import br.com.fiap.baitersburger.application.core.domain.Customer;
import br.com.fiap.baitersburger.application.ports.out.customer.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }

}
