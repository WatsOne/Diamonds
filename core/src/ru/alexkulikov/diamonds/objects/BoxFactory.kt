package ru.alexkulikov.diamonds.objects

import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.BodyDef
import com.badlogic.gdx.physics.box2d.FixtureDef
import com.badlogic.gdx.physics.box2d.World
import ktx.box2d.body

class BoxFactory(private val world: World) {
    fun createChain(vertices: FloatArray, material: Material) = world.body {
        chain(vertices) {
            applyMaterial(this, material)
        }
    }

    fun createBox(x: Float, y: Float, position: Vector2, material: Material) = world.body {
        type = BodyDef.BodyType.DynamicBody
        box(x, y, position) {
            applyMaterial(this, material)
        }
    }

    private fun applyMaterial(fixtureDef: FixtureDef, material: Material) {
        fixtureDef.density = material.density
        fixtureDef.friction = material.friction
        fixtureDef.restitution = material.restitution
    }
}