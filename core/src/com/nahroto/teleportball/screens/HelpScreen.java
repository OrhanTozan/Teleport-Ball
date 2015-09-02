package com.nahroto.teleportball.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.nahroto.teleportball.Application;
import com.nahroto.teleportball.Constants;
import com.nahroto.teleportball.entities.Player;

public class HelpScreen implements Screen
{
    private final Application app;
    private Player player;
    private Sprite bg, overlay;
    private ImageButton backButton;
    private SpriteDrawable bUp, bDown;
    private Stage stage;

    public HelpScreen(final Application app)
    {
        this.app = app;
    }

    @Override
    public void show()
    {
        app.camera.setToOrtho(false, Constants.V_WIDTH, Constants.V_HEIGHT);
        player = new Player(new Sprite(new Texture("images/paddlandball/paddle.png")), app);
        bg = new Sprite(new Texture("images/paddlandball/bg.png"));
        overlay = new Sprite(new Texture("images/helpScreen/helpscreen.png"));
        overlay.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        bUp = new SpriteDrawable(new Sprite(new Texture("images/backButton/back-up.png")));
        bDown = new SpriteDrawable(new Sprite(new Texture("images/backButton/back-down.png")));

        bUp.getSprite().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        bDown.getSprite().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        backButton = new ImageButton(bUp, bDown);
        backButton.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                backButton.remove();
                app.setScreen(new MenuScreen(app));
            }
        });
        backButton.setPosition(20, Constants.V_HEIGHT - backButton.getHeight() - 20);

        stage = new Stage(app.viewport, app.batch);

        stage.addActor(backButton);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // UPDATE
        stage.act(delta);
        player.update(delta, app);

        // RENDER
        app.batch.setProjectionMatrix(app.camera.combined);
        app.batch.begin();
        app.batch.draw(bg, 0, 0);
        app.batch.draw(overlay, 0, 0);
        player.render(app.batch);
        app.batch.end();
        stage.draw();
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
