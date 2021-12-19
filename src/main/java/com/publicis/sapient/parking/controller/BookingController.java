package com.publicis.sapient.parking.controller;

import com.publicis.sapient.parking.dto.BookingDetails;
import com.publicis.sapient.parking.exception.SmartParkingException;
import com.publicis.sapient.parking.model.Booking;
import com.publicis.sapient.parking.service.BookingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * aditya created on 19/12/21
 */
@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/booking")
public class BookingController {

    private BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<?> book(@RequestBody BookingDetails bookingDetails) {
        ResponseEntity responseEntity;
        try {
            Booking booking = bookingService.bookParking(bookingDetails);
            responseEntity = new ResponseEntity<>(booking, HttpStatus.CREATED);
        } catch (SmartParkingException spe) {
            log.error("Error while booking:");
            responseEntity = new ResponseEntity<>(spe.getErrorCode() + ":" + spe.getErrorText(), HttpStatus.INTERNAL_SERVER_ERROR );
        }
        return responseEntity;
    }

    @PostMapping("/create/bulk")
    public ResponseEntity<?> bookBulk(@RequestBody List<BookingDetails> bookingDetailsList) {
        ResponseEntity responseEntity = null;
//        try {
//            Booking booking = bookingService.bookBulkParking(bookingDetailsList);
//            responseEntity = new ResponseEntity<>(booking, HttpStatus.CREATED);
//        } catch (SmartParkingException spe) {
//            log.error("Error while booking:");
//            responseEntity = new ResponseEntity<>(spe.getErrorCode() + ":" + spe.getErrorText(), HttpStatus.INTERNAL_SERVER_ERROR );
//        }
        return responseEntity;
    }
}
