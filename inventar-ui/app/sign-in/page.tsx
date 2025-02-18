'use client';

import React, { useState } from 'react';
import { useRouter } from 'next/navigation';

export default function SignInPage() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const router = useRouter();

    const handleSignIn = (e: React.FormEvent) => {

        e.preventDefault();
        // Here you can add authentication logic

        console.log('Signed into:', email, password);
        router.push('/dashboard'); // Redirect after SignIn
    };

    return (
        <div className="flex items-center justify-center min-h-screen bg-stone-100 dark:bg-stone-900 text-white">
            <div className="w-full max-w-md p-6 bg-white rounded-lg shadow-md dark:bg-stone-800">
                <h2 className="text-2xl font-semibold text-center mb-6">Sign in</h2>
                <form onSubmit={handleSignIn} className="space-y-4">
                    <div>
                        <label className="block text-sm font-medium text-stone-700 dark:text-stone-200">Email</label>
                        <input
                            type="email"
                            className="w-full p-2 mt-1 border rounded-md focus:outline-none focus:ring focus:ring-emerald-300 dark:bg-stone-900 border-stone-800"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            required
                        />
                    </div>
                    <div>
                        <label className="block text-sm font-medium text-gray-700 dark:text-stone-200">Password</label>
                        <input
                            type="password"
                            className="w-full p-2 mt-1 border rounded-md focus:outline-none focus:ring focus:ring-emerald-300 dark:bg-stone-900 border-stone-800"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            required
                        />
                    </div>
                    <button
                        type="submit"
                        className="w-full p-2 text-white bg-emerald-600 rounded-md hover:bg-emerald-700"
                    >
                        Sign in
                    </button>
                </form>
                <p className="mt-4 text-center text-sm text-stone-600 dark:text-stone-300">
                    Don't have an account?{' '}
                    <a href="mailto:pimmellutscher123@gmail.com" className="text-emerald-600 hover:underline">Contact us!</a>
                </p>
            </div>
        </div>
    );
}
