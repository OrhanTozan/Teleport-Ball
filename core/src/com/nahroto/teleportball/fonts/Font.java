package com.nahroto.teleportball.fonts;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Font
{
    private BitmapFont font;
    private GlyphLayout layout = new GlyphLayout();
    private FreeTypeFontGenerator generator;
    private FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

    private float width;
    private float height;

    private int size;
    private Color color;

    public Font(String filePath, int size, Color color, boolean filter)
    {
        // ASSIGN ATTRIBUTES
        this.size = size;
        this.color = color;

        // GENERATE FONT
        generator = new FreeTypeFontGenerator(Gdx.files.internal(filePath));
        if (filter) // IF FILTER ENABLED
        {
            parameter.genMipMaps = true;
            parameter.minFilter = Texture.TextureFilter.Linear;
            parameter.magFilter = Texture.TextureFilter.Linear;
        }
        parameter.size = size;
        parameter.color = color;
        font = generator.generateFont(parameter);
        generator.dispose();
    }

    public void render(SpriteBatch batch, String text, float x, float y, boolean center)
    {
        if (center)
        {
            x -= getWidth(text) / 2;
            y += getHeight(text) / 2;
        }

        font.draw(batch, text, x, y);
    }

    public float getWidth(String text)
    {
        layout.setText(font, text);
        width = layout.width;
        return width;
    }

    public float getHeight(String text)
    {
        layout.setText(font, text);
        height = layout.height;
        return height;
    }

    public int getSize()
    {
        return size;
    }

    public Color getColor()
    {
        return color;
    }

    public BitmapFont getFont()
    {
        return font;
    }

    public void dispose()
    {
        font.dispose();
    }
}
