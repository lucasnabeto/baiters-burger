package br.com.fiap.baitersburger.adapters.in.controller.mapper;

import br.com.fiap.baitersburger.adapters.in.controller.dto.ProductRequestDTO;
import br.com.fiap.baitersburger.adapters.in.controller.dto.ProductResponseDTO;
import br.com.fiap.baitersburger.application.core.domain.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductRequestDTO productRequestDTO);

    ProductResponseDTO toProductResponseDTO(Product product);
}
