package com.origamimc.origami;

import com.origamimc.origami.api.Origami;
import com.origamimc.origami.api.player.OrigamiPlayer;
import com.origamimc.origami.api.server.OrigamiServer;
import com.origamimc.origami.plugins.PluginServiceImpl;
import de.oliver.fancyanalytics.logger.properties.ThrowableProperty;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrigamiServerImpl implements OrigamiServer {

    private long startupTime;
    private MinecraftServer handle;

    /**
     * Called right when the server boots up
     */
    public void onBoot() {
        try {
            startupTime = System.currentTimeMillis();

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
            handle = MinecraftServer.getInstance();
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

    @Override
    public long getStartupTime() {
        return startupTime;
    }

    @Override
    public Optional<OrigamiPlayer> getPlayerByName(String username) {
        ServerPlayer serverPlayer = handle.getPlayerList().getPlayer(username);
        return serverPlayer != null ?
                Optional.of(serverPlayer.getOrigamiPlayer()) :
                Optional.empty();
    }

    @Override
    public Optional<OrigamiPlayer> getPlayerByUUID(UUID uuid) {
        ServerPlayer serverPlayer = handle.getPlayerList().getPlayer(uuid);
        return serverPlayer != null ?
                Optional.of(serverPlayer.getOrigamiPlayer()) :
                Optional.empty();
    }

    @Override
    public List<OrigamiPlayer> getOnlinePlayers() {
        List<OrigamiPlayer> onlinePlayers = new ArrayList<>();

        for (ServerPlayer serverPlayer : handle.getPlayerList().getPlayers()) {
            onlinePlayers.add(serverPlayer.getOrigamiPlayer());
        }

        return onlinePlayers;
    }

    @Override
    public String getMotd() {
        return handle.getMotd();
    }

    @Override
    public void setMotd(String motd) {
        handle.setMotd(motd);
    }
}
