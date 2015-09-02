package com.nahroto.teleportball.huds.restarthud.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.nahroto.teleportball.Application;
import com.nahroto.teleportball.huds.ImageButtonGroup;
import com.nahroto.teleportball.screens.MenuScreen;

public class HomeButton extends ImageButtonGroup
{
    public HomeButton(final Application app)
    {
        drawableUp = new SpriteDrawable(new Sprite(new Texture("images/homeButton/home-up.png")));
        drawableDown = new SpriteDrawable(new Sprite(new Texture("images/homeButton/home-down.png")));

        applyFilter();

        button = new ImageButton(drawableUp, drawableDown);

        button.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                app.setScreen(new MenuScreen(app));
            }
        });
    }
}
