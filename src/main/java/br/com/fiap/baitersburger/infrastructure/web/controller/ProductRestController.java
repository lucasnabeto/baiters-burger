package br.com.fiap.baitersburger.infrastructure.web.controller;

import br.com.fiap.baitersburger.interfaceadapters.dto.request.ProductRequestDTO;
import br.com.fiap.baitersburger.interfaceadapters.dto.response.ProductResponseDTO;
import br.com.fiap.baitersburger.domain.port.in.usecase.product.*;
import br.com.fiap.baitersburger.interfaceadapters.presenter.ProductPresenter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductRestController {
    private final ProductPresenter productPresenter;
    private final InsertProductUseCase insertProductInputPort;
    private final FindProductByCategoryUseCase findProductByCategoryInputPort;
    private final UpdateProductUseCase updateProductInputPort;
    private final DeleteProductUseCase deleteProductInputPort;
    private final FindProductByIdUseCase findProductByIdInputPort;

    public ProductRestController(ProductPresenter productPresenter,
                                 InsertProductUseCase insertProductInputPort,
                                 FindProductByCategoryUseCase findProductByCategoryInputPort,
                                 UpdateProductUseCase updateProductInputPort,
                                 DeleteProductUseCase deleteProductInputPort,
                                 FindProductByIdUseCase findProductByIdInputPort) {
        this.productPresenter = productPresenter;
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
                .map(productPresenter::toProductResponseDTO)
                .toList();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> findProductsById(@PathVariable String id){
        var product = findProductByIdInputPort.findById(id);
        var productResponseDTO = productPresenter.toProductResponseDTO(product);
        return ResponseEntity.ok(productResponseDTO);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody ProductRequestDTO productRequestDTO){
        var product = productPresenter.toProduct(productRequestDTO);
        insertProductInputPort.insert(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @Valid @RequestBody ProductRequestDTO productRequestDTO){
        var product = productPresenter.toProduct(productRequestDTO);
        product.setId(id);
        updateProductInputPort.update(product);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        deleteProductInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
