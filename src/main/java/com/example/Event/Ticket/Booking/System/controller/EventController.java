package com.example.Event.Ticket.Booking.System.controller;

import com.example.Event.Ticket.Booking.System.dto.EventRequest;
import com.example.Event.Ticket.Booking.System.dto.EventResponse;
import com.example.Event.Ticket.Booking.System.service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    // Create Event
    @PostMapping
    public ResponseEntity<EventResponse> createEvent(@Valid @RequestBody EventRequest request) {

        EventResponse response = eventService.createEvent(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get All Events
    @GetMapping
    public ResponseEntity<List<EventResponse>> getAllEvents() {

        List<EventResponse> response = eventService.getAllEvents();

        return ResponseEntity.ok(response);
    }

    // Get Event By Id
    @GetMapping("/{id}")
    public ResponseEntity<EventResponse> getEventById(@PathVariable Long id) {

        EventResponse response = eventService.getEventById(id);

        return ResponseEntity.ok(response);
    }

    // Update Event
    @PutMapping("/{id}")
    public ResponseEntity<EventResponse> updateEvent(@PathVariable Long id,
                                                     @Valid @RequestBody EventRequest request) {

        EventResponse response = eventService.updateEvent(id, request);

        return ResponseEntity.ok(response);
    }

    // Delete Event
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {

        String response = eventService.deleteEvent(id);

        return ResponseEntity.ok(response);
    }
}