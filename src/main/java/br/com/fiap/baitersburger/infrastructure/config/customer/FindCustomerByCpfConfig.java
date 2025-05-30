package br.com.fiap.baitersburger.infrastructure.config.customer;

import br.com.fiap.baitersburger.core.application.usecase.customer.FindCustomerByCpfUseCase;
import br.com.fiap.baitersburger.core.domain.ports.out.customer.FindCustomerByCpfOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByCpfConfig {
    @Bean
    public FindCustomerByCpfUseCase findCustomerByCpfUseCase(FindCustomerByCpfOutputPort findCustomerByCpfOutputPort) {
        return new FindCustomerByCpfUseCase(findCustomerByCpfOutputPort);
    }
}
