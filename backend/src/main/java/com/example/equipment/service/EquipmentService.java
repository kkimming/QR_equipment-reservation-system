package com.example.equipment.service;

import com.example.equipment.dto.EquipmentRequestDto;
import com.example.equipment.entity.Equipment;
import com.example.equipment.repository.EquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    // 기자재 등록
    @Transactional
    public Long registerEquipment(EquipmentRequestDto requestDto) {
        Equipment equipment = new Equipment();
        equipment.setName(requestDto.getName());
        equipment.setStatus(requestDto.getStatus());
        
        Equipment savedEquipment = equipmentRepository.save(equipment);
        return savedEquipment.getId();
    }

    // 전체 기자재 조회
    public List<Equipment> getAllEquipments() {
        return equipmentRepository.findAll();
    }
}