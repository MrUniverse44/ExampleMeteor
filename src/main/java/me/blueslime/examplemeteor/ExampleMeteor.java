package me.blueslime.examplemeteor;

import me.blueslime.bukkitmeteor.implementation.module.Module;
import me.blueslime.bukkitmeteor.BukkitMeteorPlugin;
import me.blueslime.bukkitmeteor.storage.type.MongoDatabaseService;
import me.blueslime.examplemeteor.listeners.ListenerService;
import me.blueslime.examplemeteor.player.GamePlayerService;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public final class ExampleMeteor extends BukkitMeteorPlugin {

    /**
     * Use here the {@link #initialize(Object)} method to load the entire plugin data.
     * or use {@link #initialize(Object, boolean, boolean)}
     */
    @Override
    public void onEnable() {
        initialize(
            this,
            false,
            true
        );
    }

    /**
     * Here you can use the {@link #registerModule(Module...)} or {@link #registerModule(Class[])}
     * This method is automatically used internally.
     */
    @Override
    public void registerModules() {
        registerModule(
            GamePlayerService.class,
            ListenerService.class
        ).finish();
    }

    /**
     * Here is the database registration
     */
    @Override
    public void registerDatabases() {
        FileConfiguration configuration = load(
            new File(getDataFolder(), "databases.yml"),
          "databases.yml"
        );

        registerDatabase(
            new MongoDatabaseService(
                configuration.getString("mongo.uri", ""),
                configuration.getString("mongo.database", "examplemeteor"),
                true
            )
        );
    }
}
