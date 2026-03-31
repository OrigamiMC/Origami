package com.origamimc.origami.api;

import com.origamimc.origami.api.plugins.PluginService;
import de.oliver.fancyanalytics.logger.ExtendedFancyLogger;

public interface Origami {

    static Origami get() {
        return OrigamiInstanceHolder.getInstance();
    }

    static ExtendedFancyLogger logger() {
        return get().getLogger();
    }

    ExtendedFancyLogger getLogger();

    PluginService getPluginService();

}
