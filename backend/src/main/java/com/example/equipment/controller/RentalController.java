package com.example.equipment.controller;

import com.example.equipment.service.RentalService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rentals")
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;

    // QR 스캔을 통한 실시간 대여 처리 API
    @PostMapping("/scan")
    public ResponseEntity<String> scanAndRent(@RequestBody RentalRequestDto requestDto) {
        rentalService.processQrRental(requestDto.getQrCode());
        return ResponseEntity.ok("기자재 대여가 완료되었습니다.");
    }

    // 요청 DTO 내부 클래스 또는 별도 파일로 분리 가능
    @Getter @Setter
    public static class RentalRequestDto {
        private String qrCode;
    }
}