package ru.alexkulikov.diamonds.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.input.GestureDetector
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer
import com.badlogic.gdx.physics.box2d.World
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.FitViewport
import ktx.app.KtxScreen
import ktx.inject.Context
import ru.alexkulikov.diamonds.Scale
import ru.alexkulikov.diamonds.Utils
import ru.alexkulikov.diamonds.objects.BoxFactory
import ru.alexkulikov.diamonds.objects.Diamond
import ru.alexkulikov.diamonds.objects.Material

class GameScreen(private val context: Context): KtxScreen {
    private val world: World = context.inject()
    private val boxFactory: BoxFactory = context.inject()
    private val worldDebugRenderer = Box2DDebugRenderer()

    private val mainStage = Stage(FitViewport(Scale.WIDTH, Scale.HEIGHT)).apply {
//        isDebugAll = true
    }

    override fun show() {
        Gdx.input.inputProcessor = GestureDetector(GestureController(mainStage.camera, this::createDiamond))
        test()
    }

    override fun render(delta: Float) {
        Utils.clearScreen()

        world.step(1.0f / 60.0f, 6, 2)
//        worldDebugRenderer.render(world, mainStage.camera.combined)
        mainStage.act(delta)
        mainStage.draw()
    }

    override fun dispose() {
        mainStage.dispose()
    }

    private fun test() {
        boxFactory.createChain(floatArrayOf(1.0f, 1.0f, 9.0f, 1.0f), Material.ICE)
//        mainStage.addActor(Diamond(context, 5.0f, 5.0f, 0.4f))
    }

    private fun createDiamond(x: Float, y:Float) {
        mainStage.addActor(Diamond(context, x, y, 0.4f))
    }
}