package br.com.fiap.baitersburger.domain.valueobject;

import java.math.BigDecimal;

public record QrCode(
        String orderId,
        String qrData
) {



}
