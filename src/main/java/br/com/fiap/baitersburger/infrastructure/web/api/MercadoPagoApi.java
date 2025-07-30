package br.com.fiap.baitersburger.infrastructure.web.api;

import br.com.fiap.baitersburger.domain.port.out.api.GenerateQrDataSource;
import br.com.fiap.baitersburger.infrastructure.utils.CreateHeadersQrCode;
import br.com.fiap.baitersburger.infrastructure.utils.CreateRequestQrCode;
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
public class MercadoPagoApi implements GenerateQrDataSource {

    private final RestTemplate restTemplate;

    private final CreateRequestQrCode createRequestQrCode;

    private final CreateHeadersQrCode createHeadersQrCode;


    @Value("${MERCADO_PAGO_URL}")
    private String MERCADO_PAGO_URL;

    public MercadoPagoApi(RestTemplate restTemplate, CreateRequestQrCode createRequestQrCode, CreateHeadersQrCode createHeadersQrCode) {
        this.restTemplate = restTemplate;
        this.createRequestQrCode = createRequestQrCode;
        this.createHeadersQrCode = createHeadersQrCode;
    }

    @Override
    public ResponseQRCodeDTO generateQr(String orderId, String amount) {

        RequestQRCodeDTO request = createRequestQrCode.createDto(orderId, amount);
        HttpHeaders headers = createHeadersQrCode.createHeaders();
        HttpEntity<RequestQRCodeDTO> entity = new HttpEntity<>(request, headers);

        ResponseEntity<ResponseQRCodeDTO> response = restTemplate.postForEntity(
                MERCADO_PAGO_URL,
                entity,
                ResponseQRCodeDTO.class);

        return response.getBody();
    }




}
