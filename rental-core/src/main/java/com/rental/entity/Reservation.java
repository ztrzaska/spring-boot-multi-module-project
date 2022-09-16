package com.rental.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "RESERVATION")
@Getter @Setter
public class Reservation {

    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column
    private String period;

    @Column
    private BigDecimal cost;

    @ManyToOne
    @JoinColumn(name="RENTAL_ID", nullable = false)
    private Renter renter;

    @ManyToOne
    @JoinColumn(name="OBJECT_FOR_RENT_ID", nullable = false)
    private ObjectForRent objectForRent;

    public Reservation() {
    }

    public Reservation(String period, BigDecimal cost, Renter renter, ObjectForRent objectForRent) {
        this.period = period;
        this.cost = cost;
        this.renter = renter;
        this.objectForRent = objectForRent;
    }
}
