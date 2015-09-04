package com.nahroto.teleportball.huds.restarthud.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.nahroto.teleportball.Application;
import com.nahroto.teleportball.entities.Ball;
import com.nahroto.teleportball.huds.ImageButtonGroup;
import com.nahroto.teleportball.screens.MenuScreen;

public class HomeButton extends ImageButtonGroup
{
    public HomeButton(final Application app, final TextureAtlas atlas)
    {
        drawableUp = new SpriteDrawable(atlas.createSprite("home-up"));
        drawableDown = new SpriteDrawable(atlas.createSprite("home-down"));

        applyFilter();

        button = new ImageButton(drawableUp, drawableDown);

        button.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                Ball.died = false;
                app.setScreen(new MenuScreen(app));
            }
        });
    }
}
