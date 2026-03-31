package com.origamimc.origami;

import com.origamimc.origami.api.Origami;
import com.origamimc.origami.plugins.PluginServiceImpl;
import de.oliver.fancyanalytics.logger.properties.ThrowableProperty;

public class OrigamiServerImpl {

    /**
     * Called right when the server boots up
     */
    public void onBoot() {
        try {
            PluginServiceImpl.get().loadFromPluginsFolder();
            Origami.logger().info("Scanned all plugins from plugins folder");
        } catch (Exception e) {
            Origami.logger().error("Unexpected exception in onBoot", new ThrowableProperty(e));
        }
    }

    /**
     * Called before worlds are being loaded
     */
    public void onPrepareLevels() {
        try {

        } catch (Exception e) {
            Origami.logger().error("Unexpected exception in onPrepareLevels", new ThrowableProperty(e));
        }
    }

    /**
     * Called when the server is starting
     */
    public void onServerStarting() {
        try {
            PluginServiceImpl.get().loadPlugins();
            Origami.logger().info("Loaded all origami plugins");
        } catch (Exception e) {
            Origami.logger().error("Unexpected exception in onServerStarting", new ThrowableProperty(e));
        }
    }

    /**
     * Called when the server is started
     */
    public void onServerStarted() {
        try {
            PluginServiceImpl.get().enablePlugins();
            Origami.logger().info("Enabled all origami plugins");
        } catch (Exception e) {
            Origami.logger().error("Unexpected exception in onServerStarted", new ThrowableProperty(e));
        }

    }

    /**
     * Called when the server is stopping
     */
    public void onServerStopping() {
        try {
            PluginServiceImpl.get().disablePlugins();
            Origami.logger().info("Disabled all origami plugins");
        } catch (Exception e) {
            Origami.logger().error("Unexpected exception in onServerStopping", new ThrowableProperty(e));
        }
    }

    /**
     * Called when the server is stopped
     */
    public void onServerStopped() {
        try {

        } catch (Exception e) {
            Origami.logger().error("Unexpected exception in onServerStopped", new ThrowableProperty(e));
        }
    }

}
