package com.origamimc.origami.plugins.builtin.timer;

import com.origamimc.origami.api.Origami;
import com.origamimc.origami.api.plugins.OrigamiPlugin;
import com.origamimc.origami.api.plugins.PluginManifest;
import org.jspecify.annotations.NonNull;

public class TimerPlugin extends OrigamiPlugin {

    public TimerPlugin(@NonNull PluginManifest manifest) {
        super(manifest);
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onEnable() {
        Origami.logger().info("Hello world from TimerPlugin");
    }

    @Override
    public void onDisable() {

    }

}
