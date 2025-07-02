package br.com.fiap.baitersburger.interfaceadapters.controller;

import br.com.fiap.baitersburger.application.dto.UpdateOrderStatusDTO;
import br.com.fiap.baitersburger.application.dto.request.OrderRequestDTO;
import br.com.fiap.baitersburger.application.dto.response.OrderResponseDTO;
import br.com.fiap.baitersburger.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.domain.port.in.controller.OrderController;
import br.com.fiap.baitersburger.domain.port.in.usecase.order.FindOrderByStatusUseCase;
import br.com.fiap.baitersburger.domain.port.in.usecase.order.InsertOrderUseCase;
import br.com.fiap.baitersburger.domain.port.in.usecase.order.UpdateOrderStatusUseCase;
import br.com.fiap.baitersburger.infrastructure.web.mapper.OrderMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderControllerImpl implements OrderController {


    private final InsertOrderUseCase insertOrderUseCase;
    private final FindOrderByStatusUseCase findOrderByStatusUseCase;
    private final UpdateOrderStatusUseCase updateOrderStatusUseCase;
    private final OrderMapper orderMapper;


    public OrderControllerImpl(InsertOrderUseCase insertOrderUseCase,
                               FindOrderByStatusUseCase findOrderByStatusUseCase,
                               UpdateOrderStatusUseCase updateOrderStatusUseCase,
                               OrderMapper orderMapper) {

        this.insertOrderUseCase = insertOrderUseCase;
        this.findOrderByStatusUseCase = findOrderByStatusUseCase;
        this.updateOrderStatusUseCase = updateOrderStatusUseCase;
        this.orderMapper = orderMapper;
    }

    @Override
    public void insert(OrderRequestDTO orderRequestDTO) {
        insertOrderUseCase.insert(
                orderRequestDTO.getProductsIds(),
                orderRequestDTO.getCustomerCpf()
        );

    }

    @Override
    public List<OrderResponseDTO> findByStatus(OrderStatus status) {
        return findOrderByStatusUseCase.findByStatus(status)
                .stream()
                .map((orderMapper::toOrderResponseDTO))
                .toList();
    }

    @Override
    public void updateOrderStatus(String orderId, UpdateOrderStatusDTO updateOrderStatusDTO) {
        OrderStatus orderStatus = OrderStatus.fromValue(updateOrderStatusDTO.status());
        updateOrderStatusUseCase.updateOrderStatus(orderId, orderStatus);
    }
}
