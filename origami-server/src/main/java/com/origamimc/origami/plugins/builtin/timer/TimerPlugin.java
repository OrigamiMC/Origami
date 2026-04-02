package com.origamimc.origami.plugins.builtin.timer;

import com.origamimc.origami.api.Origami;
import com.origamimc.origami.api.player.OrigamiPlayer;
import com.origamimc.origami.api.plugins.OrigamiPlugin;
import com.origamimc.origami.api.plugins.PluginManifest;
import com.origamimc.origami.api.server.OrigamiServer;
import net.minecraft.server.MinecraftServer;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class TimerPlugin extends OrigamiPlugin {

    private final ScheduledExecutorService executor;

    public TimerPlugin(@NonNull PluginManifest manifest) {
        super(manifest);
        executor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(@NonNull Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("TimerPlugin-Thread");
                thread.setDaemon(true);
                return thread;
            }
        });
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onEnable() {
        Origami.logger().info("Hello world from TimerPlugin");

        executor.scheduleAtFixedRate(() -> {
            long startup = OrigamiServer.get().getStartupTime();
            long now = System.currentTimeMillis();
            long passedMillis = now - startup;

            long seconds = (passedMillis / 1000) % 60;
            long minutes = (passedMillis / (1000 * 60)) % 60;
            long hours = (passedMillis / (1000 * 60 * 60)) % 60;
            long days = (passedMillis / (1000 * 60 * 60 * 24)) % 24;

            String formattedTimer = "§a§l";
            if (days > 0) formattedTimer += days + "d ";
            if (hours > 0) formattedTimer += hours + "h ";
            if (minutes > 0) formattedTimer += minutes + "m ";
            if (seconds > 0) formattedTimer += seconds + "s ";

            for (OrigamiPlayer player : OrigamiServer.get().getOnlinePlayers()) {
                player.sendActionBar(formattedTimer);
            }

        }, 0, 1, TimeUnit.SECONDS);

        MinecraftServer.getInstance().notificationManager().registerService(new Listener());
    }

    @Override
    public void onDisable() {

    }

}
