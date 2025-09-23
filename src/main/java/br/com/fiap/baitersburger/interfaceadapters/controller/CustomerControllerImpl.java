package br.com.fiap.baitersburger.interfaceadapters.controller;

import br.com.fiap.baitersburger.interfaceadapters.dto.request.CustomerRequestDTO;
import br.com.fiap.baitersburger.interfaceadapters.dto.response.CustomerResponseDTO;
import br.com.fiap.baitersburger.application.usecase.customer.FindCustomerByCpfUseCaseImpl;
import br.com.fiap.baitersburger.application.usecase.customer.InsertCustomerUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.in.controller.CustomerController;
import br.com.fiap.baitersburger.domain.port.in.usecase.customer.FindCustomerByCpfUseCase;
import br.com.fiap.baitersburger.domain.port.out.gateway.CustomerGateway;
import br.com.fiap.baitersburger.domain.port.out.repository.CustomerDataSource;
import br.com.fiap.baitersburger.interfaceadapters.presenter.CustomerPresenter;
import br.com.fiap.baitersburger.interfaceadapters.gateway.CustomerGatewayImpl;

public class CustomerControllerImpl implements CustomerController {

    private final CustomerPresenter customerPresenter;
    private final FindCustomerByCpfUseCase findCustomerByCpfUseCase;
    private final InsertCustomerUseCaseImpl insertCustomerUseCaseImpl;

    public CustomerControllerImpl(CustomerPresenter customerPresenter, CustomerDataSource dataSource) {
        this.customerPresenter = customerPresenter;
        CustomerGateway gateway = new CustomerGatewayImpl(dataSource);

        this.findCustomerByCpfUseCase = new FindCustomerByCpfUseCaseImpl(gateway);
        this.insertCustomerUseCaseImpl = new InsertCustomerUseCaseImpl(gateway);
    }

    @Override
    public CustomerResponseDTO find(String cpf) {
        var customer = findCustomerByCpfUseCase.find(cpf);

        return customerPresenter.toCustomerResponseDTO(customer);

    }

    @Override
    public void insert(CustomerRequestDTO dto) {

        var customer = customerPresenter.toCustomer(dto);
        this.insertCustomerUseCaseImpl.insert(customer);
    }
}
