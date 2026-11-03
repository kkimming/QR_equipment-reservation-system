package com.example.equipment.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EquipmentRequestDto {
    
    @NotBlank(message = "기자재 이름은 필수입니다.")
    private String name;

    @NotBlank(message = "기자재 상태는 필수입니다.")
    private String status;
}