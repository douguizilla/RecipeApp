package com.odougle.recipeapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform