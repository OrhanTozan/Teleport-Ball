package com.nahroto.teleportball.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.nahroto.teleportball.Application;
import com.nahroto.teleportball.Constants;

public class Player extends Entity
{
    public boolean isBottom;
    private Vector2 unprojectedTouchPos = new Vector2();
    private Vector2 touchPos = new Vector2();

    public Player(Sprite sprite, final Application app)
    {
        super(sprite, app);
        isBottom = true;
        position.set(Constants.V_WIDTH / 2 - sprite.getWidth() / 2, 0);
        sprite.setColor(Color.WHITE);
        bounds.set(position.x, position.y, sprite.getWidth(), sprite.getHeight());
    }

    public void update(float delta, final Application app)
    {
        handleInput(delta, app);
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
                    position.x += -900 * delta;
                else
                    position.x += 900 * delta;
            }
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
