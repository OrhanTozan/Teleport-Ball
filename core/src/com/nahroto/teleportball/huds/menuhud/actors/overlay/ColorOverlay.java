package com.nahroto.teleportball.huds.menuhud.actors.overlay;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.nahroto.teleportball.Constants;

import javafx.scene.layout.Background;

public class ColorOverlay
{
    public static boolean enabled, busy = false;

    private Image image;
    private ColorButton redButton, orangeButton, blueButton, greenButton;
    private Array<ColorButton> colorButtons;

    public ColorOverlay(Sprite bg, Sprite redBG, Sprite orangeBG, Sprite blueBG, Sprite greenBg)
    {
        Texture texture = new Texture("images/colors/overlay.png");
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        image = new Image(texture);

        colorButtons = new Array<ColorButton>();

        redButton = new ColorButton(new Sprite(new Texture("images/colors/red-up.png")), new Sprite(new Texture("images/colors/red-down.png")));
        orangeButton = new ColorButton(new Sprite(new Texture("images/colors/orange-up.png")), new Sprite(new Texture("images/colors/orange-down.png")));
        blueButton = new ColorButton(new Sprite(new Texture("images/colors/blue-up.png")), new Sprite(new Texture("images/colors/blue-down.png")));
        greenButton = new ColorButton(new Sprite(new Texture("images/colors/green-up.png")), new Sprite(new Texture("images/colors/green-down.png")));

        redButton.whenClicked(bg, redBG, "images/paddlandball/bg-red.png");
        orangeButton.whenClicked(bg, orangeBG, "images/paddlandball/bg-orange.png");
        blueButton.whenClicked(bg, blueBG, "images/paddlandball/bg-blue.png");
        greenButton.whenClicked(bg, greenBg, "images/paddlandball/bg-green.png");

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
}
