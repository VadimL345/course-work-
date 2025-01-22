package com.hotel.controller;

import com.hotel.model.Room;
import com.hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public String getAllRooms(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "rooms";
    }

    @GetMapping("/add")
    public String showAddRoomForm(Model model) {
        model.addAttribute("room", new Room());
        return "add-edit-room";
    }

    @GetMapping("/edit/{id}")
    public String showEditRoomForm(@PathVariable Long id, Model model) {
        model.addAttribute("room", roomService.getRoomById(id).orElseThrow(() -> new RuntimeException("Room not found")));
        return "add-edit-room";
    }

    @PostMapping("/add")
    public String saveRoom(@ModelAttribute Room room) {
        if (room.getId() != null) {
            roomService.updateRoom(room.getId(), room);
        } else {
            roomService.addRoom(room);
        }
        return "redirect:/rooms";
    }

    @GetMapping("/delete/{id}")
    public String deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return "redirect:/rooms";
    }
}
