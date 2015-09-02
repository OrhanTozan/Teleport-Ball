package com.nahroto.teleportball.huds.menuhud.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.nahroto.teleportball.Application;
import com.nahroto.teleportball.huds.ImageButtonGroup;
import com.nahroto.teleportball.huds.menuhud.MenuHud;
import com.nahroto.teleportball.screens.HelpScreen;

public class HelpButton extends ImageButtonGroup
{
    public HelpButton(final Application app, final MenuHud menuHud)
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
                menuHud.removeAllActorsFromStage();
                app.setScreen(new HelpScreen(app));
            }
        });
    }
}
