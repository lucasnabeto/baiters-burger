package br.com.fiap.baitersburger.adapters.in.controller;

import br.com.fiap.baitersburger.adapters.in.controller.Mapper.CustomerMapper;
import br.com.fiap.baitersburger.adapters.in.controller.request.CustomerRequest;
import br.com.fiap.baitersburger.application.core.domain.Customer;
import br.com.fiap.baitersburger.application.ports.in.FindCustomerByCpfInputPort;
import br.com.fiap.baitersburger.application.ports.in.InsertCustomerInputPort;
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


    @PostMapping
    public ResponseEntity<Customer> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Customer> find(@PathVariable final String cpf) {
        Customer customer = findCustomerByCpfInputPort.find(cpf);
        return ResponseEntity.ok().body(customer);
    }

}
