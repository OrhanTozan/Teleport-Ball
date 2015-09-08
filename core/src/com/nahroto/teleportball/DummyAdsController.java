package com.nahroto.teleportball;

public class DummyAdsController implements AdsController
{

    @Override
    public boolean isWifiConnected()
    {
        return false;
    }

    @Override
    public void showInterstitialAd(Runnable then)
    {

    }
}
