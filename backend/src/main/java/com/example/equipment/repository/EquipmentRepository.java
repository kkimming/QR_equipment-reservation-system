package com.example.equipment.repository;

import com.example.equipment.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    // 기본적인 CRUD 쿼리가 자동으로 제공됩니다.
}