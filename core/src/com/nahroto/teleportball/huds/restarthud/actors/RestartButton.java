package com.nahroto.teleportball.huds.restarthud.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.nahroto.teleportball.entities.Ball;
import com.nahroto.teleportball.entities.Player;
import com.nahroto.teleportball.huds.ImageButtonGroup;
import com.nahroto.teleportball.screens.GameScreen;

public class RestartButton extends ImageButtonGroup
{
    public RestartButton(final Player player, final Ball ball, final TextureAtlas atlas)
    {
        drawableUp = new SpriteDrawable(atlas.createSprite("rb-normal"));
        drawableDown = new SpriteDrawable(atlas.createSprite("rb-down"));
        applyFilter();

        button = new ImageButton(drawableUp, drawableDown);

        button.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                Ball.died = false;
                GameScreen.adAlreadyShowed++;
                ball.reset();
                player.reset();
            }
        });
    }
}
