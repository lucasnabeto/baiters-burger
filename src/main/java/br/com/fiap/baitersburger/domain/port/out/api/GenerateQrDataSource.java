package br.com.fiap.baitersburger.domain.port.out.api;

import br.com.fiap.baitersburger.interfaceadapters.dto.response.mercadopago.ResponseQRCodeDTO;

public interface GenerateQrDataSource {
    ResponseQRCodeDTO generateQr(String orderId, String amount);
}
