package br.com.fiap.baitersburger.interfaceadapters.api;

import br.com.fiap.baitersburger.domain.port.out.api.GenerateQrDataSource;
import br.com.fiap.baitersburger.interfaceadapters.dto.request.mercadopago.*;
import br.com.fiap.baitersburger.interfaceadapters.dto.response.mercadopago.ResponseQRCodeDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;

@Component
public class MarketPaidApi implements GenerateQrDataSource {

    private final RestTemplate restTemplate;

    public MarketPaidApi() {
        restTemplate = new RestTemplate();
    }

    @Override
    public ResponseQRCodeDTO generateQr(String orderId, String amount) {

        RequestQRCodeDTO request = createRequestDto(orderId, amount);
        HttpHeaders headers = createHeaders();
        HttpEntity<RequestQRCodeDTO> entity = new HttpEntity<>(request, headers);

        ResponseEntity<ResponseQRCodeDTO> response = restTemplate.postForEntity(
                "https://api.mercadopago.com/v1/orders",
                entity,
                ResponseQRCodeDTO.class);

        return response.getBody();
    }

    private static RequestQRCodeDTO createRequestDto(String orderId, String amount) {
        var qr = new QR("iddaniel", "dynamic");
        var configQrCode = new ConfigQRCode(qr);
        var payment = new Payment(amount);
        var transaction = new Transaction(List.of(payment));

        return new RequestQRCodeDTO("qr", amount, orderId, configQrCode, transaction);
    }

    private static HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer APP_USR-2826639861257836-071718-938faa155c365f9809943453301646cb-2563305595");
        headers.set("X-Idempotency-Key", UUID.randomUUID().toString());

        return headers;
    }
}
