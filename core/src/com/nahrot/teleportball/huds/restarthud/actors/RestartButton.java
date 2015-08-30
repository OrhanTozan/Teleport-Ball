package com.nahrot.teleportball.huds.restarthud.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.nahrot.teleportball.entities.Ball;
import com.nahrot.teleportball.entities.Player;
import com.nahrot.teleportball.huds.ImageButtonGroup;

public class RestartButton extends ImageButtonGroup
{
    public RestartButton(final Player player, final Ball ball)
    {
        drawableUp = new SpriteDrawable(new Sprite(new Texture("images/restartButton/rb-normal.png")));
        drawableDown = new SpriteDrawable(new Sprite(new Texture("images/restartButton/rb-down.png")));
        applyFilter();

        button = new ImageButton(drawableUp, drawableDown);

        button.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                Ball.died = false;
                ball.reset();
                player.reset();
            }
        });
    }
}
