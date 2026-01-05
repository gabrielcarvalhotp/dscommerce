package com.agvsistemas.dscommerce.services;

import com.agvsistemas.dscommerce.dto.OrderDTO;
import com.agvsistemas.dscommerce.dto.ProductDTO;
import com.agvsistemas.dscommerce.entities.Order;
import com.agvsistemas.dscommerce.entities.Product;
import com.agvsistemas.dscommerce.exceptions.ResourceNotFoundException;
import com.agvsistemas.dscommerce.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }
}
