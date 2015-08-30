package com.nahrot.teleportball;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nahrot.teleportball.screens.GameScreen;
import com.nahrot.teleportball.screens.LoadingScreen;

public class Application extends Game
{

	public SpriteBatch batch;
	public OrthographicCamera camera;
	public AssetManager assets;
    public Viewport viewport;
	
	@Override
	public void create ()
    {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		assets = new AssetManager();
        viewport = new FitViewport(Constants.V_WIDTH, Constants.V_HEIGHT, camera);
		setScreen(new LoadingScreen(this));
	}

	@Override
	public void render ()
    {
		super.render();
	}
}
