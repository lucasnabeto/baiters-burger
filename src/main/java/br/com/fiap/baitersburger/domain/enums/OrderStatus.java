package br.com.fiap.baitersburger.domain.enums;

import br.com.fiap.baitersburger.domain.exception.ExceptionMessages;
import br.com.fiap.baitersburger.domain.exception.NotFoundException;

public enum OrderStatus {
    REQUESTED("REQUESTED"),
    RECEIVED("RECEIVED"),
    PREPARING("PREPARING"),
    READY("READY"),
    DELIVERED("DELIVERED");

    private final String value;

    OrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OrderStatus fromValue(String value) {
        for (OrderStatus status : OrderStatus.values()) {
            if (status.getValue().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new NotFoundException(ExceptionMessages.ORDER_STATUS_NOT_FOUND);
    }
}
