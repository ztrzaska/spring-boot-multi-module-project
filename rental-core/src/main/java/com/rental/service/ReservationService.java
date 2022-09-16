package com.rental.service;

import com.rental.dto.ReservationDto;
import com.rental.entity.ObjectForRent;
import com.rental.entity.Reservation;
import com.rental.repository.ObjectForRentalRepository;
import com.rental.repository.RenterRepository;
import com.rental.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.rental.dto.ReservationModifyDto;
import com.rental.entity.Renter;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationValidator reservationValidator;
    private final RenterRepository renterRepository;
    private final ObjectForRentalRepository objectForRentalRepository;
    private final ReservationRepository reservationRepository;

    public synchronized Reservation create(ReservationDto reservation) {
        Optional<Renter> renter = renterRepository.findById(reservation.getRenterId());
        Optional<ObjectForRent> objectForRent = objectForRentalRepository.findById(reservation.getObjectForRentId());

        reservationValidator.validate(renter, objectForRent);
        Reservation newReservation = new Reservation(reservation.getPeriod(), reservation.getCost(), renter.get(),
                objectForRent.get());
        return reservationRepository.save(newReservation);
    }

    public void modify(ReservationModifyDto reservation) {
        Optional<Reservation> reservationToModifyOptional = reservationRepository.findById(reservation.getId());

        if (!reservationToModifyOptional.isPresent()) {
            throw new UnsupportedOperationException("Reservation not exists");
        }

        Reservation reservationToModify = reservationToModifyOptional.get();
        reservationToModify.setCost(reservation.getCost());
        reservationToModify.setPeriod(reservation.getPeriod());

        reservationRepository.save(reservationToModify);
    }

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public List<Reservation> getReservationsByRenter(String renterName) {
        return reservationRepository.findByRenterName(renterName);
    }

    public List<Reservation> findByObjectForRentName(String renterName) {
        return reservationRepository.findByObjectForRentName(renterName);
    }

}
