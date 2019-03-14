package ru.alexkulikov.diamonds

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20

object Utils {
    fun clearScreen() = Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT or GL20.GL_DEPTH_BUFFER_BIT or if (Gdx.graphics.bufferFormat.coverageSampling) GL20.GL_COVERAGE_BUFFER_BIT_NV else 0)
}