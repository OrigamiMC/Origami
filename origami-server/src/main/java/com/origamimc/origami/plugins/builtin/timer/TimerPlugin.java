package com.origamimc.origami.plugins.builtin.timer;

import com.origamimc.origami.api.Origami;
import com.origamimc.origami.api.player.OrigamiPlayer;
import com.origamimc.origami.api.plugins.OrigamiPlugin;
import com.origamimc.origami.api.plugins.PluginManifest;
import com.origamimc.origami.api.server.OrigamiServer;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.*;

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

        executor.schedule(() -> {
            for (OrigamiPlayer player : OrigamiServer.get().getOnlinePlayers()) {
                player.sendMessage("§6You entity id is: " + player.getEntityID());
            }
        }, 20, TimeUnit.SECONDS);
    }

    @Override
    public void onDisable() {

    }

}
