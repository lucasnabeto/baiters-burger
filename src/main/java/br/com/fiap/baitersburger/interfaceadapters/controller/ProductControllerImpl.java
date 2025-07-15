package br.com.fiap.baitersburger.interfaceadapters.controller;

import br.com.fiap.baitersburger.interfaceadapters.dto.request.ProductRequestDTO;
import br.com.fiap.baitersburger.interfaceadapters.dto.response.ProductResponseDTO;
import br.com.fiap.baitersburger.application.usecase.product.*;
import br.com.fiap.baitersburger.domain.port.in.controller.ProductController;
import br.com.fiap.baitersburger.domain.port.in.usecase.product.*;
import br.com.fiap.baitersburger.domain.port.out.gateway.ProductGateway;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductDataSource;
import br.com.fiap.baitersburger.interfaceadapters.presenter.ProductPresenter;
import br.com.fiap.baitersburger.interfaceadapters.gateway.ProductGatewayImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductControllerImpl implements ProductController {


    private final ProductPresenter productPresenter;
    private final InsertProductUseCase insertProductUseCase;
    private final FindProductByCategoryUseCase findProductByCategoryUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final FindProductByIdUseCase findProductByIdUseCase;

    public ProductControllerImpl(ProductPresenter productPresenter, ProductDataSource productDataSource) {
        ProductGateway productGateway = new ProductGatewayImpl(productDataSource);


        this.productPresenter = productPresenter;
        this.insertProductUseCase = new InsertProductUseCaseImpl(productGateway);
        this.findProductByCategoryUseCase = new FindProductByCategoryUseCaseImpl(productGateway);
        this.updateProductUseCase = new UpdateProductUseCaseImpl(productGateway);
        this.deleteProductUseCase = new DeleteProductUseCaseImpl(productGateway);
        this.findProductByIdUseCase = new FindProductByIdUseCaseImpl(productGateway);
    }

    @Override
    public List<ProductResponseDTO> findProductsByCategory(String category) {
        return findProductByCategoryUseCase.findByCategory(category)
                .stream()
                .map(productPresenter::toProductResponseDTO)
                .toList();

    }

    @Override
    public ProductResponseDTO findProductsById(String id) {
        var product = findProductByIdUseCase.findById(id);
        return productPresenter.toProductResponseDTO(product);

    }

    @Override
    public void insert(ProductRequestDTO productRequestDTO) {
        var product = productPresenter.toProduct(productRequestDTO);
        insertProductUseCase.insert(product);
    }

    @Override
    public void update(String id, ProductRequestDTO productRequestDTO) {
        var product = productPresenter.toProduct(productRequestDTO);
        product.setId(id);
        updateProductUseCase.update(product);
    }

    @Override
    public void delete(String id) {
        deleteProductUseCase.delete(id);
    }
}
