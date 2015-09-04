package com.nahroto.teleportball.huds.restarthud.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.nahroto.teleportball.Application;
import com.nahroto.teleportball.Constants;
import com.nahroto.teleportball.fonts.Font;
import com.nahroto.teleportball.huds.LabelGroup;

public class HighScore extends LabelGroup
{
    public static Integer value;

    public HighScore(final Application app)
    {
        labelStyle = new Label.LabelStyle();
        font = new Font("fonts/district.otf", 80, Color.WHITE, true);
        labelStyle.font = font.getFont();
        value = Score.value;
        text = "Best: " + app.prefs.getInteger("highScore", value);
        label = new Label(text, labelStyle);
    }

    public void update(final Application app)
    {
        if (Score.value > app.prefs.getInteger("highScore", value))
        {
            value = Score.value;
            app.prefs.putInteger("highScore", value);
            app.prefs.flush();
        }
        text = "Best: " + app.prefs.getInteger("highScore", value);
        label.setText(text);
        getLabel().setPosition(Constants.V_WIDTH / 2 - getWidth(text) / 2, Constants.V_HEIGHT / 2 - getHeight(text) / 2 - 500);
    }
}
