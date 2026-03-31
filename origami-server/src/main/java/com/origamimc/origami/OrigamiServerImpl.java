package com.origamimc.origami;

import com.origamimc.origami.api.Origami;
import com.origamimc.origami.plugins.PluginServiceImpl;

public class OrigamiServerImpl {

    /**
     * Called right when the server boots up
     */
    public void onBoot() {
        Origami.logger().info("Booting Origami ...");

        Origami.logger().info("Successfully booted Origami");
    }

    /**
     * Called before worlds are being loaded
     */
    public void onPrepareLevels() {
        PluginServiceImpl.get().loadFromPluginsFolder();
    }

    /**
     * Called when the server is starting
     */
    public void onServerStarting() {

    }

    /**
     * Called when the server is started
     */
    public void onServerStarted() {
        Origami.logger().info("Starting Origami ...");

        PluginServiceImpl.get().enablePlugins();

        Origami.logger().info("Successfully started Origami");
    }

    /**
     * Called when the server is stopping
     */
    public void onServerStopping() {

    }

    /**
     * Called when the server is stopped
     */
    public void onServerStopped() {

    }

}
