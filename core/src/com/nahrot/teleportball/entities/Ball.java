package com.nahrot.teleportball.entities;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.nahrot.teleportball.Application;
import com.nahrot.teleportball.Constants;
import com.nahrot.teleportball.huds.restarthud.actors.Score;

public class Ball extends Entity
{
    private final int SCORE_MULTIPLIER = 40;

    private Vector2 velocity = new Vector2();
    private Vector2 baseVelocity = new Vector2();
    private Sound kick = app.assets.get("sounds/kick.wav", Sound.class);
    private Sound a1 = app.assets.get("sounds/a1.mp3", Sound.class);
    private Sound a2 = app.assets.get("sounds/a2.mp3", Sound.class);
    private Sound rip = app.assets.get("sounds/rip.wav", Sound.class);
    public static boolean died;

    public Ball(Sprite sprite, final Application app)
    {
        super(sprite, app);
        velocity.set(MathUtils.random(-500, 500), 500);
        baseVelocity.set(500, 500);
        position.set(Constants.V_WIDTH / 2 - sprite.getWidth() / 2, Constants.V_HEIGHT / 2 - sprite.getHeight() / 2);
        sprite.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        bounds.set(position.x, position.y, sprite.getWidth(), sprite.getHeight());
    }

    public void update(float delta, Player player)
    {
        updateBallVelocity();
        applyVelocityToPosition(delta);
        bounds.setPosition(position);
        handleCollision(player);
    }

    private void updateBallVelocity()
    {
        if (velocity.y > 0) // if velocity.y is positive
        {
            velocity.y = baseVelocity.y + (Score.value * SCORE_MULTIPLIER);
        } else if (velocity.y < 0) // else if velocity.y is negative
        {
            velocity.y = -baseVelocity.y - (Score.value * SCORE_MULTIPLIER);
        }
    }

    private void applyVelocityToPosition(float delta)
    {
        velocity.scl(delta);
        position.add(velocity);
        velocity.scl(1 / delta);
    }

    private void handleCollision(Player player)
    {
        // HANDLE BALL-SCREEN COLLISION
        if ((position.x < 0 && velocity.x < 0) || (position.x + sprite.getWidth() > Constants.V_WIDTH && velocity.x > 0)) // if ball goes out of left or right bounds
        {
            kick.play(); // PLAY KICK SFX
            if (velocity.x < 0) position.x = 0;
            else if (velocity.x > 0) position.x = Constants.V_WIDTH - sprite.getWidth();
            velocity.x *= -1;
        }

        if (position.y < 0 && velocity.y < 0) // IF BALL IS UNDER BOTTOM BOUND
        {
            if (player.isBottom) // IF BALL IS UNDER BOTTOM BOUND AND PLAYER IS BOTTOM
            {
                rip.play();
                died = true;
            }

            else // IF BALL IS UNDER BOTTOM BOUND AND PLAYER IS TOP
            {
                kick.play(); // play kick sfx
                velocity.y *= -1;
            }
        }

        else if (position.y + sprite.getHeight() > Constants.V_HEIGHT && velocity.y > 0) // IF BALL IS ABOVE TOP BOUND
        {
            if (player.isBottom == false) // IF BALL IS ABOVE TOP BOUND AND PLAYER IS TOP
            {
                rip.play();
                died = true;
            }

            else // IF BALL IS ABOVE TOP BOUND AND PLAYER IS BOTTOM
            {
                kick.play(); // play kick sfx
                velocity.y *= -1;
            }
        }

        // HANDLE BALL-PLAYER COLLISION
        if (bounds.overlaps(player.bounds)) // IF BALL IS BETWEEN BEGIN PADDLE AND END PADDLE
        {
            if (player.isBottom) // IF PADDLE IS BOTTOM AND BALL IS TOUCHING PADDLE
            {
                position.y = player.getPosition().y + player.sprite.getHeight();
                velocity.y *= -1;
                calculateBallAngle(player);
                player.isBottom = !player.isBottom;
                Score.value++;
                a2.play();
            }
            else if (player.isBottom == false) // ELSE IF PADDLE IS TOP AND BALL IS TOUCHING PADDLE
            {
                position.y = player.position.y - sprite.getHeight();
                velocity.y *= -1;
                calculateBallAngle(player);
                player.isBottom = !player.isBottom;
                Score.value++;
                a1.play();
            }
        }
    }

    private void calculateBallAngle(Player player)
    {
        float middleOfPaddleX = player.position.x + player.sprite.getWidth() / 2;
        float middleOfBallX = position.x + sprite.getWidth() / 2;
        float deltaX = middleOfBallX - middleOfPaddleX;
        velocity.x = baseVelocity.x * (deltaX / 30);
    }

    public void reset()
    {
        position.set(Constants.V_WIDTH / 2 - sprite.getWidth() / 2, Constants.V_HEIGHT / 2 - sprite.getHeight() / 2);
        baseVelocity.set(500, 500);
        velocity.set(500, 500);
        Score.value = 0;
    }

    public boolean died()
    {
        return died;
    }
}
