package br.com.fiap.baitersburger.application.usecase.order;

import br.com.fiap.baitersburger.domain.model.Order;
import br.com.fiap.baitersburger.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.domain.port.in.usecase.order.InsertOrderUseCase;
import br.com.fiap.baitersburger.domain.model.Product;
import br.com.fiap.baitersburger.domain.port.out.repository.CustomerRepository;
import br.com.fiap.baitersburger.domain.port.out.repository.OrderRepository;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductRepository;
import br.com.fiap.baitersburger.domain.exception.ExceptionMessages;
import br.com.fiap.baitersburger.domain.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;

public class InsertOrderUseCaseImpl implements InsertOrderUseCase {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public InsertOrderUseCaseImpl(CustomerRepository customerRepository, OrderRepository orderRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void insert(List<String> productsIds, String customerCpf) {
        List<Product> products = productsIds.stream()
                .map(id -> productRepository
                        .findById(id)
                        .orElseThrow(() -> new NotFoundException(ExceptionMessages.PRODUCT_NOT_FOUND)))
                .toList();

        var order = new Order();

        if (customerCpf != null) {
            var customer = customerRepository.findByCpf(customerCpf)
                    .orElseThrow(() -> new NotFoundException(ExceptionMessages.CUSTOMER_NOT_FOUND));
            order.setCustomer(customer);
        }

        order.setCreatedAt(LocalDateTime.now());
        order.setStatus(OrderStatus.RECEIVED);
        order.setProducts(products);
        order.calculateTotalPrice();

        orderRepository.insert(order);
    }
}
