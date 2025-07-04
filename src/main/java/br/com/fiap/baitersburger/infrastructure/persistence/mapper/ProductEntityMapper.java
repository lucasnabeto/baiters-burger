package br.com.fiap.baitersburger.infrastructure.persistence.mapper;

import br.com.fiap.baitersburger.infrastructure.persistence.entity.ProductEntity;
import br.com.fiap.baitersburger.domain.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {
    ProductEntity toProductEntity(Product product);

    Product toProduct(ProductEntity productEntity);
}
