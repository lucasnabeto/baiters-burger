package br.com.fiap.baitersburger.interfaceadapters.gateway;

import br.com.fiap.baitersburger.domain.model.Order;
import br.com.fiap.baitersburger.domain.port.out.gateway.GenerateQrCodeGateway;
import br.com.fiap.baitersburger.domain.port.out.api.GenerateQrDataSource;
import br.com.fiap.baitersburger.interfaceadapters.dto.response.mercadopago.ResponseQRCodeDTO;

public class GenerateQrCodeGatewayImpl implements GenerateQrCodeGateway {
    final GenerateQrDataSource dataSource;

    public GenerateQrCodeGatewayImpl(GenerateQrDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public ResponseQRCodeDTO generateQr(String orderId, String amount) {

        return  dataSource.generateQr(orderId, amount);
    }
}
