package br.com.fiap.baitersburger.config;

import br.com.fiap.baitersburger.application.core.usecase.customer.InsertCustomerUseCase;
import br.com.fiap.baitersburger.application.ports.out.customer.InsertCustomerOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCostumerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            InsertCustomerOutputPort insertCustomerOutputPort
    ) {
        return new InsertCustomerUseCase(insertCustomerOutputPort);
    }

}
