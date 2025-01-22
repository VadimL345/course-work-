package com.hotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Room {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type; // Наприклад: Standard, Deluxe, Suite

    @Column(nullable = false)
    private int capacity; // Кількість людей

    @Column(nullable = false)
    private double price; // Ціна за ніч

    @Column(nullable = false)
    private boolean available; // Чи доступний номер

}

