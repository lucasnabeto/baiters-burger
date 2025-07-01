package br.com.fiap.baitersburger.infrastructure.config.customer;

import br.com.fiap.baitersburger.application.usecase.customer.impl.FindCustomerByCpfUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.repository.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByCpfConfig {
    @Bean
    public FindCustomerByCpfUseCaseImpl findCustomerByCpfUseCase(CustomerRepository customerRepository) {
        return new FindCustomerByCpfUseCaseImpl(customerRepository);
    }
}
