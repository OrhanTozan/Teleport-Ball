package com.nahroto.teleportball.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.nahroto.teleportball.Application;
import com.nahroto.teleportball.Constants;
import com.nahroto.teleportball.fonts.Font;
import com.nahroto.teleportball.entities.Ball;
import com.nahroto.teleportball.entities.Player;
import com.nahroto.teleportball.huds.restarthud.RestartHud;
import com.nahroto.teleportball.huds.restarthud.actors.Score;

public class GameScreen implements Screen
{

    private final Application app;
    private Ball ball;
    private Player player;
    private TextureAtlas atlas;
    private Sprite bg;
    private Font font;
    private RestartHud restartHud;

    public GameScreen(final Application app)
    {
        this.app = app;
    }

    @Override
    public void show()
    {
        app.camera.setToOrtho(false, Constants.V_WIDTH, Constants.V_HEIGHT); // set camera ortho
        app.camera.update();
        initEntities();
        restartHud = new RestartHud(app.viewport, app.batch, player, ball);
    }

    private void initEntities()
    {
        atlas = app.assets.get("atlases/paddlandball/everything.pack"); // get texture atlas
        player = new Player(new Sprite(new Texture("images/paddlandball/paddle.png")), app); // init player with paddle texture
        ball = new Ball(new Sprite(new Texture("images/paddlandball/ball.png")), app); // init ball with ball texture
        bg = new Sprite(new Texture("images/paddlandball/bg.png"));
        font = new Font("fonts/district.otf", 100, Color.WHITE, true);
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // UPDATE
        if (ball.died())
        {
            restartHud.addAllActorsToStage();
            restartHud.update(delta);
        }
        else restartHud.removeAllActorsFromStage();
        restartHud.getScore().update();
        restartHud.getHighScore().update();
        if (ball.died() == false)
        {
            player.update(delta, app); // UPDATE PLAYER
            ball.update(delta, player); // UPDATE BALL
        }
        app.camera.update(); // UPDATE CAMERA

        // RENDER
        app.batch.setProjectionMatrix(app.camera.combined);
        app.batch.begin();
        app.batch.draw(bg, 0, 0); // DRAW BACKGROUND
        if (ball.died() == false)
        {
            player.render(app.batch); // DRAW PLAYER
            ball.render(app.batch); // DRAW BALL
            font.render(app.batch, Score.value.toString(), Constants.V_WIDTH / 2, Constants.V_HEIGHT / 2, true); // DRAW SCORE
        }
        app.batch.end();
        if (ball.died())
            restartHud.render();
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
        player.dispose();
        ball.dispose();
    }
}
