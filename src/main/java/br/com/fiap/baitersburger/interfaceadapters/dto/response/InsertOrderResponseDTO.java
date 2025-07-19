package br.com.fiap.baitersburger.interfaceadapters.dto.response;

import java.math.BigDecimal;

public record InsertOrderResponseDTO(String orderId, BigDecimal totalPrice, String qrcode) {
}
