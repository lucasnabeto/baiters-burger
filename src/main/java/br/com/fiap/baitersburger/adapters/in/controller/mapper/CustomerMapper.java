package br.com.fiap.baitersburger.adapters.in.controller.mapper;

import br.com.fiap.baitersburger.adapters.in.controller.dto.customer.CustomerRequestDTO;
import br.com.fiap.baitersburger.adapters.in.controller.dto.customer.CustomerResponseDTO;
import br.com.fiap.baitersburger.core.domain.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toCustomer(CustomerRequestDTO customerRequestDTO);

    CustomerResponseDTO toCustomerResponseDTO(Customer customer);
}
