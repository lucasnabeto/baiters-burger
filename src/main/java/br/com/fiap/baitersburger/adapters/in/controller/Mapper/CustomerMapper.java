package br.com.fiap.baitersburger.adapters.in.controller.Mapper;

import br.com.fiap.baitersburger.adapters.in.controller.request.CustomerRequest;
import br.com.fiap.baitersburger.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toCustomer(CustomerRequest customerRequest);
}
