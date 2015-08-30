package com.nahrot.teleportball.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.nahrot.teleportball.Application;
import com.nahrot.teleportball.Constants;
import com.nahrot.teleportball.huds.menuhud.MenuHud;

public class MenuScreen implements Screen
{

    private final Application app;
    private MenuHud menuHud;
    private Sprite bg;

    public MenuScreen(final Application app)
    {
        this.app = app;
    }

    @Override
    public void show()
    {
        app.camera.setToOrtho(false, Constants.V_WIDTH, Constants.V_HEIGHT);
        app.camera.update();
        menuHud = new MenuHud(app.viewport, app.batch, app);
        bg = new Sprite(new Texture("images/paddlandball/bg.png"));
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        // UPDATE
        menuHud.update(delta);
        app.camera.update();

        // RENDER
        app.batch.setProjectionMatrix(app.camera.combined);
        app.batch.begin();
        app.batch.draw(bg, 0, 0); // RENDER BACKGROUND
        app.batch.end();
        menuHud.render();
    }

    @Override
    public void resize(int width, int height)
    {

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
