package br.com.fiap.baitersburger.infrastructure.web.controller;

import br.com.fiap.baitersburger.application.dto.request.OrderRequestDTO;
import br.com.fiap.baitersburger.application.dto.response.OrderResponseDTO;
import br.com.fiap.baitersburger.application.dto.UpdateOrderStatusDTO;
import br.com.fiap.baitersburger.infrastructure.web.mapper.OrderMapper;
import br.com.fiap.baitersburger.application.usecase.order.FindOrderByStatusUseCase;
import br.com.fiap.baitersburger.application.usecase.order.InsertOrderUseCase;
import br.com.fiap.baitersburger.application.usecase.order.UpdateOrderStatusUseCase;
import br.com.fiap.baitersburger.domain.enums.OrderStatus;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final InsertOrderUseCase insertOrderInputPort;
    private final FindOrderByStatusUseCase findOrderByStatusInputPort;
    private final UpdateOrderStatusUseCase updateOrderStatusInputPort;
    private final OrderMapper orderMapper;

    public OrderController(InsertOrderUseCase insertOrderInputPort,
                           FindOrderByStatusUseCase findOrderByStatusInputPort,
                           UpdateOrderStatusUseCase updateOrderStatusInputPort,
                           OrderMapper orderMapper) {
        this.insertOrderInputPort = insertOrderInputPort;
        this.findOrderByStatusInputPort = findOrderByStatusInputPort;
        this.updateOrderStatusInputPort = updateOrderStatusInputPort;
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
        var order = findOrderByStatusInputPort.findByStatus(status)
                .stream()
                .map((orderMapper::toOrderResponseDTO))
                .toList();
        return ResponseEntity.ok(order);
    }

    @PatchMapping("/{orderId}")
    public ResponseEntity<Void> updateOrderStatus(@PathVariable String orderId, @RequestBody UpdateOrderStatusDTO updateOrderStatusDTO) {
        OrderStatus orderStatus = OrderStatus.fromValue(updateOrderStatusDTO.getStatus());
        updateOrderStatusInputPort.updateOrderStatus(orderId, orderStatus);
        return ResponseEntity.noContent().build();
    }
}