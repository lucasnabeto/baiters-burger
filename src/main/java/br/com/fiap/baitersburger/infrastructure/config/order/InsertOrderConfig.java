package br.com.fiap.baitersburger.infrastructure.config.order;

import br.com.fiap.baitersburger.application.usecase.order.impl.InsertOrderUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.repository.CustomerRepository;
import br.com.fiap.baitersburger.domain.port.repository.OrderRepository;
import br.com.fiap.baitersburger.domain.port.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertOrderConfig {
    @Bean
    public InsertOrderUseCaseImpl insertOrderUseCase(
            CustomerRepository customerRepository,
            OrderRepository orderRepository,
            ProductRepository productRepository
    ) {
        return new InsertOrderUseCaseImpl(customerRepository, orderRepository, productRepository);
    }
}
