package com.example.Event.Ticket.Booking.System.repository;
import com.example.Event.Ticket.Booking.System.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}