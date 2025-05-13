package br.com.fiap.baitersburger.config;

import br.com.fiap.baitersburger.application.core.usecase.FindCustomerByCpfUseCase;
import br.com.fiap.baitersburger.application.ports.out.FindCustomerByCpfOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByCpfConfig {

    @Bean
    public FindCustomerByCpfUseCase findCustomerByCpfUseCase(FindCustomerByCpfOutputPort findCustomerByCpfOutputPort) {
        return new FindCustomerByCpfUseCase(findCustomerByCpfOutputPort);
    }
}
