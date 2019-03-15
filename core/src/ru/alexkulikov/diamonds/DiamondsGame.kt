package ru.alexkulikov.diamonds

import com.badlogic.gdx.Screen
import com.badlogic.gdx.assets.AssetManager
import ktx.app.KtxGame
import ktx.box2d.createWorld
import ktx.box2d.earthGravity
import ktx.inject.Context
import ru.alexkulikov.diamonds.graphics.Images
import ru.alexkulikov.diamonds.objects.BoxFactory
import ru.alexkulikov.diamonds.screen.GameScreen
import ru.alexkulikov.diamonds.screen.ScreenType

class DiamondsGame : KtxGame<Screen>() {
    private val context = Context()

    override fun create() {
        context.register {
            bindSingleton(this@DiamondsGame)

            val world = createWorld(earthGravity, true)
            bindSingleton(world)
            bindSingleton(BoxFactory(world))
        }

        val assetManager = AssetManager()
        Images.manager = assetManager
        Images.values().forEach { it.load() }
        assetManager.finishLoading()

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
