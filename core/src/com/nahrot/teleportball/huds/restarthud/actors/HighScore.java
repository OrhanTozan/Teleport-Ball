package com.nahroto.teleportball.huds.restarthud.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.nahrot.teleportball.Constants;
import com.nahrot.teleportball.fonts.Font;
import com.nahrot.teleportball.huds.LabelGroup;

public class HighScore extends LabelGroup
{
    public static Integer value;
    private Preferences pref;

    public HighScore()
    {
        labelStyle = new Label.LabelStyle();
        font = new Font("fonts/district.otf", 80, Color.WHITE, true);
        labelStyle.font = font.getFont();
        pref = Gdx.app.getPreferences("Teleport_Ball_data");
        value = Score.value;
        text = "Best: " + pref.getInteger("highScore", value);
        label = new Label(text, labelStyle);
    }

    public void update()
    {
        if (Score.value > pref.getInteger("highScore", value))
        {
            value = Score.value;
            pref.putInteger("highScore", value);
            pref.flush();
        }
        text = "Best: " + pref.getInteger("highScore", value);
        label.setText(text);
        getLabel().setPosition(Constants.V_WIDTH / 2 - getWidth(text) / 2, Constants.V_HEIGHT / 2 - getHeight(text) / 2 - 500);
    }
}
