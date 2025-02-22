// import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card"
import Image from "next/image"
import { AuthForm } from "./auth-form"
import { SocialLogin } from "./social-login"
import Link from "next/link"

export default function AuthBasic() {
  return (
    <div className="flex min-h-screen items-center justify-center p-4 bg-stone-950">
      <div className="w-full max-w-[450px]">
        <div className="w-full border-0 shadow-lg space-y-6">
          <div className="space-y-2">
            <div className="text-2xl font-semibold tracking-tight text-white">
              Welcome back
            </div>
            <div className="text-neutral-400">
              Enter your credentials to access your account
            </div>
          </div>
          <div className="space-y-6">
            <AuthForm />
            <SocialLogin />
          </div>
          <div className="flex justify-center gap-1">
            <p className="text-sm font-medium text-neutral-400">Don't have an account?{"   "}</p>
            <Link className="text-sm font-medium text-red-600" href="/sign-up">Sign up here</Link>
          </div>
        </div>
      </div>
    </div>
  )
}

