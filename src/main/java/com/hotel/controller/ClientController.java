package com.hotel.controller;

import com.hotel.model.Client;
import com.hotel.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public String getAllClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "clients";
    }

    @GetMapping("/add")
    public String showAddClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "add-edit-client";
    }

    @GetMapping("/edit/{id}")
    public String showEditClientForm(@PathVariable Long id, Model model) {
        model.addAttribute("client", clientService.getClientById(id).orElseThrow(() -> new RuntimeException("Client not found")));
        return "add-edit-client";
    }

    @PostMapping("/add")
    public String saveClient(@ModelAttribute Client client) {
        if (client.getId() != null) {
            clientService.updateClient(client.getId(), client);
        } else {
            clientService.addClient(client);
        }
        return "redirect:/clients";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return "redirect:/clients";
    }
}
