package br.com.fiap.baitersburger.infrastructure.web.mapper;

import br.com.fiap.baitersburger.application.dto.request.ProductRequestDTO;
import br.com.fiap.baitersburger.application.dto.response.ProductResponseDTO;
import br.com.fiap.baitersburger.infrastructure.persistence.entity.ProductEntity;
import br.com.fiap.baitersburger.domain.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductRequestDTO productRequestDTO);

    ProductResponseDTO toProductResponseDTO(Product product);

    Product toProduct(ProductEntity productEntity);
}
