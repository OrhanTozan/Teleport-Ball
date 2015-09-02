package com.nahroto.teleportball.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.nahroto.teleportball.Application;

public abstract class Entity
{
    protected final Application app;

    protected static Array<Entity> entities = new Array<Entity>();

    protected Vector2 position = new Vector2();
    protected Sprite sprite;
    protected Rectangle bounds = new Rectangle();

    public Entity(Sprite sprite, final Application app)
    {
        this.app = app;
        this.sprite = sprite;
        entities.add(this);
    }

    public void setPosition(float x, float y)
    {
        position.set(x, y);
    }

    public Vector2 getPosition()
    {
        return position;
    }

    public void render(SpriteBatch batch)
    {
        batch.draw(sprite, position.x, position.y);
    }

    public void dispose()
    {
        sprite.getTexture().dispose();
    }
}
