package br.com.fiap.baitersburger.interfaceadapters.dto.request;

import br.com.fiap.baitersburger.domain.enums.Category;


public record CurrentProducts(String productName, Category category, String description) {
}
