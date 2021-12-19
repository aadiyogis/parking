package com.publicis.sapient.parking.service;

import com.publicis.sapient.parking.dto.ParkingDetails;
import com.publicis.sapient.parking.model.ParkingSpot;

import java.util.List;

/**
 * aditya created on 19/12/21
 */
public interface ParkingSpotService {

    ParkingSpot addParkingSpot(ParkingDetails parkingDetails);

    List<ParkingSpot> getAllSpots();

    void removeParkingSpot(ParkingSpot parkingSpot);

    List<ParkingSpot> saveAllParkings(List<ParkingSpot> parkingSpots);

    ParkingSpot update(ParkingSpot parkingSpot);

    ParkingDetails searchByName(String parkingName);
}
