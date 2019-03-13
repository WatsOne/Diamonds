package ru.alexkulikov.diamonds

import com.badlogic.gdx.Screen
import ktx.app.KtxGame
import ktx.inject.Context
import ru.alexkulikov.diamonds.screen.GameScreen
import ru.alexkulikov.diamonds.screen.ScreenType

class DiamondsGame : KtxGame<Screen>() {
    private val context = Context()

    override fun create() {
        context.register {
            bindSingleton(this@DiamondsGame)
        }

        addScreen(GameScreen(context))
        setScreen<GameScreen>()
    }

    fun switchScreen(type: ScreenType) {
        when (type) {
            ScreenType.GAME -> setScreen<GameScreen>()
            else -> {
                setScreen<GameScreen>()
            }
        }
    }

    override fun dispose() {
        super.dispose()
        context.dispose()
    }
}