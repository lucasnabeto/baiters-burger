package br.com.fiap.baitersburger.adapters.in.controller;

import br.com.fiap.baitersburger.adapters.in.controller.dto.order.OrderRequestDTO;
import br.com.fiap.baitersburger.adapters.in.controller.mapper.OrderMapper;
import br.com.fiap.baitersburger.adapters.out.mongodb.repository.mappers.OrderEntityMapper;
import br.com.fiap.baitersburger.core.application.ports.in.order.InsertOrderInputPort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final InsertOrderInputPort insertOrderInputPort;

    public OrderController(InsertOrderInputPort insertOrderInputPort) {
        this.insertOrderInputPort = insertOrderInputPort;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody OrderRequestDTO orderRequestDTO){
        insertOrderInputPort.insert(orderRequestDTO.getProductsIds());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
