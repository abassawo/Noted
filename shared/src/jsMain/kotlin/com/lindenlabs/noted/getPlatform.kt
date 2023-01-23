package com.lindenlabs.noted

actual fun getPlatform(): Platform {
    return object : Platform {
        override val name: String
            get() = "Web"

    }
}