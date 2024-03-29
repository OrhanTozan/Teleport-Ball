package com.nahroto.teleportball.huds.menuhud;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
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

    public MenuHud(Viewport viewport, SpriteBatch batch, final Application app, Sprite bg, final TextureAtlas atlas)
    {
        super(viewport, batch);
        redBG = new Sprite(app.assets.get("images/paddlandball/bg-red.png", Texture.class));
        orangeBG = new Sprite(app.assets.get("images/paddlandball/bg-orange.png", Texture.class));
        blueBG = new Sprite(app.assets.get("images/paddlandball/bg-blue.png", Texture.class));
        greenBG = new Sprite(app.assets.get("images/paddlandball/bg-green.png", Texture.class));

        colorOverlay = new ColorOverlay(bg, redBG, orangeBG, blueBG, greenBG, app, atlas);
        titleLabel = new TitleLabel();
        playButton = new PlayButton(app, atlas);
        helpButton = new HelpButton(app, this, atlas);

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

    public void dispose()
    {

    }
}