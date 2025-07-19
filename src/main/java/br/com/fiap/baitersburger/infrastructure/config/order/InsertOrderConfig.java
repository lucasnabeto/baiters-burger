package br.com.fiap.baitersburger.infrastructure.config.order;

import br.com.fiap.baitersburger.application.usecase.order.InsertOrderUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.in.usecase.order.InsertOrderUseCase;
import br.com.fiap.baitersburger.domain.port.out.gateway.CustomerGateway;
import br.com.fiap.baitersburger.domain.port.out.gateway.OrderGateway;
import br.com.fiap.baitersburger.domain.port.out.gateway.GenerateQrCodeGateway;
import br.com.fiap.baitersburger.domain.port.out.gateway.ProductGateway;
import br.com.fiap.baitersburger.domain.port.out.api.GenerateQrDataSource;
import br.com.fiap.baitersburger.interfaceadapters.gateway.GenerateQrCodeGatewayImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertOrderConfig {
    @Bean
    public InsertOrderUseCase insertOrderUseCase(
            CustomerGateway customerGateway,
            OrderGateway orderGateway,
            ProductGateway productGateway,
            GenerateQrCodeGateway generateQrCodeGateway
    ) {
        return new InsertOrderUseCaseImpl(customerGateway, orderGateway, productGateway, generateQrCodeGateway);
    }

    @Bean
    public GenerateQrCodeGateway paymentGateway(GenerateQrDataSource dataSource){
        return new GenerateQrCodeGatewayImpl(dataSource);
    }
}
