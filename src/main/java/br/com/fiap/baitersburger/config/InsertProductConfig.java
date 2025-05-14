package br.com.fiap.baitersburger.config;

import br.com.fiap.baitersburger.application.core.usecase.product.InsertProductUseCase;
import br.com.fiap.baitersburger.application.ports.out.product.InsertProductOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertProductConfig {
    @Bean
    public InsertProductUseCase insertProductUseCase(InsertProductOutputPort insertProductOutputPort){
        return new InsertProductUseCase(insertProductOutputPort);
    }
}
