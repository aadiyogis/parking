package com.publicis.sapient.parking.repository;

import com.publicis.sapient.parking.model.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * aditya created on 19/12/21
 */
@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {
    ParkingSpot findByArea(String area);
}
