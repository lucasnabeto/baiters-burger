package br.com.fiap.baitersburger.infrastructure.config.order;

import br.com.fiap.baitersburger.application.usecase.order.UpdateOrderStatusUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.out.repository.OrderDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateOrderStatusConfig {
    @Bean
    public UpdateOrderStatusUseCaseImpl updateOrderStatusUseCase(
            OrderDataSource orderDataSource
    ) {
        return new UpdateOrderStatusUseCaseImpl(orderDataSource);
    }
}
