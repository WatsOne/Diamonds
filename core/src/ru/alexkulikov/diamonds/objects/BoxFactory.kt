package ru.alexkulikov.diamonds.objects

import com.badlogic.gdx.physics.box2d.*
import ktx.box2d.body

class BoxFactory(private val world: World) {
    fun createChain(vertices: FloatArray, material: Material) = world.body {
        chain(vertices) {
            applyMaterial(this, material)
        }
    }

    //todo Это говно отдаёт какой то странный Body с нулевыми параметрами, надо разобраться
//    fun createBox(x: Float, y: Float, position: Vector2, material: Material) = world.body {
//        type = BodyDef.BodyType.DynamicBody
//        box(x, y, position) {
//            applyMaterial(this, material)
//            userData = Box2DSprite(Texture("cube.png"))
//        }
//    }

    fun createBox(x: Float, y: Float, size: Float, material: Material): Body {
        val bDef = BodyDef().apply {
            position.set(x, y)
            type = BodyDef.BodyType.DynamicBody
        }

        val shape = PolygonShape().apply {
            setAsBox(size / 2, size / 2)
        }

        val fDef = FixtureDef().apply {
            this.shape = shape
            applyMaterial(this, material)
        }

        val body = world.createBody(bDef)
        body.createFixture(fDef)
        shape.dispose()

        return body
    }

    private fun applyMaterial(fixtureDef: FixtureDef, material: Material) {
        fixtureDef.density = material.density
        fixtureDef.friction = material.friction
        fixtureDef.restitution = material.restitution
    }
}