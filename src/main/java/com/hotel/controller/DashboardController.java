package com.hotel.controller;

import com.hotel.service.BookingService;
import com.hotel.service.ClientService;
import com.hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class DashboardController {

    private final RoomService roomService;
    private final ClientService clientService;
    private final BookingService bookingService;

    @GetMapping("/")
    public String getDashboard(Model model) {
        model.addAttribute("totalRooms", roomService.getAllRooms().size());
        model.addAttribute("availableRooms", roomService.getAvailableRooms().size());
        model.addAttribute("bookedRooms", roomService.getBookedRooms().size());
        model.addAttribute("totalClients", clientService.getAllClients().size());
        return "dashboard";
    }
}
