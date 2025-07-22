package br.com.fiap.baitersburger.interfaceadapters.dto.request;

import java.math.BigDecimal;
import java.util.List;

public record CurrentOrdersDTO(String id,
                               BigDecimal totalPrice,
                               String status,
                               List<CurrentProducts> products,
                               String createdAt,
                               String name
                                 ) {
}
