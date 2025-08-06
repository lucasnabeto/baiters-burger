package br.com.fiap.baitersburger.domain.port.out.gateway;

import br.com.fiap.baitersburger.domain.model.Order;
import br.com.fiap.baitersburger.interfaceadapters.dto.response.mercadopago.ResponseQRCodeDTO;

public interface GenerateQrCodeGateway {
    ResponseQRCodeDTO generateQr(String orderId, String amount);
}
