'use client';

import React, { useState } from 'react';
import Link from 'next/link';
import { User, Settings, LogOut, UserCircle } from 'lucide-react';

const Navbar: React.FC = () => {
    const [userMenuOpen, setUserMenuOpen] = useState(false);

    return (
        <nav className="bg-white dark:bg-stone-900 border-b border-stone-300 dark:border-stone-700 shadow-sm">
            <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
                <div className="flex justify-between h-16 items-center">
                    {/* Logo */}
                    <div className="text-xl font-semibold text-stone-900 dark:text-stone-200">
                        <Link href="/">Inventar</Link>
                    </div>

                    {/* User Icon with Clickable Dropdown */}
                    <div className="relative">
                        <button
                            onClick={() => setUserMenuOpen(!userMenuOpen)}
                            className={`text-stone-700 dark:text-stone-300 focus:outline-none transition-colors ${userMenuOpen ? 'text-emerald-500' : ''}`}
                        >
                            <User size={24} />
                        </button>
                        {userMenuOpen && (
                            <div className="absolute right-0 mt-2 w-48 bg-white dark:bg-stone-800 border border-stone-300 dark:border-stone-700 shadow-lg rounded-md py-2">
                                <Link href="/profile" className="flex items-center px-4 py-2 text-stone-700 dark:text-stone-300 hover:bg-stone-100 dark:hover:bg-stone-700">
                                    <UserCircle size={18} className="mr-2" /> Profile
                                </Link>
                                <Link href="/settings" className="flex items-center px-4 py-2 text-stone-700 dark:text-stone-300 hover:bg-stone-100 dark:hover:bg-stone-700">
                                    <Settings size={18} className="mr-2" /> Settings
                                </Link>
                                <Link href="/logout" className="flex items-center px-4 py-2 text-stone-700 dark:text-stone-300 hover:bg-stone-100 dark:hover:bg-stone-700">
                                    <LogOut size={18} className="mr-2" /> Logout
                                </Link>
                            </div>
                        )}
                    </div>
                </div>
            </div>
        </nav>
    );
};

export default Navbar;
