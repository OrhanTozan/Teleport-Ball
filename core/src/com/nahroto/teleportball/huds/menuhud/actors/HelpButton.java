package com.nahroto.teleportball.huds.menuhud.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.nahroto.teleportball.Application;
import com.nahroto.teleportball.huds.ImageButtonGroup;
import com.nahroto.teleportball.huds.menuhud.MenuHud;
import com.nahroto.teleportball.huds.menuhud.actors.overlay.ColorButton;
import com.nahroto.teleportball.huds.menuhud.actors.overlay.ColorOverlay;
import com.nahroto.teleportball.screens.HelpScreen;

public class HelpButton extends ImageButtonGroup
{
    public HelpButton(final Application app, final MenuHud menuHud, final TextureAtlas atlas)
    {
        drawableUp = new SpriteDrawable(atlas.createSprite("help-up"));
        drawableDown = new SpriteDrawable(atlas.createSprite("help-down"));
        applyFilter();

        button = new ImageButton(drawableUp, drawableDown);

        button.addListener(new ClickListener()
        {
            @Override
            public void clicked (InputEvent event, float x, float y)
            {
                menuHud.removeAllActorsFromStage();
                ColorOverlay.enabled = false;
                app.setScreen(new HelpScreen(app, atlas));
            }
        });
    }
}
