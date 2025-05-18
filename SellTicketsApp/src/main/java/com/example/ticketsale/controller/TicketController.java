package com.example.ticketsale.controller;

import com.example.ticketsale.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Controller
@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    // Получение списка доступных фильмов и билетов

    @GetMapping("/")
    public String viewTickets(Model model) {
        model.addAttribute("films", ticketService.getAllFilms());
        model.addAttribute("availableTickets", ticketService.getAvailableTickets());
        return "tickets";
    }
    // Покупка билета через окно-уведомление
    @PostMapping("/purchase")
    public String purchaseTicket(@RequestParam Long filmId, RedirectAttributes redirectAttributes) {
        boolean success = ticketService.purchaseTicket(filmId);
        if (success) {
            redirectAttributes.addFlashAttribute("purchaseAttempted", true);
            redirectAttributes.addFlashAttribute("success", true);
        } else {
            redirectAttributes.addFlashAttribute("purchaseAttempted", true);
            redirectAttributes.addFlashAttribute("error", true);
        }
        return "redirect:/tickets/";
    }
    // Возврат билета
    @PostMapping("/return/{ticketId}")
    public ResponseEntity<String> returnTicket(@PathVariable Long ticketId) {
        boolean success = ticketService.returnTicket(ticketId);
        if (success) {
            return ResponseEntity.ok("Билет успешно возвращен!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Не удалось вернуть билет.");
        }
    }
}