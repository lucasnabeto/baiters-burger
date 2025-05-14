package br.com.fiap.baitersburger.application.core.usecase.customer;

import br.com.fiap.baitersburger.application.core.domain.Customer;
import br.com.fiap.baitersburger.application.ports.in.customer.InsertCustomerInputPort;
import br.com.fiap.baitersburger.application.ports.out.customer.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustomerUseCase(InsertCustomerOutputPort insertCustomerOutputPort) {
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }


    @Override
    public void insert(Customer customer) {
        insertCustomerOutputPort.insert(customer);
    }
}
