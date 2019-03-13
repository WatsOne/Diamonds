package ru.alexkulikov.diamonds.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import ktx.app.KtxScreen
import ktx.graphics.use
import ktx.inject.Context

class GameScreen(private val context: Context): KtxScreen {
    private val batch = SpriteBatch()
    private val image = Texture("badlogic.jpg")

    override fun render(delta: Float) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT or GL20.GL_DEPTH_BUFFER_BIT or if (Gdx.graphics.bufferFormat.coverageSampling) GL20.GL_COVERAGE_BUFFER_BIT_NV else 0)
        batch.use {
            it.draw(image, 0f, 0f)
        }
    }

    override fun dispose() {
        batch.dispose()
        image.dispose()
    }
}