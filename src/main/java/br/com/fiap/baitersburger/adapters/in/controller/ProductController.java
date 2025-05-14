package br.com.fiap.baitersburger.adapters.in.controller;

import br.com.fiap.baitersburger.adapters.in.controller.dto.ProductRequestDTO;
import br.com.fiap.baitersburger.adapters.in.controller.mapper.ProductMapper;
import br.com.fiap.baitersburger.application.core.domain.Customer;
import br.com.fiap.baitersburger.application.core.domain.Product;
import br.com.fiap.baitersburger.application.ports.in.product.InsertProductInputPort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    private final ProductMapper productMapper;

    private final InsertProductInputPort insertProductInputPort;

    public ProductController(ProductMapper productMapper, InsertProductInputPort insertProductInputPort){
        this.productMapper = productMapper;
        this.insertProductInputPort = insertProductInputPort;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody ProductRequestDTO productRequestDTO){
        var product = productMapper.toProduct(productRequestDTO);
        insertProductInputPort.insert(product);
        return ResponseEntity.status(201).build();
    }

    @PutMapping
    public ResponseEntity<Void> update()
}
