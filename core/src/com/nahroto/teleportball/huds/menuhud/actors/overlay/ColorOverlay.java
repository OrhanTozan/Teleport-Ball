package com.nahroto.teleportball.huds.menuhud.actors.overlay;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.nahroto.teleportball.Application;
import com.nahroto.teleportball.Constants;

import javafx.scene.layout.Background;

public class ColorOverlay
{
    public static boolean enabled, busy = false;

    private Image image;
    private ColorButton redButton, orangeButton, blueButton, greenButton;
    private Array<ColorButton> colorButtons;

    public ColorOverlay(Sprite bg, Sprite redBG, Sprite orangeBG, Sprite blueBG, Sprite greenBg, final Application app, final TextureAtlas atlas)
    {
        Sprite sprite = new Sprite(app.assets.get("images/colors/overlay.png", Texture.class));
        sprite.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        image = new Image(sprite);

        colorButtons = new Array<ColorButton>();

        redButton = new ColorButton(atlas.createSprite("red-up"), atlas.createSprite("red-down"));
        orangeButton = new ColorButton(atlas.createSprite("orange-up"), atlas.createSprite("orange-down"));
        blueButton = new ColorButton(atlas.createSprite("blue-up"), atlas.createSprite("blue-down"));
        greenButton = new ColorButton(atlas.createSprite("green-up"), atlas.createSprite("green-down"));

        redButton.whenClicked(bg, redBG, "images/paddlandball/bg-red.png", app);
        orangeButton.whenClicked(bg, orangeBG, "images/paddlandball/bg-orange.png", app);
        blueButton.whenClicked(bg, blueBG, "images/paddlandball/bg-blue.png", app);
        greenButton.whenClicked(bg, greenBg, "images/paddlandball/bg-green.png", app);

        colorButtons.add(redButton);
        colorButtons.add(orangeButton);
        colorButtons.add(blueButton);
        colorButtons.add(greenButton);
        final Runnable notBusyAnmore = new Runnable()
        {
            @Override
            public void run()
            {
                busy = false;
            }
        };

        image.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                if (enabled == false && busy == false)
                {
                    busy = true;
                    image.addAction(sequence(parallel(moveBy(0, 150, 0.4f)), run(notBusyAnmore)));
                    enabled = true;
                }
                else if (enabled && busy == false)
                {
                    busy = true;
                    image.addAction(sequence(moveBy(0, -150, 0.4f), run(notBusyAnmore)));
                    enabled = false;
                }
            }
        });
    }

    public Array<ColorButton> getColorButtons()
    {
        return colorButtons;
    }

    public Image getImage()
    {
        return image;
    }

    public void update()
    {
        redButton.getButton().setPosition(image.getX() + 25, image.getY() + 25);
        orangeButton.getButton().setPosition(image.getX() + 135, image.getY() + 25);
        blueButton.getButton().setPosition(image.getX() + 245, image.getY() + 25);
        greenButton.getButton().setPosition(image.getX() + 355, image.getY() + 25);
    }

    public void dispose()
    {
        redButton.dispose();
        orangeButton.dispose();
        blueButton.dispose();
        greenButton.dispose();
    }
}
