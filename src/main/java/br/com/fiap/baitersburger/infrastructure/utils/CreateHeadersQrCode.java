package br.com.fiap.baitersburger.infrastructure.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateHeadersQrCode {


    @Value("${MERCADO_PAGO_ACCESS_TOKEN}")
    private String MERCADO_PAGO_ACCESS_TOKEN;

    public HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + MERCADO_PAGO_ACCESS_TOKEN);
        headers.set("X-Idempotency-Key", UUID.randomUUID().toString());

        return headers;
    }
}
