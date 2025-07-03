package br.com.fiap.baitersburger.infrastructure.config.order;

import br.com.fiap.baitersburger.application.usecase.order.FindOrderByIdUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.out.repository.OrderDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindOrderByIdConfig {

    @Bean
    public FindOrderByIdUseCaseImpl findOrderByIdUseCase(OrderDataSource orderDataSource) {
        return new FindOrderByIdUseCaseImpl(orderDataSource);
    }
}
