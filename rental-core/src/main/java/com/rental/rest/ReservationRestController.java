package com.rental.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.rental.dto.ReservationDto;
import com.rental.dto.ReservationModifyDto;
import com.rental.entity.Reservation;
import com.rental.service.ReservationService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reservations")
public class ReservationRestController {

    private final ReservationService reservationService;

    @PostMapping(path = "/")
    public Long create(@Validated @RequestBody ReservationDto reservation) {
        Reservation newReservation = reservationService.create(reservation);
        return newReservation.getId();
    }

    @PutMapping("/")
    public void modify(@Validated @RequestBody ReservationModifyDto reservation) {
        reservationService.modify(reservation);
    }

    @GetMapping("/")
    public List<Reservation> getAll() {
        return reservationService.getAll();
    }

    @GetMapping("/find-by-renter")
    public List<Reservation> getReservationsByRenter(@RequestParam(name = "name") String name) {
        return reservationService.getReservationsByRenter(name);
    }



    @GetMapping("/find-by-object-for-rent")
    public List<Reservation> findByObjectForRentName(@RequestParam(name = "name") String name) {
        return reservationService.findByObjectForRentName(name);
    }

}
