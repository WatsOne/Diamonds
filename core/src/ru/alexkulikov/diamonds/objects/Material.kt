package ru.alexkulikov.diamonds.objects

enum class Material private constructor(val density: Float, val restitution: Float, val friction: Float) {
    ICE(0.92f, 0.01f, 0.01f),
    STONE(2.5f, 0.2f, 0.5f),
    WOOD(0.65f, 0.4f, 0.4f)
}