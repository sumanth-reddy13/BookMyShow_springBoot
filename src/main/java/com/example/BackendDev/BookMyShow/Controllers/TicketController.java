package com.example.BackendDev.BookMyShow.Controllers;

import com.example.BackendDev.BookMyShow.EntryDTOs.GetNoOfTicketBookedEntryDto;
import com.example.BackendDev.BookMyShow.EntryDTOs.TicketEntryDto;
import com.example.BackendDev.BookMyShow.Repository.TicketRepository;
import com.example.BackendDev.BookMyShow.Services.TicketService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/bookTicket")
    public ResponseEntity bookTicket(@RequestBody TicketEntryDto ticketEntryDto) {
        try {
            String response = ticketService.bookTicket(ticketEntryDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch(Exception e) {
            String response = e.getLocalizedMessage();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("getTicketsBooked")
    public ResponseEntity getTicketsBooked(@RequestBody GetNoOfTicketBookedEntryDto getNoOfTicketBookedEntryDto) {
        try {
            return new ResponseEntity<>(ticketService.ticketsBookedForMovie(getNoOfTicketBookedEntryDto), HttpStatus.FOUND);
        }
        catch(Exception e) {
            String response = e.getLocalizedMessage();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
