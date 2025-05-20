package br.com.fiap.baitersburger.adapters.out.mongodb.repository.mappers;

import br.com.fiap.baitersburger.adapters.out.mongodb.repository.entity.ProductEntity;
import br.com.fiap.baitersburger.core.domain.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {
    ProductEntity toProductEntity(Product product);

    Product toProduct(ProductEntity productEntity);
}
