package com.hotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Client {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // Ім'я клієнта

    @Column(nullable = false, unique = true)
    private String email; // Email клієнта

    @Column(nullable = false, unique = true)
    private String phone; // Номер телефону

}
