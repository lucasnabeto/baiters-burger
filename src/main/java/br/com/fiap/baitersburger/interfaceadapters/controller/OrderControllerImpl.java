package br.com.fiap.baitersburger.interfaceadapters.controller;

import br.com.fiap.baitersburger.application.usecase.order.GetCurrentOrdersUseCaseImpl;
import br.com.fiap.baitersburger.domain.model.Order;
import br.com.fiap.baitersburger.domain.port.in.usecase.order.GetCurrentOrderUseCase;
import br.com.fiap.baitersburger.domain.port.out.gateway.GenerateQrCodeGateway;
import br.com.fiap.baitersburger.domain.port.out.api.GenerateQrDataSource;
import br.com.fiap.baitersburger.interfaceadapters.dto.UpdateOrderStatusDTO;
import br.com.fiap.baitersburger.interfaceadapters.dto.request.CurrentOrdersDTO;
import br.com.fiap.baitersburger.interfaceadapters.dto.request.OrderRequestDTO;
import br.com.fiap.baitersburger.interfaceadapters.dto.response.InsertOrderResponseDTO;
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
import br.com.fiap.baitersburger.interfaceadapters.gateway.GenerateQrCodeGatewayImpl;
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
    private final GetCurrentOrderUseCase getCurrentOrderUseCase;

    public OrderControllerImpl(OrderPresenter orderPresenter, CustomerDataSource customerDataSource, OrderDataSource orderDataSource, ProductDataSource productDataSource, GenerateQrDataSource generateQrDataSource) {
        CustomerGateway customerGateway = new CustomerGatewayImpl(customerDataSource);
        OrderGateway orderGateway = new OrderGatewayImpl(orderDataSource);
        ProductGateway productGateway = new ProductGatewayImpl(productDataSource);
        GenerateQrCodeGateway generateQrCodeGateway = new GenerateQrCodeGatewayImpl(generateQrDataSource);
        
        this.insertOrderUseCase = new InsertOrderUseCaseImpl(customerGateway, orderGateway, productGateway, generateQrCodeGateway);
        this.findOrderByStatusUseCase = new FindOrderByStatusUseCaseImpl(orderGateway);
        this.updateOrderStatusUseCase = new UpdateOrderStatusUseCaseImpl(orderGateway);
        this.getCurrentOrderUseCase = new GetCurrentOrdersUseCaseImpl(orderGateway);

        this.orderPresenter = orderPresenter;
    }

    @Override
    public InsertOrderResponseDTO insert(OrderRequestDTO orderRequestDTO) {

        Order order = insertOrderUseCase.insert(
                orderRequestDTO.getProductsIds(),
                orderRequestDTO.getCustomerCpf()
        );

        return orderPresenter.toInsertOrderResponseDTO(order);


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

    @Override
    public List<CurrentOrdersDTO> getCurrentOrders() {

        return orderPresenter.toCurrentOrdersDTO(this.getCurrentOrderUseCase.getCurrentOrders());
    }
}
