'use client'

import React from "react";

interface LabeledInputFieldProps {
    label: string;
    type: string;
    value: any;
    onInputChanged: React.ChangeEventHandler<HTMLInputElement>;

}

const LabeledInputField: React.FC<LabeledInputFieldProps> =({ label, type, value, onInputChanged }) => {

    return (
        <div>
            <label className="block text-sm font-medium text-stone-700 dark:text-stone-200">{label}</label>
            <input
                type={type}
                className="w-full p-2 mt-1 border rounded-md focus:outline-none focus:ring focus:ring-emerald-300
                dark:bg-stone-900 border-stone-800"
                value={value}
                onChange={onInputChanged}
                required
            />
        </div>
    )
}

export default LabeledInputField;