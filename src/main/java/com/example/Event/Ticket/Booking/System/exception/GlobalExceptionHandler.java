package com.example.Event.Ticket.Booking.System.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex){

        Map<String,Object> response = new HashMap<>();

        response.put("timestamp", LocalDateTime.now());
        response.put("status",404);
        response.put("error","Not Found");
        response.put("message",ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(EventSoldOutException.class)
    public ResponseEntity<Object> handleSoldOut(EventSoldOutException ex){

        Map<String,Object> response = new HashMap<>();

        response.put("timestamp", LocalDateTime.now());
        response.put("status",400);
        response.put("error","Bad Request");
        response.put("message",ex.getMessage());

        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(DuplicateBookingException.class)
    public ResponseEntity<Object> handleDuplicateBooking(DuplicateBookingException ex){

        Map<String,Object> response = new HashMap<>();

        response.put("timestamp",LocalDateTime.now());
        response.put("status",400);
        response.put("error","Bad Request");
        response.put("message",ex.getMessage());

        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidation(MethodArgumentNotValidException ex){

        Map<String,String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(),error.getDefaultMessage()));

        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex){

        Map<String,Object> response = new HashMap<>();

        response.put("timestamp",LocalDateTime.now());
        response.put("status",500);
        response.put("error","Internal Server Error");
        response.put("message",ex.getMessage());

        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);

    }

}