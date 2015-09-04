package com.nahroto.teleportball.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.nahroto.teleportball.Application;
import com.nahroto.teleportball.Constants;

public class LoadingScreen implements Screen
{

    private final Application app;

    public LoadingScreen(final Application app)
    {
        this.app = app;
    }

    @Override
    public void show()
    {
        app.camera.setToOrtho(false, Constants.V_WIDTH, Constants.V_HEIGHT);
        loadAssets();
    }

    private void loadAssets()
    {
        app.assets.load("atlases/everything1.pack", TextureAtlas.class);
        app.assets.load("images/paddlandball/bg-red.png", Texture.class);
        app.assets.load("images/paddlandball/bg-orange.png", Texture.class);
        app.assets.load("images/paddlandball/bg-blue.png", Texture.class);
        app.assets.load("images/paddlandball/bg-green.png", Texture.class);
        app.assets.load("images/helpScreen/helpscreen.png", Texture.class);
        app.assets.load("images/colors/overlay.png", Texture.class);
        app.assets.load("images/backButton/back-up.png", Texture.class);
        app.assets.load("images/backButton/back-down.png", Texture.class);
        app.assets.load("sounds/kick.wav", Sound.class);
        app.assets.load("sounds/a1.mp3", Sound.class);
        app.assets.load("sounds/a2.mp3", Sound.class);
        app.assets.load("sounds/rip.wav", Sound.class);
    }

    @Override
    public void render(float delta)
    {
        if (app.assets.update())
        {
            app.setScreen(new MenuScreen(app));
        }
    }

    @Override
    public void resize(int width, int height)
    {
        app.viewport.update(width, height);
    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void hide()
    {

    }

    @Override
    public void dispose()
    {

    }
}
