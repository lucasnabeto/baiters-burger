package br.com.fiap.baitersburger.adapters.out.repository.mappers;

import br.com.fiap.baitersburger.adapters.out.repository.entity.CustomerEntity;
import br.com.fiap.baitersburger.adapters.out.repository.entity.ProductEntity;
import br.com.fiap.baitersburger.application.core.domain.Customer;
import br.com.fiap.baitersburger.application.core.domain.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {
    ProductEntity toProductEntity(Product product);

    Product toProduct(ProductEntity productEntity);
}
