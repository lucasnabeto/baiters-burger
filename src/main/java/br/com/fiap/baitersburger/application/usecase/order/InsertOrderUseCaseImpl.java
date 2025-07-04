package br.com.fiap.baitersburger.application.usecase.order;

import br.com.fiap.baitersburger.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.domain.exception.ExceptionMessages;
import br.com.fiap.baitersburger.domain.exception.NotFoundException;
import br.com.fiap.baitersburger.domain.model.Order;
import br.com.fiap.baitersburger.domain.model.Product;
import br.com.fiap.baitersburger.domain.port.in.usecase.order.InsertOrderUseCase;
import br.com.fiap.baitersburger.domain.port.out.gateway.CustomerGateway;
import br.com.fiap.baitersburger.domain.port.out.gateway.OrderGateway;
import br.com.fiap.baitersburger.domain.port.out.gateway.ProductGateway;

import java.time.LocalDateTime;
import java.util.List;

public class InsertOrderUseCaseImpl implements InsertOrderUseCase {
    private final CustomerGateway customerGateway;
    private final OrderGateway orderGateway;
    private final ProductGateway productDataSource;

    public InsertOrderUseCaseImpl(CustomerGateway customerGateway,
                                  OrderGateway orderGateway,
                                  ProductGateway productGateway) {
        this.customerGateway = customerGateway;
        this.orderGateway = orderGateway;
        this.productDataSource = productGateway;
    }

    @Override
    public void insert(List<String> productsIds, String customerCpf) {
        List<Product> products = productsIds.stream()
                .map(id -> productDataSource
                        .findById(id)
                        .orElseThrow(() -> new NotFoundException(ExceptionMessages.PRODUCT_NOT_FOUND)))
                .toList();

        var order = new Order();

        if (customerCpf != null) {
            var customer = customerGateway.findByCpf(customerCpf)
                    .orElseThrow(() -> new NotFoundException(ExceptionMessages.CUSTOMER_NOT_FOUND));
            order.setCustomer(customer);
        }

        order.setCreatedAt(LocalDateTime.now());
        order.setStatus(OrderStatus.RECEIVED);
        order.setProducts(products);
        order.calculateTotalPrice();

        orderGateway.insert(order);
    }
}
