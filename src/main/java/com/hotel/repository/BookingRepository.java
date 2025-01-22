package com.hotel.repository;

import com.hotel.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    // Знайти бронювання за клієнтом
    List<Booking> findByClientId(Long clientId);

    // Знайти бронювання за номером
    List<Booking> findByRoomId(Long roomId);

    // Знайти бронювання, що починаються у вказану дату
    List<Booking> findByCheckInDate(LocalDate checkInDate);

    // Знайти бронювання у визначеному діапазоні дат
    List<Booking> findByCheckInDateBetween(LocalDate startDate, LocalDate endDate);
}
