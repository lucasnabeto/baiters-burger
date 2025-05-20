package br.com.fiap.baitersburger.config.order;

import br.com.fiap.baitersburger.core.application.usecase.order.InsertOrderUseCase;
import br.com.fiap.baitersburger.core.domain.ports.out.order.InsertOrderOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertOrderConfig {
    @Bean
    public InsertOrderUseCase insertOrderUseCase(InsertOrderOutputPort insertOrderOutputPort){
        return new InsertOrderUseCase(insertOrderOutputPort);
    }
}
