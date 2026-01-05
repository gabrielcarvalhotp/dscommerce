package com.agvsistemas.dscommerce.dto;

import com.agvsistemas.dscommerce.entities.Payment;
import jakarta.persistence.Column;

import java.time.Instant;

public class PaymentDTO {
    private Long id;
    private Instant moment;

    public PaymentDTO() {
    }

    public PaymentDTO(Long id, Instant moment) {
        this.id = id;
        this.moment = moment;
    }

    public PaymentDTO(Payment entity) {
        this.id = entity.getId();
        this.moment = entity.getMoment();
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }
}
