package br.com.fiap.baitersburger.infrastructure.persistence.mapper;

import br.com.fiap.baitersburger.infrastructure.persistence.entity.CustomerEntity;
import br.com.fiap.baitersburger.domain.model.Customer;
import br.com.fiap.baitersburger.infrastructure.persistence.entity.CustomerMySqlEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);

    CustomerMySqlEntity toCustomerMySqlEntity(Customer customer);

    Customer toCustomer(CustomerMySqlEntity customerMySqlEntity);

}
