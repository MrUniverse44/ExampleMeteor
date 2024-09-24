package me.blueslime.examplemeteor.player;

import me.blueslime.bukkitmeteor.implementation.module.AdvancedModule;
import me.blueslime.examplemeteor.player.object.GamePlayer;
import me.blueslime.bukkitmeteor.storage.StorageDatabase;
import me.blueslime.examplemeteor.utils.NotNull;

import java.util.concurrent.ConcurrentHashMap;

import java.util.Optional;
import java.util.UUID;
import java.util.Map;

public class GamePlayerService implements AdvancedModule {

    private final Map<UUID, GamePlayer> gamePlayerMap = new ConcurrentHashMap<>();

    /* In this case I'm going to use mongo */
    public GamePlayer find(@NotNull UUID uuid) {
        return gamePlayerMap.computeIfAbsent(
            uuid,
            id -> {
                /* Search this user in the database */
                Optional<GamePlayer> optional = fetch(StorageDatabase.class)
                    .loadByIdSync(
                        GamePlayer.class,
                        id.toString()
                    );
                return optional.orElseGet(() -> new GamePlayer(id));
            }
        );
    }

    public void remove(UUID uuid) {
        if (gamePlayerMap.containsKey(uuid)) {
            fetch(StorageDatabase.class).saveOrUpdateAsync(gamePlayerMap.remove(uuid));
        }
    }
}
