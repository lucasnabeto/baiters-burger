package br.com.fiap.baitersburger.infrastructure.config.order;

import br.com.fiap.baitersburger.application.usecase.order.InsertOrderUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.out.repository.CustomerDataSource;
import br.com.fiap.baitersburger.domain.port.out.repository.OrderDataSource;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertOrderConfig {
    @Bean
    public InsertOrderUseCaseImpl insertOrderUseCase(
            CustomerDataSource customerDataSource,
            OrderDataSource orderDataSource,
            ProductDataSource productDataSource
    ) {
        return new InsertOrderUseCaseImpl(customerDataSource, orderDataSource, productDataSource);
    }
}
