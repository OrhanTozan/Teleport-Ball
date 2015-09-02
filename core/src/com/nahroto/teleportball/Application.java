package com.nahroto.teleportball;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nahroto.teleportball.screens.LoadingScreen;


public class Application extends Game
{
	public SpriteBatch batch;
	public OrthographicCamera camera;
	public AssetManager assets;
    public Viewport viewport;
	
	@Override
	public void create()
    {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		assets = new AssetManager();
        viewport = new FitViewport(Constants.V_WIDTH, Constants.V_HEIGHT, camera);
		setScreen(new LoadingScreen(this));
	}

	@Override
	public void dispose()
	{
		batch.dispose();
		assets.dispose();
	}
}
