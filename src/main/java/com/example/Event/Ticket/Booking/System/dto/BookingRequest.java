package com.example.Event.Ticket.Booking.System.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {

    @NotNull(message = "Event Id is required")
    private Long eventId;

    @NotNull(message = "User Id is required")
    private Long userId;

}