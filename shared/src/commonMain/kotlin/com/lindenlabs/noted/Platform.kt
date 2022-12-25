package com.lindenlabs.noted

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform