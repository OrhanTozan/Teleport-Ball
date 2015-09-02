package com.nahroto.teleportball.huds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class ImageButtonGroup
{
    protected com.badlogic.gdx.scenes.scene2d.ui.ImageButton button;
    protected SpriteDrawable drawableUp, drawableDown;

    public ImageButton getButton()
    {
        return button;
    }

    protected void applyFilter()
    {
        drawableUp.getSprite().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        drawableDown.getSprite().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }
}
