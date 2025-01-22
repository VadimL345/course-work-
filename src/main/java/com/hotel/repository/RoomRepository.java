package com.hotel.repository;

import com.hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    // Знайти всі доступні номери
    List<Room> findByAvailable(boolean available);

    // Знайти всі номери певного типу
    List<Room> findByType(String type);

    // Знайти номери за ціною менше вказаної
    List<Room> findByPriceLessThan(double price);


}
