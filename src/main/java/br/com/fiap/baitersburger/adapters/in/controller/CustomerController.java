package br.com.fiap.baitersburger.adapters.in.controller;

import br.com.fiap.baitersburger.adapters.in.controller.dto.CustomerRequestDTO;
import br.com.fiap.baitersburger.adapters.in.controller.dto.CustomerResponseDTO;
import br.com.fiap.baitersburger.adapters.in.controller.mapper.CustomerMapper;
import br.com.fiap.baitersburger.application.core.domain.Customer;
import br.com.fiap.baitersburger.application.ports.in.customer.FindCustomerByCpfInputPort;
import br.com.fiap.baitersburger.application.ports.in.customer.InsertCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    FindCustomerByCpfInputPort findCustomerByCpfInputPort;


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
        return ResponseEntity.ok().build();
    }

}
