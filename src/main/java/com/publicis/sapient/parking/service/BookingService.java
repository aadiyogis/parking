package com.publicis.sapient.parking.service;

import com.publicis.sapient.parking.dto.BookingDetails;
import com.publicis.sapient.parking.model.Booking;

import java.util.List;

/**
 * aditya created on 19/12/21
 */
public interface BookingService {
    Booking bookParking(BookingDetails bookingDetails);

//    List<Booking>
}
