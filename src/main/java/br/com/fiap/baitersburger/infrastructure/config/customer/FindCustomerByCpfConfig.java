package br.com.fiap.baitersburger.infrastructure.config.customer;

import br.com.fiap.baitersburger.application.usecase.customer.FindCustomerByCpfUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.out.gateway.CustomerGateway;
import br.com.fiap.baitersburger.domain.port.out.repository.CustomerDataSource;
import br.com.fiap.baitersburger.interfaceadapters.gateway.CustomerGatewayImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByCpfConfig {
    @Bean
    public FindCustomerByCpfUseCaseImpl findCustomerByCpfUseCase(CustomerGateway customerGateway) {
        return new FindCustomerByCpfUseCaseImpl(customerGateway);
    }

    @Bean
    public CustomerGatewayImpl createCustomerGateway(CustomerDataSource dataSource){
        return new CustomerGatewayImpl(dataSource);
    }
}
