package br.com.fiap.baitersburger.application.usecase.order;

import br.com.fiap.baitersburger.domain.model.Order;
import br.com.fiap.baitersburger.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.domain.port.in.usecase.order.InsertOrderUseCase;
import br.com.fiap.baitersburger.domain.model.Product;
import br.com.fiap.baitersburger.domain.port.out.repository.CustomerDataSource;
import br.com.fiap.baitersburger.domain.port.out.repository.OrderDataSource;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductDataSource;
import br.com.fiap.baitersburger.domain.exception.ExceptionMessages;
import br.com.fiap.baitersburger.domain.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;

public class InsertOrderUseCaseImpl implements InsertOrderUseCase {

    private final CustomerDataSource customerDataSource;
    private final OrderDataSource orderDataSource;
    private final ProductDataSource productDataSource;

    public InsertOrderUseCaseImpl(CustomerDataSource customerDataSource, OrderDataSource orderDataSource, ProductDataSource productDataSource) {
        this.customerDataSource = customerDataSource;
        this.orderDataSource = orderDataSource;
        this.productDataSource = productDataSource;
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
            var customer = customerDataSource.findByCpf(customerCpf)
                    .orElseThrow(() -> new NotFoundException(ExceptionMessages.CUSTOMER_NOT_FOUND));
            order.setCustomer(customer);
        }

        order.setCreatedAt(LocalDateTime.now());
        order.setStatus(OrderStatus.RECEIVED);
        order.setProducts(products);
        order.calculateTotalPrice();

        orderDataSource.insert(order);
    }
}
