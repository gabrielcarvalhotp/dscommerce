package com.agvsistemas.dscommerce.dto;

import com.agvsistemas.dscommerce.entities.OrderItem;

public class OrderItemDTO {
    private Long productId;
    private String productName;
    private Double productPrice;
    private Integer quantity;
    private String imgUrl;

    public OrderItemDTO() {
    }

    public OrderItemDTO(Long productId, String productName, Double productPrice, Integer quantity, String imgUrl) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.imgUrl = imgUrl;
    }

    public OrderItemDTO(OrderItem entity) {
        this.productId = entity.getProduct().getId();
        this.productName = entity.getProduct().getName();
        this.productPrice = entity.getPrice();
        this.quantity = entity.getQuantity();
        this.imgUrl = entity.getProduct().getImgUrl();
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Double getSubTotal() {
        return productPrice * quantity;
    }
}
