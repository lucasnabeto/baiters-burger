package br.com.fiap.baitersburger.adapters.in.controller;

import br.com.fiap.baitersburger.adapters.in.controller.dto.ProductRequestDTO;
import br.com.fiap.baitersburger.adapters.in.controller.dto.ProductResponseDTO;
import br.com.fiap.baitersburger.adapters.in.controller.mapper.ProductMapper;
import br.com.fiap.baitersburger.application.core.domain.Customer;
import br.com.fiap.baitersburger.application.core.domain.Product;
import br.com.fiap.baitersburger.application.ports.in.product.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    private final ProductMapper productMapper;
    private final InsertProductInputPort insertProductInputPort;
    private final FindProductByCategoryInputPort findProductByCategoryInputPort;
    private final UpdateProductInputPort updateProductInputPort;
    private final DeleteProductInputPort deleteProductInputPort;
    private final FindProductByIdInputPort findProductByIdInputPort;

    public ProductController(ProductMapper productMapper,
                             InsertProductInputPort insertProductInputPort,
                             FindProductByCategoryInputPort findProductByCategoryInputPort,
                             UpdateProductInputPort updateProductInputPort,
                             DeleteProductInputPort deleteProductInputPort,
                             FindProductByIdInputPort findProductByIdInputPort) {
        this.productMapper = productMapper;
        this.insertProductInputPort = insertProductInputPort;
        this.findProductByCategoryInputPort = findProductByCategoryInputPort;
        this.updateProductInputPort = updateProductInputPort;
        this.deleteProductInputPort = deleteProductInputPort;
        this.findProductByIdInputPort = findProductByIdInputPort;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findProductsByCategory(@RequestParam String category){
        var products = findProductByCategoryInputPort.findByCategory(category)
                .stream()
                .map(productMapper::toProductResponseDTO)
                .toList();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> findProductsById(@PathVariable String id){
        var product = findProductByIdInputPort.findById(id);
        var productResponseDTO = productMapper.toProductResponseDTO(product);
        return ResponseEntity.ok(productResponseDTO);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody ProductRequestDTO productRequestDTO){
        var product = productMapper.toProduct(productRequestDTO);
        insertProductInputPort.insert(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @Valid @RequestBody ProductRequestDTO productRequestDTO){
        var product = productMapper.toProduct(productRequestDTO);
        updateProductInputPort.update(id, product);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        deleteProductInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
