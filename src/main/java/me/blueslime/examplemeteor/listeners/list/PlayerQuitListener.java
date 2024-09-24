package me.blueslime.examplemeteor.listeners.list;

import me.blueslime.bukkitmeteor.implementation.module.AdvancedModule;
import me.blueslime.examplemeteor.player.GamePlayerService;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements AdvancedModule, Listener {

    @EventHandler
    public void on(PlayerQuitEvent event) {
        fetch(GamePlayerService.class).remove(event.getPlayer().getUniqueId());
    }

}
