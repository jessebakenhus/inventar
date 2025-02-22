"use client"

import { useState } from "react"
// import { Button } from "@/components/ui/button"
// import { Separator } from "@/components/ui/separator"
import { Loader2 } from "lucide-react"
import { FaGithub, FaGoogle } from "react-icons/fa"

export function SocialLogin() {
  const [isGoogleLoading, setIsGoogleLoading] = useState(false)

  async function handleGoogleSignIn() {
    setIsGoogleLoading(true)
    try {
      /**
       * To update with your actual authentication logic
       */
      await new Promise((resolve) => setTimeout(resolve, 1500))
      console.log("Signing in with Google")
    } catch (error) {
      console.error("Google sign-in error:", error)
    } finally {
      setIsGoogleLoading(false)
    }
  }

  function GoogleIcon() {
    return (
      <svg
        className="mr-2 h-4 w-4"
        aria-hidden="true"
        focusable="false"
        data-prefix="fab"
        data-icon="google"
        role="img"
        xmlns="http://www.w3.org/2000/svg"
        viewBox="0 0 488 512"
      >
        <path
          fill="currentColor"
          d="M488 261.8C488 403.3 391.1 504 248 504 110.8 504 0 393.2 0 256S110.8 8 248 8c66.8 0 123 24.5 166.3 64.9l-67.5 64.9C258.5 52.6 94.3 116.6 94.3 256c0 86.5 69.1 156.6 153.7 156.6 98.2 0 135-70.4 140.8-106.9H248v-85.3h236.1c2.3 12.7 3.9 24.9 3.9 41.4z"
        ></path>
      </svg>
    )
  }

  function GitHubIcon() {
    return (
      <svg 
        className="mr-4"
        aria-hidden="true"
        focusable="false"
        data-prefix="fab"
        data-icon="github"
        role="img"
        xmlns="http://www.w3.org/2000/svg"
        width="16" height="16"
      >
        <path
          fill="#fff"
          d="M48.854 0C21.839 0 0 22 0 49.217c0 21.756 13.993 40.172 33.405 46.69 2.427.49 3.316-1.059 3.316-2.362 0-1.141-.08-5.052-.08-9.127-13.59 2.934-16.42-5.867-16.42-5.867-2.184-5.704-5.42-7.17-5.42-7.17-4.448-3.015.324-3.015.324-3.015 4.934.326 7.523 5.052 7.523 5.052 4.367 7.496 11.404 5.378 14.235 4.074.404-3.178 1.699-5.378 3.074-6.6-10.839-1.141-22.243-5.378-22.243-24.283 0-5.378 1.94-9.778 5.014-13.2-.485-1.222-2.184-6.275.486-13.038 0 0 4.125-1.304 13.426 5.052a46.97 46.97 0 0 1 12.214-1.63c4.125 0 8.33.571 12.213 1.63 9.302-6.356 13.427-5.052 13.427-5.052 2.67 6.763.97 11.816.485 13.038 3.155 3.422 5.015 7.822 5.015 13.2 0 18.905-11.404 23.06-22.324 24.283 1.78 1.548 3.316 4.481 3.316 9.126 0 6.6-.08 11.897-.08 13.526 0 1.304.89 2.853 3.316 2.364 19.412-6.52 33.405-24.935 33.405-46.691C97.707 22 75.788 0 48.854 0z" /></svg>
    )
  }

  return (
    <>
      <div className="relative">
        <div className="absolute inset-0 flex items-center">

        </div>
        <div className="relative flex justify-center text-xs uppercase">
          <span className="bg-stone-950 px-2 text-neutral-400">Or continue with</span>
        </div>
      </div>

      <button
        
        onClick={handleGoogleSignIn}
        disabled={isGoogleLoading}
        className="rounded-md flex gap-2 justify-center items-center w-full h-12 font-medium border border-stone-800 bg-stone-950 hover:bg-stone-900 transition-colors"
      >
        {isGoogleLoading ? <Loader2 className="mr-2 h-4 w-4 animate-spin" /> : <FaGoogle />}
        {isGoogleLoading ? "Connecting..." : "Sign in with Google"}
      </button>
      <button
        onClick={handleGoogleSignIn}
        disabled={isGoogleLoading}
        className="rounded-md flex gap-2 justify-center items-center w-full h-12 border border-stone-800 bg-stone-950 hover:bg-stone-900 transition-colors"
      >
        {isGoogleLoading ? <Loader2 className="mr-2 h-4 w-4 animate-spin" /> : <FaGithub />}
        {isGoogleLoading ? "Connecting..." : "Sign in with GitHub"}
      </button>
    </>
  )
}

