package com.brov3r.playerfeed;

import com.avrix.events.EventManager;
import com.avrix.plugin.Metadata;
import com.avrix.plugin.Plugin;
import com.brov3r.playerfeed.events.OnCharacterDeathHandler;
import com.brov3r.playerfeed.events.OnPlayerConnectHandler;
import com.brov3r.playerfeed.events.OnPlayerDisconnectHandler;


/**
 * Main entry point of the example plugin
 */
public class Main extends Plugin {
    private static Main instance;

    /**
     * Constructs a new {@link Plugin} with the specified metadata.
     * Metadata is transferred when the plugin is loaded into the game context.
     *
     * @param metadata The {@link Metadata} associated with this plugin.
     */
    public Main(Metadata metadata) {
        super(metadata);
    }

    /**
     * Called when the plugin is initialized.
     * <p>
     * Implementing classes should override this method to provide the initialization logic.
     */
    @Override
    public void onInitialize() {
        instance = this;
        loadDefaultConfig();

        EventManager.addListener(new OnPlayerDisconnectHandler());
        EventManager.addListener(new OnPlayerConnectHandler());
        EventManager.addListener(new OnCharacterDeathHandler());
    }

    /**
     * Getting a plugin instance
     * @return plugin instance
     */
    public static Main getInstance(){
        return instance;
    }
}