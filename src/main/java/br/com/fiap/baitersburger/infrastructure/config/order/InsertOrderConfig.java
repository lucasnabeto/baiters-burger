package br.com.fiap.baitersburger.infrastructure.config.order;

import br.com.fiap.baitersburger.application.usecase.order.InsertOrderUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.out.repository.CustomerRepository;
import br.com.fiap.baitersburger.domain.port.out.repository.OrderRepository;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductRepository;
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
