package com.origamimc.origami;

public class OrigamiServerImpl {

    /**
     * Called right when the server boots up
     */
    public void onBoot() {
        System.out.println("BOOTING SERVER ...");
    }

    /**
     * Called before worlds are being loaded
     */
    public void onPrepareLevels() {
        System.out.println("PREPARING LEVELS ...");
    }

    /**
     * Called when server is started
     */
    public void onServerStarted() {
        System.out.println("STARTED SERVER ...");
    }

}
