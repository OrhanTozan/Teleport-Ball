package com.nahrot.teleportball.huds.menuhud;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nahrot.teleportball.Application;
import com.nahrot.teleportball.Constants;
import com.nahrot.teleportball.huds.Hud;
import com.nahrot.teleportball.huds.menuhud.actors.HelpButton;
import com.nahrot.teleportball.huds.menuhud.actors.PlayButton;
import com.nahrot.teleportball.huds.menuhud.actors.TitleLabel;

public class MenuHud extends Hud
{
    private TitleLabel titleLabel;
    private PlayButton playButton;
    private HelpButton helpButton;

    public MenuHud(Viewport viewport, SpriteBatch batch, final Application app)
    {
        super(viewport, batch);
        titleLabel = new TitleLabel();
        playButton = new PlayButton(app);
        helpButton = new HelpButton(app);
        titleLabel.getLabel().setPosition(Constants.V_WIDTH / 2, Constants.V_HEIGHT / 2);
    }
}