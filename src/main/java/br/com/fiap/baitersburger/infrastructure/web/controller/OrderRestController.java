package br.com.fiap.baitersburger.infrastructure.web.controller;

import br.com.fiap.baitersburger.interfaceadapters.dto.request.OrderRequestDTO;
import br.com.fiap.baitersburger.interfaceadapters.dto.response.OrderResponseDTO;
import br.com.fiap.baitersburger.interfaceadapters.dto.UpdateOrderStatusDTO;
import br.com.fiap.baitersburger.domain.port.in.controller.OrderController;
import br.com.fiap.baitersburger.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.domain.port.out.repository.CustomerDataSource;
import br.com.fiap.baitersburger.domain.port.out.repository.OrderDataSource;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductDataSource;
import br.com.fiap.baitersburger.interfaceadapters.presenter.OrderPresenter;
import br.com.fiap.baitersburger.interfaceadapters.controller.OrderControllerImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderRestController {
    private final OrderController orderController;

    public OrderRestController(OrderPresenter orderPresenter, CustomerDataSource customerDataSource, OrderDataSource orderDataSource, ProductDataSource productDataSource) {
        this.orderController = new OrderControllerImpl(orderPresenter, customerDataSource, orderDataSource, productDataSource);
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