package br.com.fiap.baitersburger.interfaceadapters.controller;

import br.com.fiap.baitersburger.application.dto.request.CustomerRequestDTO;
import br.com.fiap.baitersburger.application.dto.response.CustomerResponseDTO;
import br.com.fiap.baitersburger.domain.model.Customer;
import br.com.fiap.baitersburger.domain.port.in.controller.CustomerController;
import br.com.fiap.baitersburger.domain.port.in.usecase.customer.FindCustomerByCpfUseCase;
import br.com.fiap.baitersburger.domain.port.in.usecase.customer.InsertCustomerUseCase;
import br.com.fiap.baitersburger.infrastructure.web.mapper.CustomerMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerControllerImpl implements CustomerController {

    private final CustomerMapper customerMapper;
    private final InsertCustomerUseCase insertCustomerUseCase;
    private final FindCustomerByCpfUseCase findCustomerByCpfUseCase;

    public CustomerControllerImpl(CustomerMapper customerMapper, InsertCustomerUseCase insertCustomerUseCase, FindCustomerByCpfUseCase findCustomerByCpfUseCase) {
        this.customerMapper = customerMapper;
        this.insertCustomerUseCase = insertCustomerUseCase;
        this.findCustomerByCpfUseCase = findCustomerByCpfUseCase;
    }

    @Override
    public CustomerResponseDTO find(String cpf) {
        var customer = findCustomerByCpfUseCase.find(cpf);
        return customerMapper.toCustomerResponseDTO(customer);

    }

    @Override
    public void insert(CustomerRequestDTO dto) {
        var customer = customerMapper.toCustomer(dto);
        insertCustomerUseCase.insert(customer);
    }
}
