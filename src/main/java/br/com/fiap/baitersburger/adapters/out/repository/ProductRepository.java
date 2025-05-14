package br.com.fiap.baitersburger.adapters.out.repository;

import br.com.fiap.baitersburger.adapters.out.repository.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {

}
