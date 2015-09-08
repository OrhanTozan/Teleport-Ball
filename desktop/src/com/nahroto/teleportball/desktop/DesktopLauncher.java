package com.nahroto.teleportball.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nahroto.teleportball.Application;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Teleport Ball";
		config.width = 480;
		config.height = 800;
		config.resizable = false;
		new LwjglApplication(new Application(null), config);
	}
}
