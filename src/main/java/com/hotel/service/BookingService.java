package com.hotel.service;

import com.hotel.model.Booking;
import com.hotel.model.Client;
import com.hotel.model.Room;
import com.hotel.repository.BookingRepository;
import com.hotel.repository.ClientRepository;
import com.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ClientService clientService;
    private final RoomService roomService;

    public BookingService(BookingRepository bookingRepository, ClientService clientService, RoomService roomService) {
        this.bookingRepository = bookingRepository;
        this.clientService = clientService;
        this.roomService = roomService;
    }

    public Booking addBooking(Long clientId, Long roomId, LocalDate checkInDate, LocalDate checkOutDate) {
        Client client = clientService.getClientById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + clientId));
        Room room = roomService.getRoomById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found with ID: " + roomId));

        if (!room.isAvailable()) {
            throw new RuntimeException("Room is not available for booking.");
        }

        Booking booking = new Booking();
        booking.setClient(client);
        booking.setRoom(room);
        booking.setCheckInDate(checkInDate);
        booking.setCheckOutDate(checkOutDate);

        // Позначаємо номер як недоступний після бронювання
        room.setAvailable(false);
        roomService.updateRoom(room.getId(), room);

        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
