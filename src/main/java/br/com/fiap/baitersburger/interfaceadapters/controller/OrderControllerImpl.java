package br.com.fiap.baitersburger.interfaceadapters.controller;

import br.com.fiap.baitersburger.interfaceadapters.dto.UpdateOrderStatusDTO;
import br.com.fiap.baitersburger.interfaceadapters.dto.request.OrderRequestDTO;
import br.com.fiap.baitersburger.interfaceadapters.dto.response.OrderResponseDTO;
import br.com.fiap.baitersburger.application.usecase.order.FindOrderByStatusUseCaseImpl;
import br.com.fiap.baitersburger.application.usecase.order.InsertOrderUseCaseImpl;
import br.com.fiap.baitersburger.application.usecase.order.UpdateOrderStatusUseCaseImpl;
import br.com.fiap.baitersburger.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.domain.port.in.controller.OrderController;
import br.com.fiap.baitersburger.domain.port.in.usecase.order.FindOrderByStatusUseCase;
import br.com.fiap.baitersburger.domain.port.in.usecase.order.InsertOrderUseCase;
import br.com.fiap.baitersburger.domain.port.in.usecase.order.UpdateOrderStatusUseCase;
import br.com.fiap.baitersburger.domain.port.out.gateway.CustomerGateway;
import br.com.fiap.baitersburger.domain.port.out.gateway.OrderGateway;
import br.com.fiap.baitersburger.domain.port.out.gateway.ProductGateway;
import br.com.fiap.baitersburger.domain.port.out.repository.CustomerDataSource;
import br.com.fiap.baitersburger.domain.port.out.repository.OrderDataSource;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductDataSource;
import br.com.fiap.baitersburger.interfaceadapters.presenter.OrderPresenter;
import br.com.fiap.baitersburger.interfaceadapters.gateway.CustomerGatewayImpl;
import br.com.fiap.baitersburger.interfaceadapters.gateway.OrderGatewayImpl;
import br.com.fiap.baitersburger.interfaceadapters.gateway.ProductGatewayImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderControllerImpl implements OrderController {
    private final InsertOrderUseCase insertOrderUseCase;
    private final FindOrderByStatusUseCase findOrderByStatusUseCase;
    private final UpdateOrderStatusUseCase updateOrderStatusUseCase;
    private final OrderPresenter orderPresenter;

    public OrderControllerImpl(OrderPresenter orderPresenter, CustomerDataSource customerDataSource, OrderDataSource orderDataSource, ProductDataSource productDataSource) {
        CustomerGateway customerGateway = new CustomerGatewayImpl(customerDataSource);
        OrderGateway orderGateway = new OrderGatewayImpl(orderDataSource);
        ProductGateway productGateway = new ProductGatewayImpl(productDataSource);
        
        this.insertOrderUseCase = new InsertOrderUseCaseImpl(customerGateway, orderGateway, productGateway);
        this.findOrderByStatusUseCase = new FindOrderByStatusUseCaseImpl(orderGateway);
        this.updateOrderStatusUseCase = new UpdateOrderStatusUseCaseImpl(orderGateway);

        this.orderPresenter = orderPresenter;
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
                .map((orderPresenter::toOrderResponseDTO))
                .toList();
    }

    @Override
    public void updateOrderStatus(String orderId, UpdateOrderStatusDTO updateOrderStatusDTO) {
        OrderStatus orderStatus = OrderStatus.fromValue(updateOrderStatusDTO.status());
        updateOrderStatusUseCase.updateOrderStatus(orderId, orderStatus);
    }
}
