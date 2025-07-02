package br.com.fiap.baitersburger.domain.port.in.controller;

import br.com.fiap.baitersburger.application.dto.request.ProductRequestDTO;
import br.com.fiap.baitersburger.application.dto.response.ProductResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductController {
    List<ProductResponseDTO> findProductsByCategory(String category);
    ProductResponseDTO findProductsById(String id);
    void insert(ProductRequestDTO productRequestDTO);
    void update( String id, ProductRequestDTO productRequestDTO);
    void delete( String id);
}
