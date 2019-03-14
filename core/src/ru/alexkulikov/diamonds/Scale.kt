package ru.alexkulikov.diamonds

import com.badlogic.gdx.Gdx

object Scale {
    const val WIDTH = 10f
    val HEIGHT = WIDTH / (Gdx.graphics.width.toFloat() / Gdx.graphics.height)
}