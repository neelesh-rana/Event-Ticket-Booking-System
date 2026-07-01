package com.example.Event.Ticket.Booking.System.controller;

import com.example.Event.Ticket.Booking.System.dto.BookingRequest;
import com.example.Event.Ticket.Booking.System.dto.BookingResponse;
import com.example.Event.Ticket.Booking.System.service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingResponse> bookEvent(@Valid @RequestBody BookingRequest request) {

        BookingResponse response = bookingService.bookEvent(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<BookingResponse>> getAllBookings() {

        List<BookingResponse> response = bookingService.getAllBookings();

        return ResponseEntity.ok(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingResponse> getBookingById(@PathVariable Long id) {

        BookingResponse response = bookingService.getBookingById(id);

        return ResponseEntity.ok(response);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelBooking(@PathVariable Long id) {

        String response = bookingService.cancelBooking(id);

        return ResponseEntity.ok(response);

    }

}