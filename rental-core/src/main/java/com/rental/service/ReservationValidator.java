package com.rental.service;

import com.rental.entity.ObjectForRent;
import com.rental.entity.Renter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReservationValidator {

    void validate(Optional<Renter> renter, Optional<ObjectForRent> objectForRent) {
        if (!renter.isPresent()) {
            throw new UnsupportedOperationException("Renter not exists");
        }

        if (!objectForRent.isPresent()) {
            throw new UnsupportedOperationException("Object for rent not exists");
        }
    }
}
