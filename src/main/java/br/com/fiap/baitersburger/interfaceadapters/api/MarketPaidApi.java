package br.com.fiap.baitersburger.interfaceadapters.api;

import br.com.fiap.baitersburger.domain.port.out.api.GenerateQrDataSource;
import br.com.fiap.baitersburger.interfaceadapters.dto.request.mercadopago.*;
import br.com.fiap.baitersburger.interfaceadapters.dto.response.mercadopago.ResponseQRCodeDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Component
public class MarketPaidApi implements GenerateQrDataSource {

    private final RestTemplate restTemplate;

    @Value("${MERCADO_PAGO_ACCESS_TOKEN}")
    private String MERCADO_PAGO_ACCESS_TOKEN;

    @Value("${MERCADO_PAGO_EXTERNAL_POS_ID}")
    private String MERCADO_PAGO_EXTERNAL_POS_ID;

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

    private RequestQRCodeDTO createRequestDto(String orderId, String amount) {
        var qr = new QR(MERCADO_PAGO_EXTERNAL_POS_ID, "dynamic");
        var configQrCode = new ConfigQRCode(qr);
        var payment = new Payment(amount);
        var transaction = new Transaction(List.of(payment));

        return new RequestQRCodeDTO("qr", amount, orderId, configQrCode, transaction);
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + MERCADO_PAGO_ACCESS_TOKEN);
        headers.set("X-Idempotency-Key", UUID.randomUUID().toString());

        return headers;
    }
}
