package com.nahroto.teleportball.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nahroto.teleportball.Application;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Teleport Ball";
		config.width = 480;
		config.height = 800;
		config.resizable = true;
		config.addIcon("desktop-icons/ic_launcher.png", Files.FileType.Internal);
		config.addIcon("desktop-icons/ic_launcher16x16.png", Files.FileType.Internal);
		new LwjglApplication(new Application(null), config);
	}
}
