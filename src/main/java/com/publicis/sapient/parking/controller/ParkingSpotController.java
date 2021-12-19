package com.publicis.sapient.parking.controller;

import com.publicis.sapient.parking.dto.ParkingDetails;
import com.publicis.sapient.parking.model.ParkingSpot;
import com.publicis.sapient.parking.service.ParkingSpotService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * aditya created on 19/12/21
 */
@Controller
@RequestMapping("/spots")
@AllArgsConstructor
@Slf4j
public class ParkingSpotController {
    private ParkingSpotService parkingSpotService;

    @PostMapping("/admin/add")
    public ResponseEntity<ParkingSpot> addParkingSpot(@RequestBody ParkingDetails parkingDetails) {
        log.debug("ParkingSpotController --- addParkingSpot --- started");
        ParkingSpot details = parkingSpotService.addParkingSpot(parkingDetails);
        log.debug("ParkingSpotController --- addParkingSpot --- ended");
        return new ResponseEntity<>(details, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ParkingSpot>> getAllParkings() {
        log.debug("ParkingSpotController --- getAllParkings --- started");
        List<ParkingSpot> allSpots = parkingSpotService.getAllSpots();
        ResponseEntity<List<ParkingSpot>> responseEntity = new ResponseEntity(allSpots, HttpStatus.OK);
        log.debug("ParkingSpotController --- getAllParkings --- ended");
        return responseEntity;
    }

    @DeleteMapping("/admin/delete")
    public ResponseEntity<ParkingSpot> deleteParkingSpot(@RequestBody ParkingSpot parkingSpot) {
        log.debug("ParkingSpotController --- deleteParkingSpot --- started");
        parkingSpotService.removeParkingSpot(parkingSpot);
        return new ResponseEntity<>(parkingSpot, HttpStatus.OK);
    }

    @PutMapping("/admin/update")
    public ResponseEntity<ParkingSpot> updateParkingSpot(@RequestBody ParkingSpot parkingSpot) {
        log.debug("ParkingSpotController --- updateParkingSpot --- started");
        ParkingSpot updatede = parkingSpotService.update(parkingSpot);
        return new ResponseEntity<>(updatede, HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<ParkingDetails> findParkingByName(@RequestParam("name") String area) {
        log.debug("ParkingSpotController --- findParkingByName --- started");
        ParkingDetails parkingDetails = parkingSpotService.searchByName(area);
        return new ResponseEntity<>(parkingDetails, HttpStatus.OK);
    }
}
