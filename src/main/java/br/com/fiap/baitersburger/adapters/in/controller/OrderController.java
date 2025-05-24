package br.com.fiap.baitersburger.adapters.in.controller;

import br.com.fiap.baitersburger.adapters.in.controller.dto.order.OrderRequestDTO;
import br.com.fiap.baitersburger.adapters.in.controller.dto.order.OrderResponseDTO;
import br.com.fiap.baitersburger.adapters.in.controller.mapper.OrderMapper;
import br.com.fiap.baitersburger.core.application.ports.in.order.FindOrderByStatusInputPort;
import br.com.fiap.baitersburger.core.application.ports.in.order.InsertOrderInputPort;
import br.com.fiap.baitersburger.core.domain.enums.OrderStatus;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final InsertOrderInputPort insertOrderInputPort;
    private final FindOrderByStatusInputPort findOrderByStatusInputPort;
    private final OrderMapper orderMapper;

    public OrderController(
            InsertOrderInputPort insertOrderInputPort,
            FindOrderByStatusInputPort findOrderByStatusInputPort,
            OrderMapper orderMapper
    ) {
        this.insertOrderInputPort = insertOrderInputPort;
        this.findOrderByStatusInputPort = findOrderByStatusInputPort;
        this.orderMapper = orderMapper;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody OrderRequestDTO orderRequestDTO){
        insertOrderInputPort.insert(
                orderRequestDTO.getProductsIds(),
                orderRequestDTO.getCustomerCpf()
        );
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> findByStatus(@RequestParam OrderStatus status) {
        var order = findOrderByStatusInputPort.findByStatus(status).stream().map((orderMapper::toOrderResponseDTO)).toList();
        return ResponseEntity.ok(order);
    }
}
