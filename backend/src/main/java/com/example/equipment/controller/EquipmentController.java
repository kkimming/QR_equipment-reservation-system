package com.example.equipment.controller;

import com.example.equipment.dto.EquipmentRequestDto;
import com.example.equipment.entity.Equipment;
import com.example.equipment.service.EquipmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/equipments")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    // 기자재 등록 API
    @PostMapping
    public ResponseEntity<Long> createEquipment(@RequestBody @Valid EquipmentRequestDto requestDto) {
        Long equipmentId = equipmentService.registerEquipment(requestDto);
        return ResponseEntity.ok(equipmentId);
    }

    // 전체 기자재 조회 API
    @GetMapping
    public ResponseEntity<List<Equipment>> getEquipments() {
        List<Equipment> equipments = equipmentService.getAllEquipments();
        return ResponseEntity.ok(equipments);
    }
}