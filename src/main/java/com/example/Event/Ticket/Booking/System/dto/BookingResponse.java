package com.example.Event.Ticket.Booking.System.dto;

import com.example.Event.Ticket.Booking.System.enums.BookingStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingResponse {

    private Long id;

    private LocalDateTime bookingDate;

    private BookingStatus status;

}