package br.com.fiap.baitersburger.adapters.in.controller.mapper;

import br.com.fiap.baitersburger.adapters.in.controller.dto.product.ProductRequestDTO;
import br.com.fiap.baitersburger.adapters.in.controller.dto.product.ProductResponseDTO;
import br.com.fiap.baitersburger.adapters.out.mongodb.repository.entity.ProductEntity;
import br.com.fiap.baitersburger.core.domain.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductRequestDTO productRequestDTO);

    ProductResponseDTO toProductResponseDTO(Product product);

    Product toProduct(ProductEntity productEntity);
}
