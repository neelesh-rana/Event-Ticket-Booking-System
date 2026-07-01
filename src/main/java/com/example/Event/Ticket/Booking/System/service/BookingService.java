package com.example.Event.Ticket.Booking.System.service;

import com.example.Event.Ticket.Booking.System.dto.BookingRequest;
import com.example.Event.Ticket.Booking.System.dto.BookingResponse;
import com.example.Event.Ticket.Booking.System.entity.Booking;
import com.example.Event.Ticket.Booking.System.entity.Event;
import com.example.Event.Ticket.Booking.System.entity.User;
import com.example.Event.Ticket.Booking.System.enums.BookingStatus;
import com.example.Event.Ticket.Booking.System.exception.EventSoldOutException;
import com.example.Event.Ticket.Booking.System.exception.ResourceNotFoundException;
import com.example.Event.Ticket.Booking.System.repository.BookingRepository;
import com.example.Event.Ticket.Booking.System.repository.EventRepository;
import com.example.Event.Ticket.Booking.System.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    // Book Event
    public BookingResponse bookEvent(BookingRequest request) {

        Event event = eventRepository.findById(request.getEventId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Event not found with id : " + request.getEventId()));

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id : " + request.getUserId()));

        if (event.getAvailableSeats() <= 0) {
            throw new EventSoldOutException("Event is Sold Out");
        }

        Booking booking = new Booking();

        booking.setBookingDate(LocalDateTime.now());
        booking.setStatus(BookingStatus.BOOKED);
        booking.setEvent(event);
        booking.setUser(user);

        event.setAvailableSeats(event.getAvailableSeats() - 1);

        eventRepository.save(event);

        Booking savedBooking = bookingRepository.save(booking);

        return modelMapper.map(savedBooking, BookingResponse.class);
    }

    // Get All Bookings
    public List<BookingResponse> getAllBookings() {

        return bookingRepository.findAll()
                .stream()
                .map(booking -> modelMapper.map(booking, BookingResponse.class))
                .toList();

    }

    // Get Booking By Id
    public BookingResponse getBookingById(Long id) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Booking not found with id : " + id));

        return modelMapper.map(booking, BookingResponse.class);

    }

    // Cancel Booking
    public String cancelBooking(Long id) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Booking not found with id : " + id));

        Event event = booking.getEvent();

        event.setAvailableSeats(event.getAvailableSeats() + 1);

        eventRepository.save(event);

        bookingRepository.delete(booking);

        return "Booking Cancelled Successfully";

    }

}