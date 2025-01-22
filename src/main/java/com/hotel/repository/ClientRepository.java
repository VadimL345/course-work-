package com.hotel.repository;

import com.hotel.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    // Знайти клієнта за email
    Optional<Client> findByEmail(String email);

    // Знайти клієнта за номером телефону
    Optional<Client> findByPhone(String phone);
}

