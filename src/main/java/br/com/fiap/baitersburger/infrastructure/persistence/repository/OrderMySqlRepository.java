package br.com.fiap.baitersburger.infrastructure.persistence.repository;

import br.com.fiap.baitersburger.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.infrastructure.persistence.entity.OrderEntity;
import br.com.fiap.baitersburger.infrastructure.persistence.entity.OrderMySqlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.Aggregation;

import java.util.List;

public interface OrderMySqlRepository extends JpaRepository<OrderMySqlEntity, String> {

    List<OrderMySqlEntity> findByStatus(OrderStatus status);

    @Query("SELECT o FROM OrderMySqlEntity o WHERE o.status IN :statuses " +
            "ORDER BY " +
            "CASE o.status " +
            "  WHEN 'READY' THEN 0 " +
            "  WHEN 'PREPARING' THEN 1 " +
            "  WHEN 'RECEIVED' THEN 2 " +
            "  ELSE 3 END, " +
            "o.createdAt ASC")
    List<OrderMySqlEntity> findByStatuses(List<OrderStatus> statuses);
}
