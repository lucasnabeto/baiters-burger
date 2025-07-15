package br.com.fiap.baitersburger.interfaceadapters.presenter;

import br.com.fiap.baitersburger.interfaceadapters.dto.request.CustomerRequestDTO;
import br.com.fiap.baitersburger.interfaceadapters.dto.response.CustomerResponseDTO;
import br.com.fiap.baitersburger.domain.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerPresenter {
    Customer toCustomer(CustomerRequestDTO customerRequestDTO);

    CustomerResponseDTO toCustomerResponseDTO(Customer customer);
}
