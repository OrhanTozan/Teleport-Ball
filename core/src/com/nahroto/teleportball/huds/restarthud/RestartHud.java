package com.nahroto.teleportball.huds.restarthud;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nahroto.teleportball.Constants;
import com.nahroto.teleportball.entities.Ball;
import com.nahroto.teleportball.entities.Player;
import com.nahroto.teleportball.huds.Hud;
import com.nahroto.teleportball.huds.restarthud.actors.GameOverLabel;
import com.nahroto.teleportball.huds.restarthud.actors.HighScore;
import com.nahroto.teleportball.huds.restarthud.actors.RestartButton;
import com.nahroto.teleportball.huds.restarthud.actors.Score;

public class RestartHud extends Hud
{
    private GameOverLabel gameOverLabel;
    private RestartButton restartButton;
    private Score score;
    private HighScore highScore;

    public RestartHud(Viewport viewport, SpriteBatch batch, final Player player, final Ball ball)
    {
        super(viewport, batch);
        gameOverLabel = new GameOverLabel();
        restartButton = new RestartButton(player, ball);
        score = new Score();
        highScore = new HighScore();

        gameOverLabel.getLabel().setPosition(Constants.V_WIDTH / 2, Constants.V_HEIGHT / 2 + 350, Align.center);
        restartButton.getButton().setPosition(Constants.V_WIDTH / 2, Constants.V_HEIGHT / 2, Align.center);
        score.getLabel().setPosition(Constants.V_WIDTH / 2, Constants.V_HEIGHT / 2 - 300, Align.center);
        highScore.getLabel().setPosition(Constants.V_WIDTH / 2, Constants.V_HEIGHT / 2 - 500, Align.center);

        actors.add(gameOverLabel.getLabel());
        actors.add(restartButton.getButton());
        actors.add(score.getLabel());
        actors.add(highScore.getLabel());

        addAllActorsToStage();
    }

    public Score getScore()
    {
        return score;
    }

    public HighScore getHighScore()
    {
        return highScore;
    }
}