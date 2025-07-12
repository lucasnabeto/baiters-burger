package br.com.fiap.baitersburger.interfaceadapters.dto.response;

import br.com.fiap.baitersburger.domain.enums.Category;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductResponseDTO {
    private String productName;
    private Category category;
    private BigDecimal price;
    private String description;
    private List<String> imagesUrls;
}
