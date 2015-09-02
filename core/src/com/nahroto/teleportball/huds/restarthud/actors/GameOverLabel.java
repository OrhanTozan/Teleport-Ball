package com.nahroto.teleportball.huds.restarthud.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.nahroto.teleportball.fonts.Font;
import com.nahroto.teleportball.huds.LabelGroup;

public class GameOverLabel extends LabelGroup
{
    public GameOverLabel()
    {
        labelStyle = new Label.LabelStyle();
        font = new Font("fonts/district.otf", 120, Color.WHITE, true);
        labelStyle.font = font.getFont();
        text = "Game Over :(";

        label = new Label(text, labelStyle);
    }
}