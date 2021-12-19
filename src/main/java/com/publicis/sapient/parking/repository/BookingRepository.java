package com.publicis.sapient.parking.repository;

import com.publicis.sapient.parking.model.Booking;
import com.publicis.sapient.parking.model.ParkingSpot;
import com.publicis.sapient.parking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * aditya created on 19/12/21
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByUserAndParkingSpot(User user, ParkingSpot parkingSpot);
    List<Booking> findByParkingSpot(ParkingSpot parkingSpot);

}
