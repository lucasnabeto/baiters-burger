package br.com.fiap.baitersburger.adapters.out;

import br.com.fiap.baitersburger.adapters.out.repository.CustomerRepository;
import br.com.fiap.baitersburger.adapters.out.repository.mappers.CustomerEntityMapper;
import br.com.fiap.baitersburger.application.core.domain.Customer;
import br.com.fiap.baitersburger.application.ports.out.FindCustomerByCpfOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByCpfAdapter implements FindCustomerByCpfOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;



    @Override
    public Optional<Customer> find(String cpf) {
        var customerEntity = customerRepository.findByCpf(cpf);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
