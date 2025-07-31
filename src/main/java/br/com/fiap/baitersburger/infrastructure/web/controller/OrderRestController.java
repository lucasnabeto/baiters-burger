package br.com.fiap.baitersburger.infrastructure.web.controller;

import br.com.fiap.baitersburger.domain.port.out.api.GenerateQrDataSource;
import br.com.fiap.baitersburger.interfaceadapters.dto.request.CurrentOrdersDTO;
import br.com.fiap.baitersburger.interfaceadapters.dto.request.mercadopago.MercadoPagoRequestDTO;
import br.com.fiap.baitersburger.interfaceadapters.dto.request.OrderRequestDTO;
import br.com.fiap.baitersburger.interfaceadapters.dto.response.InsertOrderResponseDTO;
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
import java.util.Map;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderRestController {
    private final OrderController orderController;

    public OrderRestController(OrderPresenter orderPresenter,
                               CustomerDataSource customerDataSource,
                               OrderDataSource orderDataSource,
                               ProductDataSource productDataSource,
                               GenerateQrDataSource generateQrDataSource) {
        this.orderController = new OrderControllerImpl(orderPresenter, customerDataSource, orderDataSource, productDataSource, generateQrDataSource);
    }

    @PostMapping
    public ResponseEntity<InsertOrderResponseDTO> insert(@Valid @RequestBody OrderRequestDTO orderRequestDTO){
        InsertOrderResponseDTO dto = orderController.insert(orderRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<CurrentOrdersDTO>> getCurrentOrders() {
        var order = orderController.getCurrentOrders();

        return ResponseEntity.ok(order);
    }


    @GetMapping("/orderstatus/{status}")
    public ResponseEntity<List<OrderResponseDTO>> findByStatus(@PathVariable final OrderStatus status) {
        var order = orderController.findByStatus(status);

        return ResponseEntity.ok(order);
    }

    @PatchMapping("/{orderId}")
    public ResponseEntity<Void> updateOrderStatus(@PathVariable String orderId, @RequestBody UpdateOrderStatusDTO updateOrderStatusDTO) {

        orderController.updateOrderStatus(orderId, updateOrderStatusDTO);
        return ResponseEntity.noContent().build();
    }


    @PostMapping
    @RequestMapping("/webhook")
    public ResponseEntity<String> approve(@RequestHeader Map<String, String> headers, @RequestBody MercadoPagoRequestDTO dto) {

        orderController.updateOrderStatus(dto.data().externalReference(),
                new UpdateOrderStatusDTO(OrderStatus.RECEIVED.toString()));

        return ResponseEntity.ok("thankyou");
    }
}