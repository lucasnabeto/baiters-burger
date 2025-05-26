package br.com.fiap.baitersburger.infrastructure.config.customer;

import br.com.fiap.baitersburger.core.application.usecase.customer.FindCustomerByCpfUseCase;
import br.com.fiap.baitersburger.core.application.usecase.customer.InsertCustomerUseCase;
import br.com.fiap.baitersburger.core.domain.ports.out.customer.FindCustomerByCpfOutputPort;
import br.com.fiap.baitersburger.core.domain.ports.out.customer.InsertCustomerOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCostumerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            InsertCustomerOutputPort insertCustomerOutputPort,
            FindCustomerByCpfOutputPort findCustomerByCpfOutputPort
    ) {
        return new InsertCustomerUseCase(insertCustomerOutputPort, findCustomerByCpfOutputPort);
    }
}
