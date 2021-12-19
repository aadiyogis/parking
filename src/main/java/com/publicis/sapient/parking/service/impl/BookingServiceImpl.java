package com.publicis.sapient.parking.service.impl;

import com.publicis.sapient.parking.dto.BookingDetails;
import com.publicis.sapient.parking.exception.SmartParkingException;
import com.publicis.sapient.parking.mapper.ParkingMapper;
import com.publicis.sapient.parking.model.Booking;
import com.publicis.sapient.parking.model.Dates;
import com.publicis.sapient.parking.model.ParkingSpot;
import com.publicis.sapient.parking.model.User;
import com.publicis.sapient.parking.repository.BookingRepository;
import com.publicis.sapient.parking.repository.DatesRepository;
import com.publicis.sapient.parking.repository.ParkingSpotRepository;
import com.publicis.sapient.parking.repository.UserRepository;
import com.publicis.sapient.parking.service.BookingService;
import com.publicis.sapient.parking.validation.ValidationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.publicis.sapient.parking.constant.ErrorConstant.SMP003;
import static com.publicis.sapient.parking.constant.ErrorConstant.SMP004;

/**
 * aditya created on 19/12/21
 */
@Slf4j
@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;
    private ValidationService validateService;
    private ParkingSpotRepository parkingSpotRepository;
    private UserRepository userRepository;
    private ParkingMapper mapper;
    private DatesRepository datesRepository;

    @Override
    public Booking bookParking(BookingDetails bookingDetails) {
        validateService.validateInput(bookingDetails);
        Booking booking = mapper.getBooking(bookingDetails);
        if (validateBookingDetails(bookingDetails, booking)) {
            bookingRepository.saveAndFlush(booking);
        }
        return booking;
    }

    private boolean validateBookingDetails(BookingDetails bookingDetails, Booking booking) {
        boolean canBook = true;
        Optional<ParkingSpot> parkingSpotOptional = parkingSpotRepository.findById(bookingDetails.getLocationId());
        if (parkingSpotOptional.isPresent()) {
            ParkingSpot parkingSpot = parkingSpotOptional.get();
            Optional<User> optionalUser = userRepository.findById(bookingDetails.getUserId());
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                booking.setParkingSpot(parkingSpot);
                booking.setUser(user);
                List<Booking> bookingsByParkingSpot = bookingRepository.findByParkingSpot(parkingSpot);
                validateTimings(bookingsByParkingSpot, booking);
            } else {
                throw new SmartParkingException(SMP004.getErrorCode(), SMP004.getDescription());
            }
        } else {
            throw new SmartParkingException(SMP003.getErrorCode(), SMP003.getDescription());
        }
        return canBook;
    }

    private boolean validateTimings(List<Booking> bookingsByParkingSpot, Booking booking) {
        for (Booking bookingParking : bookingsByParkingSpot) {
            Dates alreadyBookedDate = bookingParking.getDates();
            Dates dates = booking.getDates();
            datesRepository.saveAndFlush(dates);
            validateService.isValidDateForBooking(alreadyBookedDate, dates);
        }
        return true;
    }
}
