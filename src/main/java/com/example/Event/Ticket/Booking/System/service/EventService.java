package com.example.Event.Ticket.Booking.System.service;

import com.example.Event.Ticket.Booking.System.dto.EventRequest;
import com.example.Event.Ticket.Booking.System.dto.EventResponse;
import com.example.Event.Ticket.Booking.System.entity.Event;
import com.example.Event.Ticket.Booking.System.exception.ResourceNotFoundException;
import com.example.Event.Ticket.Booking.System.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;

    // Create Event
    public EventResponse createEvent(EventRequest request) {

        Event event = modelMapper.map(request, Event.class);

        // Initially available seats = total seats
        event.setAvailableSeats(request.getTotalSeats());

        Event savedEvent = eventRepository.save(event);

        return modelMapper.map(savedEvent, EventResponse.class);
    }

    // Get All Events
    public List<EventResponse> getAllEvents() {

        return eventRepository.findAll()
                .stream()
                .map(event -> modelMapper.map(event, EventResponse.class))
                .toList();
    }

    // Get Event By Id
    public EventResponse getEventById(Long id) {

        Event event = eventRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Event not found with id : " + id));

        return modelMapper.map(event, EventResponse.class);
    }

    // Update Event
    public EventResponse updateEvent(Long id, EventRequest request) {

        Event event = eventRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Event not found with id : " + id));

        modelMapper.map(request, event);


        event.setAvailableSeats(request.getTotalSeats());

        Event updatedEvent = eventRepository.save(event);

        return modelMapper.map(updatedEvent, EventResponse.class);
    }



    // Delete Event
    public String deleteEvent(Long id) {

        Event event = eventRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Event not found with id : " + id));

        eventRepository.delete(event);

        return "Event Deleted Successfully";
    }
}