package com.publicis.sapient.parking.service.impl;

import com.publicis.sapient.parking.dto.ParkingDetails;
import com.publicis.sapient.parking.mapper.ParkingMapper;
import com.publicis.sapient.parking.model.ParkingSpot;
import com.publicis.sapient.parking.repository.ParkingSpotRepository;
import com.publicis.sapient.parking.service.ParkingSpotService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * aditya created on 19/12/21
 */
@Slf4j
@AllArgsConstructor
@Service
public class ParkingSpotServiceImpl implements ParkingSpotService {

    private ParkingSpotRepository parkingSpotRepository;
    private ParkingMapper parkingMapper;

    @Override
    public ParkingSpot addParkingSpot(ParkingDetails parkingDetails) {
        ParkingSpot parkingSpot = parkingMapper.getParkingSpot(parkingDetails);
        return parkingSpotRepository.saveAndFlush(parkingSpot);
//        return parkingMapper.getParkingDetails(spot);
    }

    @Override
    public List<ParkingSpot> getAllSpots() {
//        List<ParkingSpot> parkignspots =
          return parkingSpotRepository.findAll();
//        List<ParkingDetails> parkingDetails = new ArrayList<>();
//        for (ParkingSpot parkingSpot : parkignspots) {
//            parkingDetails.add(parkingMapper.getParkingDetails(parkingSpot));
//        }
    }

    @Override
    public void removeParkingSpot(ParkingSpot parkingSpot) {
        // ParkingSpot parkingSpot = parkingMapper.getParkingSpot(parkingDetails);
        parkingSpotRepository.delete(parkingSpot);
    }

    @Override
    public List<ParkingSpot> saveAllParkings(List<ParkingSpot> parkingSpots) {
        return parkingSpotRepository.saveAll(parkingSpots);
    }

    @Override
    public ParkingSpot update(ParkingSpot parkingSpot) {
        return parkingSpotRepository.saveAndFlush(parkingSpot);
    }

    @Override
    public ParkingDetails searchByName(String parkingName) {

        ParkingSpot parkingSpot = parkingSpotRepository.findByArea(parkingName);
        if (parkingSpot == null) {
            log.error("No location with name: " + parkingName);
        } else {
            return parkingMapper.getParkingDetails(parkingSpot);
        }
        return null;
    }
}
