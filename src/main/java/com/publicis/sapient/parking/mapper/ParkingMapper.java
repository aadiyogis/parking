package com.publicis.sapient.parking.mapper;

import com.publicis.sapient.parking.dto.BookingDetails;
import com.publicis.sapient.parking.dto.ParkingDetails;
import com.publicis.sapient.parking.model.Booking;
import com.publicis.sapient.parking.model.Dates;
import com.publicis.sapient.parking.model.ParkingSpot;
import org.springframework.stereotype.Component;

/**
 * aditya created on 19/12/21
 */
@Component
public class ParkingMapper {
    
    public ParkingDetails getParkingDetails(ParkingSpot parkingSpot) {
        ParkingDetails parkingDetails = new ParkingDetails();
        parkingDetails.setArea(parkingSpot.getArea());
        parkingDetails.setLatitude(parkingSpot.getLatitude());
        parkingDetails.setLongitude(parkingSpot.getLongitude());
        parkingDetails.setPinCode(parkingSpot.getPinCode());
        return parkingDetails;
    }
    
    public ParkingSpot getParkingSpot(ParkingDetails parkingDetails) {
        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.setArea(parkingDetails.getArea());
        parkingSpot.setLatitude(parkingDetails.getLatitude());
        parkingSpot.setLongitude(parkingDetails.getLongitude());
        parkingSpot.setPinCode(parkingDetails.getPinCode());
        
        return parkingSpot;
    }

    public Booking getBooking(BookingDetails bookingDetails) {
        Booking booking = new Booking();
        Dates dates = new Dates();
        dates.setStart(bookingDetails.getStartTime());
        dates.setEnd(bookingDetails.getEndTime());

        booking.setDates(dates);
        return booking;
    }
}
