package com.publicis.sapient.parking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * aditya created on 19/12/21
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ParkingSpot parkingSpot;

    @OneToOne
    private Dates dates;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
