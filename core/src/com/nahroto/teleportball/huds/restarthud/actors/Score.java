package com.nahroto.teleportball.huds.restarthud.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.nahrot.teleportball.Constants;
import com.nahrot.teleportball.fonts.Font;
import com.nahrot.teleportball.huds.LabelGroup;

public class Score extends LabelGroup
{
    public static Integer value;

    public Score()
    {
        value = new Integer(0);
        font = new Font("fonts/district.otf", 160, Color.WHITE, true);
        labelStyle = new Label.LabelStyle(font.getFont(), Color.WHITE);
        text = value.toString();

        label = new Label(text, labelStyle);
    }

    public void update()
    {
        text = value.toString();
        label.setText(text);
        getLabel().setPosition(Constants.V_WIDTH / 2 - getWidth(text) / 2, Constants.V_HEIGHT / 2 - getHeight(text) / 2 - 300);
    }
}
