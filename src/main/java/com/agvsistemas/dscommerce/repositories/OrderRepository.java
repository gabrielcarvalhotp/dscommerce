package com.agvsistemas.dscommerce.repositories;

import com.agvsistemas.dscommerce.entities.Category;
import com.agvsistemas.dscommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
