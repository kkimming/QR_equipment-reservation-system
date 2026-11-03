import React from 'react';

export default function MobileLayout({ children }) {
    return (
        <div className="flex justify-center bg-gray-100 min-h-screen">
            <div className="w-full max-w-md bg-white shadow-lg flex flex-col justify-between min-h-screen">
                <header className="p-4 bg-blue-600 text-white font-bold text-lg text-center">
                    학과 기자재 대여 시스템
                </header>
                <main className="p-4 flex-1 overflow-y-auto">
                    {children}
                </main>
                <footer className="p-3 bg-gray-50 text-center text-xs text-gray-500 border-t">
                    © 2026 IT Convergence Telecom Eng.
                </footer>
            </div>
        </div>
    );
}