package com.origamimc.origami.plugins;

import com.origamimc.origami.api.Origami;
import com.origamimc.origami.api.plugins.OrigamiPlugin;
import com.origamimc.origami.api.plugins.PluginManifest;
import com.origamimc.origami.api.plugins.PluginService;
import com.origamimc.origami.plugins.builtin.timer.TimerPlugin;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class PluginServiceImpl implements PluginService {

    public static PluginServiceImpl get() {
        return (PluginServiceImpl) Origami.get().getPluginService();
    }

    public final Map<String, OrigamiPlugin> plugins;

    public PluginServiceImpl() {
        this.plugins = new ConcurrentHashMap<>();
    }

    public void loadFromPluginsFolder() {
        TimerPlugin timerPlugin = new TimerPlugin(new PluginManifest("timer", "1.0.0", "com.origamimc.origami.plugins.builtin.timer.TimerPlugin"));
        plugins.put(timerPlugin.getManifest().name(), timerPlugin);

        for (OrigamiPlugin plugin : plugins.values()) {
            plugin.load();
        }
    }

    public void enablePlugins() {
        for (OrigamiPlugin plugin : plugins.values()) {
            plugin.enable();
        }
    }

    public void disablePlugins() {
        for (OrigamiPlugin plugin : plugins.values()) {
            plugin.disable();
        }
    }

    @Override
    public Optional<OrigamiPlugin> getPlugin(String name) {
        return Optional.ofNullable(plugins.get(name));
    }

    @Override
    public List<OrigamiPlugin> getPlugins() {
        return List.copyOf(plugins.values());
    }
}
