package com.publicis.sapient.parking.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * aditya created on 19/12/21
 */
@Getter
@AllArgsConstructor
public enum ErrorConstant {
    SMP001("SMP001", "Booking time is before current time"),
    SMP002("SMP002", "Mandatory parameter is missing"),
    SMP003("SMP003", "Parking spot is invalid"),
    SMP004("SMP004", "User is invalid"),
    SMP005("SMP005", "");

    private String errorCode;
    private String description;
}
