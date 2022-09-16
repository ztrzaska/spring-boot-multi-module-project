package com.rental.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter @Setter
public class ReservationDto implements Serializable {

    @NotEmpty
    private String period;

    @NotNull
    private BigDecimal cost;

    @NotNull
    private Long renterId;

    @NotNull
    private Long objectForRentId;

}
