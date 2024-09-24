package me.blueslime.examplemeteor.command;

import me.blueslime.bukkitmeteor.commands.InjectedCommand;
import me.blueslime.bukkitmeteor.libs.utilitiesapi.commands.sender.Sender;

public class ExampleCommand extends InjectedCommand {
    @Override
    public void executeCommand(Sender sender, String label, String[] args) {
        sender.send("&aYou are awesome!");
    }
}
