package com.hotel.controller;

import com.hotel.model.Booking;
import com.hotel.service.BookingService;
import com.hotel.service.ClientService;
import com.hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@Controller
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final ClientService clientService;
    private final RoomService roomService;

    @GetMapping
    public String getAllBookings(Model model) {
        model.addAttribute("bookings", bookingService.getAllBookings());
        return "bookings";
    }

    @GetMapping("/add")
    public String showAddBookingForm(Model model) {
        model.addAttribute("booking", new Booking());
        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("rooms", roomService.getAvailableRooms());
        return "add-booking";
    }

    @PostMapping("/add")
    public String addBooking(@RequestParam Long clientId,
                             @RequestParam Long roomId,
                             @RequestParam String checkInDate,
                             @RequestParam String checkOutDate) {
        bookingService.addBooking(clientId, roomId,
                LocalDate.parse(checkInDate), LocalDate.parse(checkOutDate));
        return "redirect:/bookings";
    }


    @GetMapping("/delete/{id}")
    public String deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return "redirect:/bookings";
    }
}
