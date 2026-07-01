package com.example.Event.Ticket.Booking.System.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventResponse {

    private Long id;

    private String title;

    private String description;

    private String venue;

    private LocalDate eventDate;

    private Integer totalSeats;

    private Integer availableSeats;

}
