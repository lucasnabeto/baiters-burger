package br.com.fiap.baitersburger.interfaceadapters.presenter;

import br.com.fiap.baitersburger.interfaceadapters.dto.request.ProductRequestDTO;
import br.com.fiap.baitersburger.interfaceadapters.dto.response.ProductResponseDTO;
import br.com.fiap.baitersburger.infrastructure.persistence.entity.ProductEntity;
import br.com.fiap.baitersburger.domain.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductPresenter {
    Product toProduct(ProductRequestDTO productRequestDTO);

    ProductResponseDTO toProductResponseDTO(Product product);

    Product toProduct(ProductEntity productEntity);
}
