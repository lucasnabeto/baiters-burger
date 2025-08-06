package br.com.fiap.baitersburger.infrastructure.web.controller;

import br.com.fiap.baitersburger.domain.port.in.controller.ProductController;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductDataSource;
import br.com.fiap.baitersburger.interfaceadapters.controller.ProductControllerImpl;
import br.com.fiap.baitersburger.interfaceadapters.dto.request.ProductRequestDTO;
import br.com.fiap.baitersburger.interfaceadapters.dto.response.ProductResponseDTO;
import br.com.fiap.baitersburger.interfaceadapters.presenter.ProductPresenter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductRestController {
    private final ProductController controller;

    public ProductRestController(ProductPresenter productPresenter, ProductDataSource dataSource) {
        this.controller = new ProductControllerImpl(productPresenter, dataSource);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findProductsByCategory(@RequestParam String category){
        var products = controller.findProductsByCategory(category);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> findProductsById(@PathVariable String id){
        var product = controller.findProductsById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody ProductRequestDTO productRequestDTO){
        controller.insert(productRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @Valid @RequestBody ProductRequestDTO productRequestDTO){
        controller.update(id,productRequestDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        controller.delete(id);
        return ResponseEntity.noContent().build();
    }
}
