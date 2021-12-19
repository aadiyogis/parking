package com.publicis.sapient.parking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * aditya created on 19/12/21
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime start;
    private LocalDateTime end;

    @OneToOne
    private Booking booking;
}
