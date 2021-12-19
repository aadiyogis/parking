package com.publicis.sapient.parking.dto;

import lombok.Data;

/**
 * aditya created on 19/12/21
 */
@Data
public class ParkingDetails {

    private String area;
    private Double latitude;
    private Double longitude;
    private String pinCode;
}
