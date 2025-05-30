package br.com.fiap.baitersburger.infrastructure.config.order;

import br.com.fiap.baitersburger.core.application.ports.in.order.FindOrderByIdInputPort;
import br.com.fiap.baitersburger.core.application.usecase.order.UpdateOrderStatusUseCase;
import br.com.fiap.baitersburger.core.domain.ports.out.order.UpdateOrderStatusOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateOrderStatusConfig {
    @Bean
    public UpdateOrderStatusUseCase updateOrderStatusUseCase(FindOrderByIdInputPort findOrderByIdInputPort, UpdateOrderStatusOutputPort updateOrderStatusOutputPort) {
        return new UpdateOrderStatusUseCase(findOrderByIdInputPort, updateOrderStatusOutputPort);
    }
}
