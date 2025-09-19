package br.com.fiap.baitersburger.infrastructure.config.customer;

import br.com.fiap.baitersburger.application.usecase.customer.FindCustomerByCpfUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.in.usecase.customer.FindCustomerByCpfUseCase;
import br.com.fiap.baitersburger.domain.port.out.gateway.CustomerGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FindCustomerByCpfConfig {
    //@Bean
    public FindCustomerByCpfUseCase findCustomerByCpfUseCase(CustomerGateway customerGateway) {
        return new FindCustomerByCpfUseCaseImpl(customerGateway);
    }
}
