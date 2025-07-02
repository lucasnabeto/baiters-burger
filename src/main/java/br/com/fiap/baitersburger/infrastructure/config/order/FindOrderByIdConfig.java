package br.com.fiap.baitersburger.infrastructure.config.order;

import br.com.fiap.baitersburger.application.usecase.order.FindOrderByIdUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.out.repository.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindOrderByIdConfig {

    @Bean
    public FindOrderByIdUseCaseImpl findOrderByIdUseCase(OrderRepository orderRepository) {
        return new FindOrderByIdUseCaseImpl(orderRepository);
    }
}
