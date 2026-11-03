import React, { useState, useEffect } from 'react';
import MobileLayout from '../components/MobileLayout';
import { apiClient } from '../api/axios'; // 8주차 연동 시 사용

export default function EquipmentListPage() {
    const [equipments, setEquipments] = useState([
        { id: 1, name: '오실로스코프', status: 'AVAILABLE' },
        { id: 2, name: '디지털 멀티미터', status: 'RENTED' },
        { id: 3, name: '함수 발생기 (Function Generator)', status: 'AVAILABLE' }
    ]);

    return (
        <MobileLayout>
            <div className="space-y-4">
                <h3 className="text-xl font-bold text-gray-800">보유 기자재 목록</h3>
                <p className="text-sm text-gray-500">대여할 기자재를 선택하거나 QR을 스캔하세요.</p>
                
                <div className="space-y-2">
                    {equipments.map((item) => (
                        <div key={item.id} className="p-3 bg-white border rounded-lg shadow-sm flex justify-between items-center">
                            <div>
                                <h4 className="font-semibold text-gray-700">{item.name}</h4>
                                <span className={`text-xs px-2 py-1 rounded-full font-medium ${
                                    item.status === 'AVAILABLE' ? 'bg-green-100 text-green-700' : 'bg-red-100 text-red-700'
                                }`}>
                                    {item.status === 'AVAILABLE' ? '대여 가능' : '대여 중'}
                                </span>
                            </div>
                            <button 
                                disabled={item.status === 'RENTED'}
                                className={`px-3 py-1.5 rounded-lg text-sm font-medium ${
                                    item.status === 'AVAILABLE' ? 'bg-blue-600 text-white hover:bg-blue-700' : 'bg-gray-200 text-gray-400 cursor-not-allowed'
                                }`}
                            >
                                대여하기
                            </button>
                        </div>
                    ))}
                </div>
            </div>
        </MobileLayout>
    );
}