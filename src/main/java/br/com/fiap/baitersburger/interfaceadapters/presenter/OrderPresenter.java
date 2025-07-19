package br.com.fiap.baitersburger.interfaceadapters.presenter;

import br.com.fiap.baitersburger.interfaceadapters.dto.request.OrderRequestDTO;
import br.com.fiap.baitersburger.interfaceadapters.dto.response.InsertOrderResponseDTO;
import br.com.fiap.baitersburger.interfaceadapters.dto.response.OrderResponseDTO;
import br.com.fiap.baitersburger.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProductPresenter.class, CustomerPresenter.class})
public interface OrderPresenter {
    Order toOrder(OrderRequestDTO orderRequestDTO);

    OrderResponseDTO toOrderResponseDTO(Order order);


    @Mapping(target = "orderId", source = "id")
    @Mapping(target = "qrcode", expression = "java(extractQrCode(order.getQrCode()))")
    InsertOrderResponseDTO toInsertOrderResponseDTO(Order order);

    default String extractQrCode(br.com.fiap.baitersburger.domain.valueobject.QrCode qrCode) {
        return qrCode != null ? qrCode.qrData() : null;
    }
}
