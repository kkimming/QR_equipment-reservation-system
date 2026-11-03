package com.example.equipment.service;

import com.example.equipment.entity.Equipment;
import com.example.equipment.repository.EquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final EquipmentRepository equipmentRepository;

    @Transactional
    public void processQrRental(String qrCode) {
        // QR 코드 값(예: 기자재 ID 또는 고유 식별자)을 통해 기자재 조회
        // 여기서는 예시로 QR코드를 ID로 변환한다고 가정
        Long equipmentId = Long.valueOf(qrCode);

        Equipment equipment = equipmentRepository.findById(equipmentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 기자재를 찾을 수 없습니다."));

        // 이미 대여 중인지 확인
        if ("RENTED".equals(equipment.getStatus())) {
            throw new IllegalStateException("이미 대여 중인 기자재입니다.");
        }

        // 상태 변경
        equipment.setStatus("RENTED");
        equipmentRepository.save(equipment);
        
        // 추가로 rentals 테이블에 대여 이력 저장 로직 구현 가능
    }
}