package me.blueslime.examplemeteor.player.object;

import me.blueslime.bukkitmeteor.BukkitMeteorPlugin;
import me.blueslime.bukkitmeteor.storage.interfaces.*;
import org.bukkit.entity.Player;

import java.util.UUID;

public class GamePlayer implements StorageObject {

    @StorageIdentifier
    private final String id;

    @StorageIgnore
    private UUID uuid = null;

    @StorageKey(key = "isFromPeru", defaultValue = "false")
    private boolean peru;

    @StorageConstructor
    public GamePlayer(
        @StorageKey(key = "_id") String id,
        @StorageKey(key = "isFromPeru", defaultValue = "false") boolean peru
    ) {
        this.uuid = UUID.fromString(id);
        this.peru = peru;
        this.id = id;
    }

    public GamePlayer(UUID uuid) {
        this.uuid = uuid;
        this.id = uuid.toString();
    }

    /* This player is from peru */
    public void setPeru(boolean peru) {
        this.peru = peru;
    }

    public UUID getUniqueId() {
        if (uuid == null) {
            uuid = UUID.fromString(id);
        }
        return uuid;
    }

    public boolean isFromPeru() {
        return peru;
    }

    public Player toBukkitPlayer() {
        return fetch(BukkitMeteorPlugin.class)
            .getServer()
            .getPlayer(getUniqueId());
    }
}
