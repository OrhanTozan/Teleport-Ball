package com.nahroto.teleportball.huds.menuhud.actors.overlay;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.nahrot.teleportball.huds.ImageButtonGroup;

public class ColorButton extends ImageButtonGroup
{
    public ColorButton(Sprite spriteDown, Sprite spriteUp)
    {
        drawableDown = new SpriteDrawable(spriteDown);
        drawableUp = new SpriteDrawable(spriteUp);

        applyFilter();

        button = new ImageButton(drawableDown, drawableUp);
    }
}
