package br.com.fiap.baitersburger.infrastructure.config.order;

import br.com.fiap.baitersburger.application.usecase.order.FindOrderByStatusUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.out.repository.OrderDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindOrderByStatusConfig {
    @Bean
    public FindOrderByStatusUseCaseImpl findOrderByStatusUseCase(OrderDataSource orderDataSource) {
        return new FindOrderByStatusUseCaseImpl(orderDataSource);
    }
}
