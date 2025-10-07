package br.com.fiap.baitersburger.infrastructure.config.order;

import br.com.fiap.baitersburger.domain.port.out.gateway.OrderGateway;
import br.com.fiap.baitersburger.domain.port.out.repository.OrderDataSource;
import br.com.fiap.baitersburger.interfaceadapters.gateway.OrderGatewayImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderGatewayConfig {
    @Bean
    public OrderGateway orderGateway(@Qualifier("orderDataSourceMySqlImpl") OrderDataSource orderDataSource) {
        return new OrderGatewayImpl(orderDataSource);
    }
}
