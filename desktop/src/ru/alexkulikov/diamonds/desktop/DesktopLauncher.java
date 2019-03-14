package ru.alexkulikov.diamonds.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.alexkulikov.diamonds.DiamondsGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new DiamondsGame(), config);
		config.vSyncEnabled = true;
		config.width = 600;
		config.height = 800;
		config.samples = 3;

	}
}
