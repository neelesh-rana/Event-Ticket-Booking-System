package com.example.Event.Ticket.Booking.System.repository;

import com.example.Event.Ticket.Booking.System.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByUserId(Long userId);

}