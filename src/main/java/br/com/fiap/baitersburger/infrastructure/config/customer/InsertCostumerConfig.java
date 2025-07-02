package br.com.fiap.baitersburger.infrastructure.config.customer;

import br.com.fiap.baitersburger.application.usecase.customer.InsertCustomerUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.out.repository.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCostumerConfig {
    @Bean
    public InsertCustomerUseCaseImpl insertCustomerUseCase(
            CustomerRepository customerRepository
    ) {
        return new InsertCustomerUseCaseImpl(customerRepository);
    }
}
