package com.example.equipment.service;

import com.example.equipment.dto.EquipmentRequestDto;
import com.example.equipment.entity.Equipment;
import com.example.equipment.repository.EquipmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class EquipmentServiceTest {

    @Mock
    private EquipmentRepository equipmentRepository;

    @InjectMocks
    private EquipmentService equipmentService;

    @Test
    void 기자재_등록_성공() {
        // given
        EquipmentRequestDto dto = new EquipmentRequestDto();
        dto.setName("오실로스코프");
        dto.setStatus("AVAILABLE");

        Equipment equipment = new Equipment();
        equipment.setId(1L);
        equipment.setName("오실로스코프");
        equipment.setStatus("AVAILABLE");

        given(equipmentRepository.save(any(Equipment.class))).willReturn(equipment);

        // when
        Long savedId = equipmentService.registerEquipment(dto);

        // then
        assertNotNull(savedId);
    }
}