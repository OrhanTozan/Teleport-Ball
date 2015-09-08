package com.nahroto.teleportball;

public interface AdsController
{
    public boolean isWifiConnected();
    public void showInterstitialAd (Runnable then);
}
