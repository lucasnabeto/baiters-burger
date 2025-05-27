package br.com.fiap.baitersburger.core.application.usecase.customer;

import br.com.fiap.baitersburger.core.domain.model.Customer;
import br.com.fiap.baitersburger.core.application.ports.in.customer.InsertCustomerInputPort;
import br.com.fiap.baitersburger.core.domain.ports.out.customer.FindCustomerByCpfOutputPort;
import br.com.fiap.baitersburger.core.domain.ports.out.customer.FindCustomerByEmailOutputPort;
import br.com.fiap.baitersburger.core.domain.ports.out.customer.InsertCustomerOutputPort;
import br.com.fiap.baitersburger.core.exceptions.CustomerAlreadyExistsException;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final InsertCustomerOutputPort insertCustomerOutputPort;
    private final FindCustomerByCpfOutputPort findCustomerByCpfOutputPort;
    private final FindCustomerByEmailOutputPort findCustomerByEmailOutputPort;

    public InsertCustomerUseCase(InsertCustomerOutputPort insertCustomerOutputPort,
                                 FindCustomerByCpfOutputPort findCustomerByCpfOutputPort,
                                 FindCustomerByEmailOutputPort findCustomerByEmailOutputPort) {
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.findCustomerByCpfOutputPort = findCustomerByCpfOutputPort;
        this.findCustomerByEmailOutputPort = findCustomerByEmailOutputPort;
    }


    @Override
    public void insert(Customer newCustomer) {
       var customer = findCustomerByCpfOutputPort.find(newCustomer.getCpf());
       if (customer.isPresent()) {
           throw new CustomerAlreadyExistsException("Customer already exists");
       }
       var customerByEmail = findCustomerByEmailOutputPort.findByEmail(newCustomer.getEmail());
       if (customerByEmail.isPresent()) {
           throw new CustomerAlreadyExistsException("Customer with this email already exists");
    }
        insertCustomerOutputPort.insert(newCustomer);
       }
}
