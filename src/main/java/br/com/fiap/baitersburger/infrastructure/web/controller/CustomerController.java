package br.com.fiap.baitersburger.infrastructure.web.controller;

import br.com.fiap.baitersburger.application.dto.request.CustomerRequestDTO;
import br.com.fiap.baitersburger.application.dto.response.CustomerResponseDTO;
import br.com.fiap.baitersburger.infrastructure.web.mapper.CustomerMapper;
import br.com.fiap.baitersburger.domain.model.Customer;
import br.com.fiap.baitersburger.application.usecase.customer.FindCustomerByCpfUseCase;
import br.com.fiap.baitersburger.application.usecase.customer.InsertCustomerUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerMapper customerMapper;
    private final InsertCustomerUseCase insertCustomerInputPort;
    private final FindCustomerByCpfUseCase findCustomerByCpfInputPort;

    public CustomerController(CustomerMapper customerMapper, InsertCustomerUseCase insertCustomerInputPort, FindCustomerByCpfUseCase findCustomerByCpfInputPort) {
        this.customerMapper = customerMapper;
        this.insertCustomerInputPort = insertCustomerInputPort;
        this.findCustomerByCpfInputPort = findCustomerByCpfInputPort;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<CustomerResponseDTO> find(@PathVariable final String cpf) {
        var customer = findCustomerByCpfInputPort.find(cpf);
        var customerResponseDTO = customerMapper.toCustomerResponseDTO(customer);
        return ResponseEntity.ok().body(customerResponseDTO);
    }

    @PostMapping
    public ResponseEntity<Customer> insert(@Valid @RequestBody CustomerRequestDTO customerRequestDTO) {
        var customer = customerMapper.toCustomer(customerRequestDTO);
        insertCustomerInputPort.insert(customer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
