package br.com.fiap.baitersburger.infrastructure.web.controller;

import br.com.fiap.baitersburger.application.dto.request.CustomerRequestDTO;
import br.com.fiap.baitersburger.application.dto.response.CustomerResponseDTO;
import br.com.fiap.baitersburger.domain.model.Customer;
import br.com.fiap.baitersburger.domain.port.in.controller.CustomerController;
import br.com.fiap.baitersburger.domain.port.out.repository.CustomerDataSource;
import br.com.fiap.baitersburger.infrastructure.web.mapper.CustomerMapper;
import br.com.fiap.baitersburger.interfaceadapters.controller.CustomerControllerImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerRestController {

    private final CustomerController customerController;
    private final CustomerMapper customerMapper;
    
    public CustomerRestController(CustomerMapper customerMapper, CustomerDataSource dataSource) {
        this.customerMapper = customerMapper;
        this.customerController = new CustomerControllerImpl(this.customerMapper,dataSource);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<CustomerResponseDTO> find(@PathVariable final String cpf) {
        var customerResponseDTO = customerController.find(cpf);
        return ResponseEntity.ok().body(customerResponseDTO);
    }

    @PostMapping
    public ResponseEntity<Customer> insert(@Valid @RequestBody CustomerRequestDTO customerRequestDTO) {

        customerController.insert(customerRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}