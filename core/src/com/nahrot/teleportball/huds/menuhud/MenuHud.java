package com.nahrot.teleportball.huds.menuhud;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nahrot.teleportball.Application;
import com.nahrot.teleportball.Constants;
import com.nahrot.teleportball.huds.Hud;
import com.nahrot.teleportball.huds.menuhud.actors.ColorButton;
import com.nahrot.teleportball.huds.menuhud.actors.HelpButton;
import com.nahrot.teleportball.huds.menuhud.actors.PlayButton;
import com.nahrot.teleportball.huds.menuhud.actors.TitleLabel;

public class MenuHud extends Hud
{
    private TitleLabel titleLabel;
    private PlayButton playButton;
    private HelpButton helpButton;
    private ColorButton colorButton;

    public MenuHud(Viewport viewport, SpriteBatch batch, final Application app)
    {
        super(viewport, batch);
        titleLabel = new TitleLabel();
        playButton = new PlayButton(app);
        helpButton = new HelpButton(app, this);
        colorButton = new ColorButton(new Sprite(new Texture("images/colors/black-up.png")), new Sprite(new Texture("images/colors/black-up.png")));

        titleLabel.getLabel().setPosition(Constants.V_WIDTH / 2, Constants.V_HEIGHT / 2 + 400, Align.center);
        playButton.getButton().setPosition(Constants.V_WIDTH / 2, Constants.V_HEIGHT / 2, Align.center);
        helpButton.getButton().setPosition(Constants.V_WIDTH / 2, Constants.V_HEIGHT / 2 - 200, Align.center);
        colorButton.getButton().setPosition(Constants.V_WIDTH / 2, 0, Align.bottom);

        actors.add(titleLabel.getLabel());
        actors.add(playButton.getButton());
        actors.add(helpButton.getButton());
        actors.add(colorButton.getButton());

        addAllActorsToStage();
    }
}