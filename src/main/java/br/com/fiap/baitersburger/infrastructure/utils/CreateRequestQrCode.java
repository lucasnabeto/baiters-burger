package br.com.fiap.baitersburger.infrastructure.utils;

import br.com.fiap.baitersburger.interfaceadapters.dto.request.mercadopago.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateRequestQrCode {


    @Value("${MERCADO_PAGO_EXTERNAL_POS_ID}")
    private String MERCADO_PAGO_EXTERNAL_POS_ID;


    public RequestQRCodeDTO createDto(String orderId, String amount) {
        var qr = new QR(MERCADO_PAGO_EXTERNAL_POS_ID, "dynamic");
        var configQrCode = new ConfigQRCode(qr);
        var payment = new Payment(amount);
        var transaction = new Transaction(List.of(payment));

        return new RequestQRCodeDTO("qr", amount, orderId, configQrCode, transaction);
    }
}
