package com.example.equipment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlreadyRentedException.class)
    public ResponseEntity<String> handleAlreadyRented(AlreadyRentedException e) {
        // 10주차 문제 해결: 500 에러 대신 명확한 409 Conflict 반환
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
}