package br.com.fiap.baitersburger.adapters.in.controller.mapper;

import br.com.fiap.baitersburger.adapters.in.controller.dto.CustomerRequestDTO;
import br.com.fiap.baitersburger.adapters.in.controller.dto.CustomerResponseDTO;
import br.com.fiap.baitersburger.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toCustomer(CustomerRequestDTO customerRequestDTO);

    CustomerResponseDTO toCustomerResponseDTO(Customer customer);
}
