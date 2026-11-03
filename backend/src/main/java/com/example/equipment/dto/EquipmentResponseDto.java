package com.example.equipment.dto;

import com.example.equipment.entity.Equipment;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter @Setter
public class EquipmentResponseDto {

    private Long id;
    private String name;
    private String status;
    private OffsetDateTime createdAt;

    // Entity를 Dto로 변환하는 생성자 또는 메서드
    public EquipmentResponseDto(Equipment equipment) {
        this.id = equipment.getId();
        this.name = equipment.getName();
        this.status = equipment.getStatus();
        this.createdAt = equipment.getCreatedAt();
    }
}