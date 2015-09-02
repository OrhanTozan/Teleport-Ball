package com.nahroto.teleportball.huds;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.nahrot.teleportball.fonts.Font;

public abstract class LabelGroup
{
    protected com.badlogic.gdx.scenes.scene2d.ui.Label label;
    protected com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle labelStyle;
    protected Font font;
    protected String text;

    public Label getLabel()
    {
        return label;
    }

    public float getWidth()
    {
        return font.getWidth(text);
    }

    public float getWidth(String text)
    {
        return font.getWidth(text);
    }

    public float getHeight()
    {
        return font.getHeight(text);
    }

    public float getHeight(String text)
    {
        return font.getHeight(text);
    }
}
