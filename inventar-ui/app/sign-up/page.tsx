'use client';

import React, { useState } from 'react';
import { useRouter } from 'next/navigation';
import LabeledInputField from "@/components/labeled-input-field";
import Link from "next/link";

export default function SignUpPage() {
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [repeatedPassword, setRepeatedPassword] = useState('');
    const router = useRouter();

    const handleSignUp = (e: React.FormEvent) => {

        e.preventDefault();
        // Here you can add authentication logic

        console.log('Signed up:', email, password);
        router.push('/login'); // Redirect after SignUp
    };

    return (
        <div className="flex items-center justify-center min-h-screen bg-stone-100 dark:bg-stone-900 text-white">
            <div className="w-full max-w-md p-6 bg-white rounded-lg shadow-md dark:bg-stone-800">
                <h2 className="text-2xl font-semibold text-center mb-6">Sign up</h2>
                <form onSubmit={handleSignUp} className="space-y-4">
                    <LabeledInputField label="Name" type="text"
                                       value={name}
                                       onInputChanged={e => setName(e.target.value)} />
                    <LabeledInputField label="Email" type="email"
                                       value={email}
                                       onInputChanged={e => setEmail(e.target.value)} />
                    <LabeledInputField label="Password" type="password"
                                       value={password}
                                       onInputChanged={e => setPassword(e.target.value)} />
                    <LabeledInputField label="Password (repeat)" type="password"
                                       value={repeatedPassword}
                                       onInputChanged={e => setRepeatedPassword(e.target.value)} />
                    <button
                        type="submit"
                        className="w-full p-2 text-white bg-emerald-600 rounded-md hover:bg-emerald-700"
                    >
                        Sign up
                    </button>
                </form>
                <p className="mt-4 text-center text-sm text-stone-600 dark:text-stone-300">
                    Already have an account?{' '}
                    <Link href="/login" className="text-emerald-600 hover:underline">Login.</Link>
                </p>
            </div>
        </div>
    );
}
