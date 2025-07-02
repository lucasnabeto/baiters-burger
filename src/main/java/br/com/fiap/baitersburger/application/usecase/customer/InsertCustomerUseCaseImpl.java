package br.com.fiap.baitersburger.application.usecase.customer;

import br.com.fiap.baitersburger.domain.model.Customer;
import br.com.fiap.baitersburger.domain.port.in.usecase.customer.InsertCustomerUseCase;
import br.com.fiap.baitersburger.domain.port.out.repository.CustomerRepository;
import br.com.fiap.baitersburger.domain.exception.CustomerAlreadyExistsException;

public class InsertCustomerUseCaseImpl implements InsertCustomerUseCase {

    private final CustomerRepository customerRepository;

    public InsertCustomerUseCaseImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void insert(Customer newCustomer) {
       var customer = customerRepository.findByCpf(newCustomer.getCpf());

       if (customer.isPresent()) {
           throw new CustomerAlreadyExistsException("Customer already exists");
       }

       var customerByEmail = customerRepository.findByEmail(newCustomer.getEmail());

       if (customerByEmail.isPresent()) {
           throw new CustomerAlreadyExistsException("Customer with this email already exists");
        }

        customerRepository.insert(newCustomer);
    }
}
