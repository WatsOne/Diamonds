package ru.alexkulikov.diamonds.graphics

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Texture
import ktx.assets.getAsset
import ktx.assets.load

@Suppress("EnumEntryName")
enum class Images {
    diamond,
    glow;

    private val path = "$name.png"

    fun load() = manager.load<Texture>(path)

    operator fun invoke() = manager.getAsset<Texture>(path)

    companion object {
        lateinit var manager: AssetManager
    }
}