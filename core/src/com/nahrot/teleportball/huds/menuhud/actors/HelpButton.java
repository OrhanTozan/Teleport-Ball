package com.nahrot.teleportball.huds.menuhud.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.nahrot.teleportball.Application;
import com.nahrot.teleportball.huds.ImageButtonGroup;
import com.nahrot.teleportball.screens.HelpScreen;

public class HelpButton extends ImageButtonGroup
{
    public HelpButton(final Application app)
    {
        drawableUp = new SpriteDrawable(new Sprite(new Texture("images/helpButton/help-up.png")));
        drawableDown = new SpriteDrawable(new Sprite(new Texture("images/helpButton/help-down.png")));
        applyFilter();

        button = new com.badlogic.gdx.scenes.scene2d.ui.ImageButton(drawableUp, drawableDown);

        button.addListener(new ClickListener()
        {
            @Override
            public void clicked (InputEvent event, float x, float y)
            {
                app.setScreen(new HelpScreen(app));
            }
        });
    }
}
