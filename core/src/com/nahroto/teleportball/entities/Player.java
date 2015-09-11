package com.nahroto.teleportball.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.nahroto.teleportball.Application;
import com.nahroto.teleportball.Constants;
import com.nahroto.teleportball.huds.restarthud.actors.Score;

public class Player extends Entity
{
    private static final int SCORE_MULTIPLIER = 10;

    public boolean isBottom;
    private Vector2 unprojectedTouchPos = new Vector2();
    private Vector2 touchPos = new Vector2();
    private Vector2 velocity = new Vector2();

    public Player(Sprite sprite, final Application app)
    {
        super(sprite, app);
        isBottom = true;
        position.set(Constants.V_WIDTH / 2 - sprite.getWidth() / 2, 0);
        sprite.setColor(Color.WHITE);
        bounds.set(position.x, position.y, sprite.getWidth(), sprite.getHeight());
        velocity.set(900, 0);
    }

    public void update(float delta, final Application app)
    {
        handleInput(delta, app);
        updateVelocity();
        System.out.println((int)velocity.x);
        if (position.x < 0)
            position.x = 0;
        else if (position.x > Constants.V_WIDTH - sprite.getWidth())
            position.x = Constants.V_WIDTH - sprite.getWidth();
        updateY();
        bounds.setPosition(position);
    }

    private void handleInput(float delta, final Application app)
    {
        for (int i = 0; i < 2; i++)
        {
            if (Gdx.input.isTouched(i))
            {
                touchPos.set(Gdx.input.getX(i), Gdx.input.getY(i));
                unprojectedTouchPos.set(touchPos);
                app.viewport.unproject(unprojectedTouchPos);
                if (unprojectedTouchPos.x < Constants.V_WIDTH / 2)
                    position.x -= velocity.x * delta;
                else
                    position.x += velocity.x * delta;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            position.x -= velocity.x * delta;
        else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            position.x += velocity.x * delta;
    }

    private void updateVelocity()
    {
        if (velocity.x > 0) // if velocity.y is positive
        {
            velocity.x = 900 + (Score.value * SCORE_MULTIPLIER);
            if (velocity.x > 1100)
                velocity.x = 1100;
        }

        else if (velocity.x < 0) // else if velocity.y is negative
        {
            velocity.x = -900 - (Score.value * SCORE_MULTIPLIER);
            if (velocity.x < -1100)
                velocity.x = -1100;
        }
    }


    private void updateY()
    {
        if (isBottom) position.y = 0;
        else position.y = Constants.V_HEIGHT - sprite.getHeight();
    }

    public void reset()
    {
        isBottom = true;
        position.set(Constants.V_WIDTH / 2 - sprite.getWidth() / 2, 0);
    }
}
