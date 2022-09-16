package com.rental.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter @Setter
public class ReservationModifyDto implements Serializable {

    @NotNull
    private Long id;

    @NotEmpty
    private String period;

    @NotNull
    private BigDecimal cost;
}
