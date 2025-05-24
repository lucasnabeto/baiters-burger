package br.com.fiap.baitersburger.adapters.out.mongodb.repository.mappers;

import br.com.fiap.baitersburger.adapters.out.mongodb.repository.entity.CustomerEntity;
import br.com.fiap.baitersburger.core.domain.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);

}
