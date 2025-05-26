package br.com.fiap.baitersburger.core.application.usecase.customer;

import br.com.fiap.baitersburger.core.domain.model.Customer;
import br.com.fiap.baitersburger.core.application.ports.in.customer.InsertCustomerInputPort;
import br.com.fiap.baitersburger.core.domain.ports.out.customer.FindCustomerByCpfOutputPort;
import br.com.fiap.baitersburger.core.domain.ports.out.customer.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final InsertCustomerOutputPort insertCustomerOutputPort;
    private final FindCustomerByCpfOutputPort findCustomerByCpfOutputPort;

    public InsertCustomerUseCase(InsertCustomerOutputPort insertCustomerOutputPort,
                                 FindCustomerByCpfOutputPort findCustomerByCpfOutputPort) {
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.findCustomerByCpfOutputPort = findCustomerByCpfOutputPort;
    }


    @Override
    public void insert(Customer newCustomer) {
       var customer = findCustomerByCpfOutputPort.find(newCustomer.getCpf());
       if (customer.isPresent()) {
           throw new RuntimeException("Customer already exists");
       }
        insertCustomerOutputPort.insert(newCustomer);
    }
}
