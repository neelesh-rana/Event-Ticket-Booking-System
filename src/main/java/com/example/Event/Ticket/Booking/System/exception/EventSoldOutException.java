package com.example.Event.Ticket.Booking.System.exception;

public class EventSoldOutException extends RuntimeException {

    public EventSoldOutException(String message) {
        super(message);
    }

}