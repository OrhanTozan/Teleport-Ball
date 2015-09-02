package com.nahrot.teleportball.huds.menuhud;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nahrot.teleportball.Application;
import com.nahrot.teleportball.Constants;
import com.nahrot.teleportball.huds.Hud;
import com.nahrot.teleportball.huds.menuhud.actors.HelpButton;
import com.nahrot.teleportball.huds.menuhud.actors.PlayButton;
import com.nahrot.teleportball.huds.menuhud.actors.TitleLabel;
import com.nahrot.teleportball.huds.menuhud.actors.overlay.ColorButton;
import com.nahrot.teleportball.huds.menuhud.actors.overlay.ColorOverlay;

public class MenuHud extends Hud
{
    private TitleLabel titleLabel;
    private PlayButton playButton;
    private HelpButton helpButton;
    private ColorOverlay colorOverlay;

    public MenuHud(Viewport viewport, SpriteBatch batch, final Application app)
    {
        super(viewport, batch);
        titleLabel = new TitleLabel();
        playButton = new PlayButton(app);
        helpButton = new HelpButton(app, this);
        colorOverlay = new ColorOverlay();

        titleLabel.getLabel().setPosition(Constants.V_WIDTH / 2, Constants.V_HEIGHT / 2 + 500, Align.center);
        playButton.getButton().setPosition(Constants.V_WIDTH / 2, Constants.V_HEIGHT / 2 + 100, Align.center);
        helpButton.getButton().setPosition(Constants.V_WIDTH / 2, Constants.V_HEIGHT / 2 - 100, Align.center);
        colorOverlay.getImage().setPosition(Constants.V_WIDTH / 2, -150, Align.bottom);

        actors.add(titleLabel.getLabel());
        actors.add(playButton.getButton());
        actors.add(helpButton.getButton());
        actors.add(colorOverlay.getImage());

        // ADD COLOR BUTTONS OF COLOR OVERLAY TO ACTOR LIST
        for (ColorButton colorButton : colorOverlay.getColorButtons())
        {
            actors.add(colorButton.getButton());
        }

        addAllActorsToStage();
    }

    @Override
    public void update(float delta)
    {
        super.update(delta);
        colorOverlay.update();
    }
}