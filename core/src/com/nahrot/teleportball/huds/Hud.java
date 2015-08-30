package com.nahrot.teleportball.huds;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;


public class Hud
{
    protected Stage stage;
    protected Array<Actor> actors;


    public Hud(Viewport viewport, SpriteBatch batch)
    {
        stage = new Stage(viewport, batch);
        actors = new Array<Actor>();
    }


    public void addActorsToStage()
    {
        for (Actor actor : actors)
        {
            stage.addActor(actor);
        }
    }

    public void removeActorsFromStage()
    {
        for (Actor actor : stage.getActors())
        {
            actor.remove();
        }
    }

    public void update(float delta)
    {
        stage.act(delta);
    }

    public void render()
    {
        stage.draw();
    }

}