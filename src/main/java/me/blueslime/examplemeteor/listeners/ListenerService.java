package me.blueslime.examplemeteor.listeners;

import me.blueslime.bukkitmeteor.implementation.module.AdvancedModule;
import me.blueslime.examplemeteor.listeners.list.PlayerJoinListener;
import me.blueslime.examplemeteor.listeners.list.PlayerQuitListener;

public class ListenerService implements AdvancedModule {

    @Override
    public void initialize() {
        registerAll(
            createInstance(PlayerJoinListener.class),
            createInstance(PlayerQuitListener.class)
        );
    }
}
