package br.com.fiap.baitersburger.core.application.usecase.order;

import br.com.fiap.baitersburger.core.domain.model.Order;
import br.com.fiap.baitersburger.core.domain.model.OrderStatus;
import br.com.fiap.baitersburger.core.application.ports.in.order.InsertOrderInputPort;
import br.com.fiap.baitersburger.core.domain.model.Product;
import br.com.fiap.baitersburger.core.domain.ports.out.order.InsertOrderOutputPort;
import br.com.fiap.baitersburger.core.domain.ports.out.product.FindProductByIdOutputPort;

import java.time.LocalDateTime;
import java.util.List;

public class InsertOrderUseCase implements InsertOrderInputPort {
    private final InsertOrderOutputPort insertOrderOutputPort;

    private final FindProductByIdOutputPort findProductByIdOutputPort;

    public InsertOrderUseCase(InsertOrderOutputPort insertOrderOutputPort, FindProductByIdOutputPort findProductByIdOutputPort) {
        this.insertOrderOutputPort = insertOrderOutputPort;
        this.findProductByIdOutputPort = findProductByIdOutputPort;
    }

    @Override
    public void insert(List<String> productsIds) {
        List<Product> products = productsIds.stream()
                .map(id -> findProductByIdOutputPort
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Product not found")))
                .toList();

        var order = new Order();
        order.setCreatedAt(LocalDateTime.now());
        order.setStatus(OrderStatus.RECEIVED);
        order.setProducts(products);
        order.calculateTotalPrice();

        insertOrderOutputPort.insert(order);
    }
}
