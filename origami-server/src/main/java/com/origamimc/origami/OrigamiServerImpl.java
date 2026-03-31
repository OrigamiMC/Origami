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
     * Called when server is started
     */
    public void onServerStarted() {
        Origami.logger().info("Starting Origami ...");

        PluginServiceImpl.get().enablePlugins();

        Origami.logger().info("Successfully started Origami");
    }

}
