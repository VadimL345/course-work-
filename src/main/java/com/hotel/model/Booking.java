package com.hotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
public class Booking {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client; // Зв'язок із клієнтом

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room; // Зв'язок із номером

    @Column(nullable = false)
    private LocalDate checkInDate; // Дата заїзду

    @Column(nullable = false)
    private LocalDate checkOutDate; // Дата виїзду

}
