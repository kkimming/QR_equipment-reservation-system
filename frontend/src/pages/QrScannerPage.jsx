import React, { useEffect, useState, useRef } from 'react';
import { Html5QrcodeScanner } from 'html5-qrcode';
import { apiClient } from '../api/axios';

export default function QrScannerPage() {
    const [scanResult, setScanResult] = useState(null);
    const scannerRef = useRef(null);

    useEffect(() => {
        const scanner = new Html5QrcodeScanner("reader", {
            fps: 10,
            qrbox: { width: 250, height: 250 }
        }, false);

        scanner.render(async (decodedText) => {
            scanner.clear(); // 9주차 문제 해결: 중복 대여 방지 위해 스캔 즉시 일시정지/초기화
            setScanResult(decodedText);

            try {
                await apiClient.post('/api/v1/rentals/scan', { qrCode: decodedText });
                alert("기자재 대여가 정상 처리되었습니다.");
            } catch (e) {
                alert("대여 처리 실패: " + e.response?.data?.message);
            }
        }, (error) => {
            // 스캔 에러 무시 (탐색 중 발생)
        });

        return () => { scanner.clear().catch(error => console.error(error)); };
    }, []);

    return (
        <div className="flex flex-col items-center p-4">
            <h2 className="text-lg font-bold mb-4">QR 코드를 스캔하세요</h2>
            <div id="reader" className="w-full max-w-xs"></div>
            {scanResult && <p className="mt-4 text-green-600">스캔된 코드: {scanResult}</p>}
        </div>
    );
}