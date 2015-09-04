package com.nahroto.teleportball.huds.menuhud.actors.overlay;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.nahroto.teleportball.Application;
import com.nahroto.teleportball.huds.ImageButtonGroup;

public class ColorButton extends ImageButtonGroup
{
    public ColorButton(Sprite spriteDown, Sprite spriteUp)
    {
        drawableDown = new SpriteDrawable(spriteDown);
        drawableUp = new SpriteDrawable(spriteUp);

        applyFilter();

        button = new ImageButton(drawableDown, drawableUp);
    }

    public void whenClicked(final Sprite bg, final Sprite newBg, final String newBGPath, final Application app)
    {
        button.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                app.prefs.putString("BG_PATH", newBGPath);
                app.prefs.flush();
                bg.setTexture(newBg.getTexture());
            }
        });
    }
}
