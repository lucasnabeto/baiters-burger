package br.com.fiap.baitersburger.core.application.usecase.order;

import br.com.fiap.baitersburger.core.domain.model.Order;
import br.com.fiap.baitersburger.core.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.core.application.ports.in.order.InsertOrderInputPort;
import br.com.fiap.baitersburger.core.domain.model.Product;
import br.com.fiap.baitersburger.core.domain.ports.out.customer.FindCustomerByCpfOutputPort;
import br.com.fiap.baitersburger.core.domain.ports.out.order.InsertOrderOutputPort;
import br.com.fiap.baitersburger.core.domain.ports.out.product.FindProductByIdOutputPort;
import br.com.fiap.baitersburger.core.exceptions.ExceptionMessages;
import br.com.fiap.baitersburger.core.exceptions.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;

public class InsertOrderUseCase implements InsertOrderInputPort {
    private final InsertOrderOutputPort insertOrderOutputPort;
    private final FindProductByIdOutputPort findProductByIdOutputPort;
    private final FindCustomerByCpfOutputPort findCustomerByCpfOutputPort;

    public InsertOrderUseCase(InsertOrderOutputPort insertOrderOutputPort,
                              FindProductByIdOutputPort findProductByIdOutputPort,
                              FindCustomerByCpfOutputPort findCustomerByCpfOutputPort
    ) {
        this.insertOrderOutputPort = insertOrderOutputPort;
        this.findProductByIdOutputPort = findProductByIdOutputPort;
        this.findCustomerByCpfOutputPort = findCustomerByCpfOutputPort;
    }

    @Override
    public void insert(List<String> productsIds, String customerCpf) {
        List<Product> products = productsIds.stream()
                .map(id -> findProductByIdOutputPort
                        .findById(id)
                        .orElseThrow(() -> new NotFoundException(ExceptionMessages.PRODUCT_NOT_FOUND)))
                .toList();

        var order = new Order();

        if (customerCpf != null) {
            var customer = findCustomerByCpfOutputPort.find(customerCpf)
                    .orElseThrow(() -> new NotFoundException(ExceptionMessages.CUSTOMER_NOT_FOUND));
            order.setCustomer(customer);
        }

        order.setCreatedAt(LocalDateTime.now());
        order.setStatus(OrderStatus.RECEIVED);
        order.setProducts(products);
        order.calculateTotalPrice();

        insertOrderOutputPort.insert(order);
    }
}
