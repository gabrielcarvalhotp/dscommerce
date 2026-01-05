package com.agvsistemas.dscommerce.repositories;

import com.agvsistemas.dscommerce.entities.Category;
import com.agvsistemas.dscommerce.entities.OrderItem;
import com.agvsistemas.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
