package com.publicis.sapient.parking.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * aditya created on 19/12/21
 */
@Data
public class BookingDetails {

    private Long locationId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long userId;

}
