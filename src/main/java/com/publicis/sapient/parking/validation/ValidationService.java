package com.publicis.sapient.parking.validation;

import com.publicis.sapient.parking.constant.ErrorConstant;
import com.publicis.sapient.parking.dto.BookingDetails;
import com.publicis.sapient.parking.exception.SmartParkingException;
import com.publicis.sapient.parking.model.Dates;
import com.publicis.sapient.parking.repository.BookingRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static com.publicis.sapient.parking.constant.ErrorConstant.SMP001;
import static com.publicis.sapient.parking.constant.ErrorConstant.SMP002;

/**
 * aditya created on 19/12/21
 */
@Component
public class ValidationService {

    public boolean validateInput(BookingDetails bookingDetails) {
        boolean isValid = true;
        Long userId = bookingDetails.getUserId();
        Long locationId = bookingDetails.getLocationId();
        LocalDateTime startTime = bookingDetails.getStartTime();
        LocalDateTime endTime = bookingDetails.getEndTime();
        notNullCheck(userId);
        notNullCheck(locationId);
        notNullCheck(startTime);
        notNullCheck(endTime);
        validateBeforeTime(startTime);
        validateBeforeTime(endTime);

        return isValid;
    }

    private boolean notNullCheck(Object object) {
        if (object == null) {
            throw new SmartParkingException(SMP002.getErrorCode(), SMP002.getDescription());
        }
        return true;
    }

    private boolean validateBeforeTime(LocalDateTime time) {
        if (time == null || time.isBefore(LocalDateTime.now())) {
            throw new SmartParkingException(SMP001.getErrorCode(), SMP001.getDescription());
        }
        return true;
    }

    public boolean isValidDateForBooking(Dates alreadyBookedDate, Dates dates) {
        return true;
    }
}
