package com.nahroto.teleportball.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.nahroto.teleportball.Application;
import com.nahroto.teleportball.Constants;
import com.nahroto.teleportball.fonts.Font;

public class LoadingScreen implements Screen
{

    private final Application app;
    private ShapeRenderer sRenderer;
    private Font font;

    public LoadingScreen(final Application app)
    {
        this.app = app;
    }

    @Override
    public void show()
    {
        app.camera.setToOrtho(false, Constants.V_WIDTH, Constants.V_HEIGHT);
        app.camera.update();

        sRenderer = new ShapeRenderer();
        font = new Font("fonts/district.otf", 60, Color.WHITE, true);

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
        Gdx.gl.glClearColor(0, 0, 0, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (app.assets.update())
        {
            app.setScreen(new MenuScreen(app));
        }

        sRenderer.setProjectionMatrix(app.camera.combined);
        sRenderer.begin(ShapeRenderer.ShapeType.Filled);
        sRenderer.setColor(Color.WHITE);
        sRenderer.rect(Constants.V_WIDTH / 2 - 150, Constants.V_HEIGHT / 2 - 25, app.assets.getProgress() * 300, 50);
        sRenderer.end();
        app.batch.setProjectionMatrix(app.camera.combined);
        app.batch.begin();
        font.render(app.batch, "Loading...", Constants.V_WIDTH / 2, Constants.V_HEIGHT / 2 - 400, true);
        app.batch.end();
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
        dispose();
    }

    @Override
    public void dispose()
    {
    }
}
