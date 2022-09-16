package com.rental.repository;

import com.rental.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("select r from Reservation r join r.renter ren where ren.name = :renterName")
    List<Reservation> findByRenterName(@Param("renterName") String renterName);

    @Query("select r from Reservation r join r.objectForRent obj where obj.name = :objectForRent")
    List<Reservation> findByObjectForRentName(@Param("objectForRent") String objectForRent);
}
