package com.nahrot.teleportball.huds.menuhud.actors.overlay;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;

public class ColorOverlay
{
    private Image image;
    private ColorButton redButton, yellowButton, blueButton, greenButton;
    private Array<ColorButton> colorButtons;

    public ColorOverlay()
    {
        Texture texture = new Texture("images/colors/overlay.png");
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        image = new Image(texture);

        colorButtons = new Array<ColorButton>();

        redButton = new ColorButton(new Sprite(new Texture("images/colors/red-up.png")), new Sprite(new Texture("images/colors/red-down.png")));
        yellowButton = new ColorButton(new Sprite(new Texture("images/colors/yellow-up.png")), new Sprite(new Texture("images/colors/yellow-down.png")));
        blueButton = new ColorButton(new Sprite(new Texture("images/colors/blue-up.png")), new Sprite(new Texture("images/colors/blue-down.png")));
        greenButton = new ColorButton(new Sprite(new Texture("images/colors/green-up.png")), new Sprite(new Texture("images/colors/green-down.png")));

        colorButtons.add(redButton);
        colorButtons.add(yellowButton);
        colorButtons.add(blueButton);
        colorButtons.add(greenButton);
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
        redButton.getButton().setPosition(image.getX() + 25, image.getY() + 20);
        yellowButton.getButton().setPosition(image.getX() + 135, image.getY() + 20);
        blueButton.getButton().setPosition(image.getX() + 245, image.getY() + 20);
        greenButton.getButton().setPosition(image.getX() + 355, image.getY() + 20);
    }
}
