package br.com.fiap.baitersburger.interfaceadapters.controller;

import br.com.fiap.baitersburger.application.dto.request.CustomerRequestDTO;
import br.com.fiap.baitersburger.application.dto.response.CustomerResponseDTO;
import br.com.fiap.baitersburger.application.usecase.customer.FindCustomerByCpfUseCaseImpl;
import br.com.fiap.baitersburger.application.usecase.customer.InsertCustomerUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.in.controller.CustomerController;
import br.com.fiap.baitersburger.domain.port.in.usecase.customer.FindCustomerByCpfUseCase;
import br.com.fiap.baitersburger.domain.port.out.gateway.CustomerGateway;
import br.com.fiap.baitersburger.domain.port.out.repository.CustomerDataSource;
import br.com.fiap.baitersburger.infrastructure.web.mapper.CustomerMapper;
import br.com.fiap.baitersburger.interfaceadapters.gateway.CustomerGatewayImpl;
import org.springframework.stereotype.Component;

@Component
public class CustomerControllerImpl implements CustomerController {

    private final CustomerMapper customerMapper;
    private final FindCustomerByCpfUseCase findCustomerByCpfUseCase;
    private final InsertCustomerUseCaseImpl insertCustomerUseCaseImpl;

    public CustomerControllerImpl(CustomerMapper customerMapper, CustomerDataSource dataSource) {
        this.customerMapper = customerMapper;
        CustomerGateway gateway = new CustomerGatewayImpl(dataSource);

        this.findCustomerByCpfUseCase = new FindCustomerByCpfUseCaseImpl(gateway);
        this.insertCustomerUseCaseImpl = new InsertCustomerUseCaseImpl(gateway);


    }

    @Override
    public CustomerResponseDTO find(String cpf) {
        var customer = findCustomerByCpfUseCase.find(cpf);

        return customerMapper.toCustomerResponseDTO(customer);

    }

    @Override
    public void insert(CustomerRequestDTO dto) {

        var customer = customerMapper.toCustomer(dto);
        this.insertCustomerUseCaseImpl.insert(customer);
    }
}
