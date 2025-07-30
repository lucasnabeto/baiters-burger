package br.com.fiap.baitersburger.infrastructure.config.mercadopago;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MercadoPagoConfig {

    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }
}
