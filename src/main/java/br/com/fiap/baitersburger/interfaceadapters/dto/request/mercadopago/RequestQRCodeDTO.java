package br.com.fiap.baitersburger.interfaceadapters.dto.request.mercadopago;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record RequestQRCodeDTO(String type,
                               String totalAmount,
                               String externalReference,
                               @JsonProperty("config")
                               ConfigQRCode configQRCode,
                               Transaction transactions
                               ) {

}
