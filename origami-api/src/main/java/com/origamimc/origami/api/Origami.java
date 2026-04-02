package com.origamimc.origami.api;

import com.origamimc.origami.api.plugins.PluginService;
import com.origamimc.origami.api.server.OrigamiServer;
import de.oliver.fancyanalytics.logger.ExtendedFancyLogger;

public interface Origami {

    static Origami get() {
        return OrigamiInstanceHolder.getInstance();
    }

    static ExtendedFancyLogger logger() {
        return get().getLogger();
    }

    ExtendedFancyLogger getLogger();

    OrigamiServer getServer();

    PluginService getPluginService();

}
