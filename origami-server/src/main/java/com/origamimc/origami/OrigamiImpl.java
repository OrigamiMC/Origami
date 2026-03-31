package com.origamimc.origami;

import com.origamimc.origami.api.Origami;
import com.origamimc.origami.api.plugins.PluginService;
import com.origamimc.origami.plugins.PluginServiceImpl;
import de.oliver.fancyanalytics.logger.ExtendedFancyLogger;
import de.oliver.fancyanalytics.logger.LogLevel;
import de.oliver.fancyanalytics.logger.appender.ConsoleAppender;
import de.oliver.fancyanalytics.logger.appender.JsonAppender;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrigamiImpl implements Origami {

    private final ExtendedFancyLogger logger;
    private final OrigamiServerImpl server;
    private final PluginServiceImpl pluginService;

    public static OrigamiImpl get() {
        return (OrigamiImpl) Origami.get();
    }

    public OrigamiImpl() {
        ConsoleAppender consoleAppender = new ConsoleAppender("[{loggerName}] [{timestamp}] [{threadName}] [{logLevel}]: {message}");
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
        File logsFile = new File("logs/origami/" + date + ".txt");
        if (!logsFile.exists()) {
            try {
                logsFile.getParentFile().mkdirs();
                logsFile.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        JsonAppender jsonAppender = new JsonAppender(false, false, true, logsFile.getPath());

        this.logger = new ExtendedFancyLogger(
                "Origami",
                LogLevel.DEBUG,
                List.of(consoleAppender, jsonAppender),
                List.of()
        );

        this.server = new OrigamiServerImpl();
        this.pluginService = new PluginServiceImpl();
    }

    @Override
    public ExtendedFancyLogger getLogger() {
        return logger;
    }

    @Override
    public PluginService getPluginService() {
        return pluginService;
    }

    public OrigamiServerImpl getServer() {
        return server;
    }
}
