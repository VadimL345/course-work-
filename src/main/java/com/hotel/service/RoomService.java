package com.hotel.service;

import com.hotel.model.Room;
import com.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(Long id, Room updatedRoom) {
        return roomRepository.findById(id)
                .map(room -> {
                    room.setType(updatedRoom.getType());
                    room.setCapacity(updatedRoom.getCapacity());
                    room.setPrice(updatedRoom.getPrice());
                    room.setAvailable(updatedRoom.isAvailable());
                    return roomRepository.save(room);
                })
                .orElseThrow(() -> new RuntimeException("Room not found with ID: " + id));
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    // Отримати всі доступні номери
    public List<Room> getAvailableRooms() {
        return roomRepository.findByAvailable(true); // Використовує метод репозиторію
    }

    // Отримати всі заброньовані номери
    public List<Room> getBookedRooms() {
        return roomRepository.findByAvailable(false); // Використовує метод репозиторію
    }
}
