package br.com.fiap.baitersburger.interfaceadapters.presenter;

import br.com.fiap.baitersburger.interfaceadapters.dto.request.OrderRequestDTO;
import br.com.fiap.baitersburger.interfaceadapters.dto.response.OrderResponseDTO;
import br.com.fiap.baitersburger.domain.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductPresenter.class, CustomerPresenter.class})
public interface OrderPresenter {
    Order toOrder(OrderRequestDTO orderRequestDTO);

    OrderResponseDTO toOrderResponseDTO(Order order);
}
