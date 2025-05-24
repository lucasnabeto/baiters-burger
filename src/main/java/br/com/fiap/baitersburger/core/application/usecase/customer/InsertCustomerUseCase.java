package br.com.fiap.baitersburger.core.application.usecase.customer;

import br.com.fiap.baitersburger.core.domain.model.Customer;
import br.com.fiap.baitersburger.core.application.ports.in.customer.InsertCustomerInputPort;
import br.com.fiap.baitersburger.core.domain.ports.out.customer.InsertCustomerOutputPort;

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
