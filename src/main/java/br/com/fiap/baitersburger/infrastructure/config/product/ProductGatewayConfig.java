package br.com.fiap.baitersburger.infrastructure.config.product;

import br.com.fiap.baitersburger.domain.port.out.gateway.ProductGateway;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductDataSource;
import br.com.fiap.baitersburger.interfaceadapters.gateway.ProductGatewayImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductGatewayConfig {

    @Bean
    public ProductGateway productGateway(
            ProductDataSource productDataSource
    ) {
        return new ProductGatewayImpl(productDataSource);
    }
}
