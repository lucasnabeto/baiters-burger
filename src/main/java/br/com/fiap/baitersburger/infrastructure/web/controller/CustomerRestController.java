package br.com.fiap.baitersburger.infrastructure.web.controller;

import br.com.fiap.baitersburger.interfaceadapters.dto.request.CustomerRequestDTO;
import br.com.fiap.baitersburger.interfaceadapters.dto.response.CustomerResponseDTO;
import br.com.fiap.baitersburger.domain.port.in.controller.CustomerController;
import br.com.fiap.baitersburger.domain.port.out.repository.CustomerDataSource;
import br.com.fiap.baitersburger.interfaceadapters.presenter.CustomerPresenter;
import br.com.fiap.baitersburger.interfaceadapters.controller.CustomerControllerImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerRestController {

    private final CustomerController customerController;

    public CustomerRestController(CustomerPresenter customerPresenter, CustomerDataSource dataSource) {
        this.customerController = new CustomerControllerImpl(customerPresenter,dataSource);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<CustomerResponseDTO> find(@PathVariable final String cpf) {
        var customerResponseDTO = customerController.find(cpf);
        return ResponseEntity.ok().body(customerResponseDTO);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequestDTO customerRequestDTO) {

        customerController.insert(customerRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}