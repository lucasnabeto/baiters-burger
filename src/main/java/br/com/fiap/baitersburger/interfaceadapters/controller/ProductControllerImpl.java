package br.com.fiap.baitersburger.interfaceadapters.controller;

import br.com.fiap.baitersburger.application.dto.request.ProductRequestDTO;
import br.com.fiap.baitersburger.application.dto.response.ProductResponseDTO;
import br.com.fiap.baitersburger.domain.port.in.controller.ProductController;
import br.com.fiap.baitersburger.domain.port.in.usecase.product.*;
import br.com.fiap.baitersburger.infrastructure.web.mapper.ProductMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductControllerImpl implements ProductController {


    private final ProductMapper productMapper;
    private final InsertProductUseCase insertProductUseCase;
    private final FindProductByCategoryUseCase findProductByCategoryUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final FindProductByIdUseCase findProductByIdUseCase;

    public ProductControllerImpl(ProductMapper productMapper,
                                 InsertProductUseCase insertProductUseCase,
                                 FindProductByCategoryUseCase findProductByCategoryUseCase,
                                 UpdateProductUseCase updateProductUseCase,
                                 DeleteProductUseCase deleteProductUseCase,
                                 FindProductByIdUseCase findProductByIdUseCase) {

        this.productMapper = productMapper;
        this.insertProductUseCase = insertProductUseCase;
        this.findProductByCategoryUseCase = findProductByCategoryUseCase;
        this.updateProductUseCase = updateProductUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
        this.findProductByIdUseCase = findProductByIdUseCase;
    }

    @Override
    public List<ProductResponseDTO> findProductsByCategory(String category) {
        return findProductByCategoryUseCase.findByCategory(category)
                .stream()
                .map(productMapper::toProductResponseDTO)
                .toList();

    }

    @Override
    public ProductResponseDTO findProductsById(String id) {
        var product = findProductByIdUseCase.findById(id);
        return productMapper.toProductResponseDTO(product);

    }

    @Override
    public void insert(ProductRequestDTO productRequestDTO) {
        var product = productMapper.toProduct(productRequestDTO);
        insertProductUseCase.insert(product);
    }

    @Override
    public void update(String id, ProductRequestDTO productRequestDTO) {
        var product = productMapper.toProduct(productRequestDTO);
        product.setId(id);
        updateProductUseCase.update(product);
    }

    @Override
    public void delete(String id) {
        deleteProductUseCase.delete(id);
    }
}
