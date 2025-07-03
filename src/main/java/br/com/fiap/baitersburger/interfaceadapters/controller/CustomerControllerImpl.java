package br.com.fiap.baitersburger.interfaceadapters.controller;

import br.com.fiap.baitersburger.application.dto.request.CustomerRequestDTO;
import br.com.fiap.baitersburger.application.dto.response.CustomerResponseDTO;
import br.com.fiap.baitersburger.application.usecase.customer.FindCustomerByCpfUseCaseImpl;
import br.com.fiap.baitersburger.application.usecase.customer.InsertCustomerUseCaseImpl;
import br.com.fiap.baitersburger.domain.model.Customer;
import br.com.fiap.baitersburger.domain.port.in.controller.CustomerController;
import br.com.fiap.baitersburger.domain.port.in.usecase.customer.FindCustomerByCpfUseCase;
import br.com.fiap.baitersburger.domain.port.in.usecase.customer.InsertCustomerUseCase;
import br.com.fiap.baitersburger.domain.port.out.gateway.CustomerGateway;
import br.com.fiap.baitersburger.domain.port.out.repository.CustomerDataSource;
import br.com.fiap.baitersburger.infrastructure.web.mapper.CustomerMapper;
import br.com.fiap.baitersburger.infrastructure.web.mapper.CustomerMapperImpl;
import br.com.fiap.baitersburger.interfaceadapters.gateway.CustomerGatewayImpl;
import org.springframework.stereotype.Component;

@Component
public class CustomerControllerImpl implements CustomerController {

    private final CustomerMapper customerMapper;
    private final CustomerDataSource dataSource;
    private final CustomerGateway gateway;

    public CustomerControllerImpl(CustomerMapper customerMapper,CustomerDataSource dataSource) {
        this.dataSource = dataSource;
        this.customerMapper = customerMapper;
        this.gateway = new CustomerGatewayImpl(this.dataSource);



    }

    @Override
    public CustomerResponseDTO find(String cpf) {
        var findCustomerByCpfUseCase = new FindCustomerByCpfUseCaseImpl(this.gateway);
        var customer = findCustomerByCpfUseCase.find(cpf);

        return customerMapper.toCustomerResponseDTO(customer);

    }

    @Override
    public void insert(CustomerRequestDTO dto) {

        var customer = customerMapper.toCustomer(dto);

        new InsertCustomerUseCaseImpl(this.dataSource).insert(customer);
    }
}
