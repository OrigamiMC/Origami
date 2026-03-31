package com.origamimc.origami.plugins;

import com.origamimc.origami.api.Origami;
import com.origamimc.origami.api.plugins.OrigamiPlugin;
import com.origamimc.origami.api.plugins.PluginManifest;
import com.origamimc.origami.api.plugins.PluginService;
import com.origamimc.origami.api.plugins.PluginState;
import com.origamimc.origami.plugins.builtin.timer.TimerPlugin;
import de.oliver.fancyanalytics.logger.properties.StringProperty;

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
    }

    public void loadPlugins() {
        for (OrigamiPlugin plugin : plugins.values()) {
            Origami.logger().info(
                    "Loading the " + plugin.getManifest().name() + " plugin",
                    StringProperty.of("plugin", plugin.getManifest().name()),
                    StringProperty.of("version", plugin.getManifest().version())
            );

            plugin.load();

            Origami.logger().info(
                    "Loaded the " + plugin.getManifest().name() + " plugin",
                    StringProperty.of("plugin", plugin.getManifest().name()),
                    StringProperty.of("version", plugin.getManifest().version())
            );
        }
    }

    public void enablePlugins() {
        for (OrigamiPlugin plugin : plugins.values()) {
            if (plugin.getState() != PluginState.LOADED) {
                continue;
            }

            Origami.logger().info(
                    "Enabling the " + plugin.getManifest().name() + " plugin",
                    StringProperty.of("plugin", plugin.getManifest().name()),
                    StringProperty.of("version", plugin.getManifest().version())
            );

            plugin.enable();

            Origami.logger().info(
                    "Enabled the " + plugin.getManifest().name() + " plugin",
                    StringProperty.of("plugin", plugin.getManifest().name()),
                    StringProperty.of("version", plugin.getManifest().version())
            );
        }
    }

    public void disablePlugins() {
        for (OrigamiPlugin plugin : plugins.values()) {
            if (plugin.getState() != PluginState.ENABLED) {
                continue;
            }

            Origami.logger().info(
                    "Disabling the " + plugin.getManifest().name() + " plugin",
                    StringProperty.of("plugin", plugin.getManifest().name()),
                    StringProperty.of("version", plugin.getManifest().version())
            );

            plugin.disable();

            Origami.logger().info(
                    "Disabled the " + plugin.getManifest().name() + " plugin",
                    StringProperty.of("plugin", plugin.getManifest().name()),
                    StringProperty.of("version", plugin.getManifest().version())
            );
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
