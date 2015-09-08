package com.nahroto.teleportball;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
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
	public Preferences prefs;

	public AdsController adsController;

	public Application(AdsController adsController)
	{
		if (adsController != null)
			this.adsController = adsController;
		else
			this.adsController = new DummyAdsController();
	}

	@Override
	public void create()
    {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		assets = new AssetManager();

        viewport = new FitViewport(Constants.V_WIDTH, Constants.V_HEIGHT, camera);
		prefs = Gdx.app.getPreferences("Teleport_Ball_data");

		setScreen(new LoadingScreen(this));
	}


	@Override
	public void dispose()
	{
		batch.dispose();
		assets.dispose();
	}

	public void showAd()
	{
		if (adsController.isWifiConnected())
		{
			adsController.showInterstitialAd(new Runnable()
			{
				@Override
				public void run()
				{
					System.out.println("Interstitial app closed");
				}
			});
		}
		else
			System.out.println("Interstitial ad not (yet) loaded");
	}
}
