package br.com.fiap.baitersburger.infrastructure.web.controller;

import br.com.fiap.baitersburger.application.dto.request.OrderRequestDTO;
import br.com.fiap.baitersburger.application.dto.response.OrderResponseDTO;
import br.com.fiap.baitersburger.application.dto.UpdateOrderStatusDTO;
import br.com.fiap.baitersburger.domain.port.in.controller.OrderController;
import br.com.fiap.baitersburger.infrastructure.web.mapper.OrderMapper;
import br.com.fiap.baitersburger.domain.port.in.usecase.order.FindOrderByStatusUseCase;
import br.com.fiap.baitersburger.domain.port.in.usecase.order.InsertOrderUseCase;
import br.com.fiap.baitersburger.domain.port.in.usecase.order.UpdateOrderStatusUseCase;
import br.com.fiap.baitersburger.domain.enums.OrderStatus;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderRestController {


    private final OrderController orderController;

    public OrderRestController(OrderController orderController) {
        this.orderController = orderController;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody OrderRequestDTO orderRequestDTO){
        orderController.insert(orderRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> findByStatus(@RequestParam OrderStatus status) {
        var order = orderController.findByStatus(status);

        return ResponseEntity.ok(order);
    }

    @PatchMapping("/{orderId}")
    public ResponseEntity<Void> updateOrderStatus(@PathVariable String orderId, @RequestBody UpdateOrderStatusDTO updateOrderStatusDTO) {

        orderController.updateOrderStatus(orderId, updateOrderStatusDTO);
        return ResponseEntity.noContent().build();
    }
}