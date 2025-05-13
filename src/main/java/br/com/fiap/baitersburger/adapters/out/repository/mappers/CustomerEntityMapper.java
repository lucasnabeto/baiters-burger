package br.com.fiap.baitersburger.adapters.out.repository.mappers;

import br.com.fiap.baitersburger.adapters.out.repository.entity.CustomerEntity;
import br.com.fiap.baitersburger.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);

}
