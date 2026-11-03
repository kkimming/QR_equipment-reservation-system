-- 3주차 PostgreSQL DDL 스크립트
-- 작성일: 2026-0X-XX

-- 1. 기자재 테이블
CREATE TABLE equipments (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- 2. 사용자 테이블
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- 3. 대여 이력 테이블 (Type Mismatch 해결 반영: BIGSERIAL/BIGINT 타입 일치)
CREATE TABLE rentals (
    id BIGSERIAL PRIMARY KEY,
    equipment_id BIGINT REFERENCES equipments(id),
    user_id BIGINT REFERENCES users(id),
    rented_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    returned_at TIMESTAMP WITH TIME ZONE
);