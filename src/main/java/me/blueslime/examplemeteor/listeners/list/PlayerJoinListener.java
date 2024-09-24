package me.blueslime.examplemeteor.listeners.list;

import me.blueslime.bukkitmeteor.implementation.module.AdvancedModule;
import me.blueslime.examplemeteor.player.GamePlayerService;
import me.blueslime.examplemeteor.player.object.GamePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements AdvancedModule, Listener {

    @EventHandler
    public void on(PlayerJoinEvent event) {

        GamePlayer gamePlayer = fetch(GamePlayerService.class).find(event.getPlayer().getUniqueId());

        if (gamePlayer.isFromPeru()) {
            event.getPlayer().sendMessage("This player is from peru");
        } else {
            event.getPlayer().sendMessage("This player is not from peru, but i'm converting him to a peruvian");
            gamePlayer.setPeru(true);
        }
    }

}
