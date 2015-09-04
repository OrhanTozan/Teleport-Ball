package com.nahroto.teleportball.huds.menuhud;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nahroto.teleportball.Application;
import com.nahroto.teleportball.Constants;
import com.nahroto.teleportball.huds.Hud;
import com.nahroto.teleportball.huds.menuhud.actors.HelpButton;
import com.nahroto.teleportball.huds.menuhud.actors.PlayButton;
import com.nahroto.teleportball.huds.menuhud.actors.TitleLabel;
import com.nahroto.teleportball.huds.menuhud.actors.overlay.ColorButton;
import com.nahroto.teleportball.huds.menuhud.actors.overlay.ColorOverlay;

public class MenuHud extends Hud
{
    private TitleLabel titleLabel;
    private PlayButton playButton;
    private HelpButton helpButton;
    private ColorOverlay colorOverlay;
    private Sprite redBG, orangeBG, blueBG, greenBG;

    public MenuHud(Viewport viewport, SpriteBatch batch, final Application app, Sprite bg)
    {
        super(viewport, batch);
        redBG = new Sprite(new Texture("images/paddlandball/bg-red.png"));
        orangeBG = new Sprite(new Texture("images/paddlandball/bg-orange.png"));
        blueBG = new Sprite(new Texture("images/paddlandball/bg-blue.png"));
        greenBG = new Sprite(new Texture("images/paddlandball/bg-green.png"));

        colorOverlay = new ColorOverlay(bg, redBG, orangeBG, blueBG, greenBG, app);
        titleLabel = new TitleLabel();
        playButton = new PlayButton(app);
        helpButton = new HelpButton(app, this);

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