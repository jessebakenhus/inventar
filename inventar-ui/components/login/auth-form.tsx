"use client"

import type React from "react"

import { useState } from "react"
// import { Button } from "@/components/ui/button"
// import { Input } from "@/components/ui/input"
import { Loader2, LockIcon } from "lucide-react"
import Link from "next/link"

export function AuthForm() {
  const [isLoading, setIsLoading] = useState(false)

  async function handleSubmit(e: React.FormEvent) {
    e.preventDefault()
    setIsLoading(true)

    const formData = new FormData(e.target as HTMLFormElement)
    const email = formData.get("email") as string
    const password = formData.get("password") as string

    try {
      /**
       * To update with your actual authentication logic
       */
      await new Promise((resolve) => setTimeout(resolve, 2000))
      console.log("Signing in with:", email, password)
    } catch (error) {
      console.error("Authentication error:", error)
    } finally {
      setIsLoading(false)
    }
  }

  return (
    <form onSubmit={handleSubmit} className="space-y-4" noValidate>
      <div className="space-y-2">
        <label htmlFor="email" className="text-sm font-medium text-white">
          Email
        </label>
        <div className="relative">
          <span className="absolute left-3 top-1/2 -translate-y-1/2 text-gray-500 flex items-center justify-center w-4 h-4">
            @
          </span>
          <input
            type="email"
            name="email"
            placeholder="name@example.com"
            required
            disabled={isLoading}
            className="border border-stone-800 w-full rounded-md pl-10 h-12 bg-background ring-offset-background placeholder:text-muted-foreground focus-visible:ring-1 focus-visible:ring-ring"
            autoComplete="email"
          />
        </div>
      </div>

      <div className="space-y-2">
        <div className="flex justify-between">
            <label className="text-sm font-medium text-white">Password</label>
            <Link href="/reset-password" className="text-sm font-medium text-red-500">Forgot password?</Link>
        </div>
        <div className="relative">
          <LockIcon className="absolute left-3 top-1/2 -translate-y-1/2 h-4 w-4 text-gray-500" />
          <input
            type="password"
            name="password"
            placeholder="Enter your password"
            required
            disabled={isLoading}
            className="border border-stone-800 w-full rounded-md pl-10 h-12 bg-background ring-offset-background placeholder:text-muted-foreground focus-visible:ring-1 focus-visible:ring-ring"
          />
        </div>
      </div>

      <button
        type="submit"
        disabled={isLoading}
        className="rounded-md flex justify-center items-center gap-2 w-full h-12 text-base font-medium bg-red-600 text-black hover:bg-red-700 transition-colors"
      >
        {isLoading && <Loader2 className="mr-2 h-4 w-4 animate-spin" />}
        {isLoading ? "Signing in..." : "Sign in"}
      </button>
    </form>
  )
}

