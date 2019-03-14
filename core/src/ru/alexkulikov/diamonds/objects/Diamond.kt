package ru.alexkulikov.diamonds.objects

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.scenes.scene2d.Actor
import ktx.inject.Context


class Diamond(context: Context, xInit: Float, yInit: Float, size: Float) : Actor() {
    private val boxFactory: BoxFactory = context.inject()
    private var body = boxFactory.createBox(xInit, yInit, size, Material.WOOD)

    private val sprite = Sprite(Texture("cube.png"))
    private val spriteGlow = Sprite(Texture("glow.png"))

    init {
        setBounds(xInit, yInit, size, size)
        setOrigin(size / 2, size / 2)
        sprite.setBounds(body.position.x, body.position.y, size, size)
        sprite.setOriginCenter()
        sprite.color = Color.BLUE

        spriteGlow.setBounds(body.position.x, body.position.y, size, size)
        spriteGlow.setOriginCenter()
        spriteGlow.color = Color.RED
    }

    override fun act(delta: Float) {
        setPosition(body.position.x - width / 2, body.position.y - height / 2)
        rotation = MathUtils.radiansToDegrees * body.angle

        sprite.setPosition(x, y)
        sprite.rotation = rotation

        spriteGlow.setPosition(x, y)
        spriteGlow.rotation = rotation

        super.act(delta)
    }

    override fun draw(batch: Batch, parentAlpha: Float) {
        val originalSrcFunc = batch.blendSrcFunc
        val originalDstFunc = batch.blendDstFunc
        batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE)
        spriteGlow.draw(batch)
        batch.setBlendFunction(originalSrcFunc, originalDstFunc)
        sprite.draw(batch)
    }
}