'use client';

import React, { useState } from 'react';
import { useRouter } from 'next/navigation';
import LabeledInputField from "@/components/labeled-input-field";
import Link from "next/link";

export default function LoginPage() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const router = useRouter();

    const handleLogin = (e: React.FormEvent) => {

        e.preventDefault();
        // Here you can add authentication logic

        console.log('Logged into:', email, password);
        router.push('/dashboard'); // Redirect after Login
    };

    return (
        <div className="flex items-center justify-center min-h-screen bg-stone-100 dark:bg-stone-900 text-white">
            <div className="w-full max-w-md p-6 bg-white rounded-lg shadow-md dark:bg-stone-800">
                <h2 className="text-2xl font-semibold text-center mb-6">Log in</h2>
                <form onSubmit={handleLogin} className="space-y-4">
                    <LabeledInputField label="Email" type="email"
                                       value={email}
                                       onInputChanged={e => setEmail(e.target.value)} />
                    <LabeledInputField label="Password" type="password"
                                       value={password}
                                       onInputChanged={e => setPassword(e.target.value)} />
                    <button
                        type="submit"
                        className="w-full p-2 text-white bg-emerald-600 rounded-md hover:bg-emerald-700"
                    >
                        Log in
                    </button>
                </form>
                <p className="mt-4 text-center text-sm text-stone-600 dark:text-stone-300">
                    Don't have an account?{' '}
                    <Link href="/sign-up" className="text-emerald-600 hover:underline">Sign up.</Link>
                </p>
            </div>
        </div>
    );
}
