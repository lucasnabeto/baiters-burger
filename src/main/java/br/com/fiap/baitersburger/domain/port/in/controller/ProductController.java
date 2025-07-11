package br.com.fiap.baitersburger.domain.port.in.controller;

import br.com.fiap.baitersburger.interfaceadapters.dto.request.ProductRequestDTO;
import br.com.fiap.baitersburger.interfaceadapters.dto.response.ProductResponseDTO;

import java.util.List;

public interface ProductController {
    List<ProductResponseDTO> findProductsByCategory(String category);
    ProductResponseDTO findProductsById(String id);
    void insert(ProductRequestDTO productRequestDTO);
    void update( String id, ProductRequestDTO productRequestDTO);
    void delete( String id);
}
