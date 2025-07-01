package br.com.fiap.baitersburger.infrastructure.config.order;

import br.com.fiap.baitersburger.application.usecase.order.impl.FindOrderByIdUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.repository.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindOrderByIdConfig {

    @Bean
    public FindOrderByIdUseCaseImpl findOrderByIdUseCase(OrderRepository orderRepository) {
        return new FindOrderByIdUseCaseImpl(orderRepository);
    }
}
