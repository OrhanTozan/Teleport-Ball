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
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.nahroto.teleportball.Application;
import com.nahroto.teleportball.Constants;
import com.nahroto.teleportball.fonts.Font;

public class LoadingScreen implements Screen
{

    private final Application app;
    private ShapeRenderer sRenderer;
    private Font font;
    private Sprite bg;
    private float progress;

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
        font = new Font("fonts/district.otf", 90, Color.WHITE, true);
        String path = app.prefs.getString("BG_PATH", "images/paddlandball/bg-red.png");
        bg = new Sprite(new Texture(path));
        progress = 0f;
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
        app.assets.finishLoading();
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0, 0, 0, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        progress = MathUtils.lerp(progress, app.assets.getProgress(), 0.1f);
        if (app.assets.update() && progress >= app.assets.getProgress() - 0.001f)
        {
            app.setScreen(new MenuScreen(app));
        }
        app.batch.setProjectionMatrix(app.camera.combined);
        app.batch.begin();
        app.batch.draw(bg, 0, 0);
        font.render(app.batch, "Loading", Constants.V_WIDTH / 2, Constants.V_HEIGHT / 2 + 100, true);
        app.batch.end();
        sRenderer.setProjectionMatrix(app.camera.combined);
        sRenderer.begin(ShapeRenderer.ShapeType.Line);
        sRenderer.setAutoShapeType(true);
        sRenderer.setColor(Color.WHITE);
        sRenderer.rect(Constants.V_WIDTH / 2 - 250, Constants.V_HEIGHT / 2 - 25, 500, 50);

        sRenderer.set(ShapeRenderer.ShapeType.Filled);
        sRenderer.setColor(Color.WHITE);
        sRenderer.rect(Constants.V_WIDTH / 2 - 250, Constants.V_HEIGHT / 2 - 25, progress * 500, 50);
        sRenderer.end();
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
