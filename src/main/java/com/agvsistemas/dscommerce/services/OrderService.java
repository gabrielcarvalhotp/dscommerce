package com.agvsistemas.dscommerce.services;

import com.agvsistemas.dscommerce.dto.OrderDTO;
import com.agvsistemas.dscommerce.dto.ProductDTO;
import com.agvsistemas.dscommerce.entities.*;
import com.agvsistemas.dscommerce.exceptions.ResourceNotFoundException;
import com.agvsistemas.dscommerce.repositories.OrderItemRepository;
import com.agvsistemas.dscommerce.repositories.OrderRepository;
import com.agvsistemas.dscommerce.repositories.ProductRepository;
import com.agvsistemas.dscommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);

        User client = userService.authenticated();
        order.setClient(client);

        for (var itemDto : dto.getItems()) {
            Product product = productRepository.getReferenceById(itemDto.getProductId());
            OrderItem orderItem = new OrderItem(order, product, itemDto.getQuantity(), product.getPrice());
            order.getItems().add(orderItem);
        }

        orderRepository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDTO(order);
    }
}
