package me.joran.politietools.commands.subcommands;

import me.joran.politietools.manager.FileManager;
import me.joran.politietools.utils.ChatUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Help {


    public void onCommand(CommandSender sender, String label, String[] args) {
        Player player = (Player) sender;

        if (args.length == 1) {
            player.sendMessage(ChatUtils.prefix + ChatUtils.format("&c&lGebruik /help <command>"));
        } else {
            if (args[1].equalsIgnoreCase("112")) {
                player.sendMessage(ChatUtils.format("&7&m------------------"));
                player.sendMessage(ChatUtils.format("&3&lGebruik: &6&l/112 <bericht>."));
                player.sendMessage(ChatUtils.format("&3&lDescription: &6&lStuur een bericht naar alle mensen met de prefix " + FileManager.get("config.yml").get("meldingingen-krijg-prefix") + "."));
                player.sendMessage(ChatUtils.format("&3&lAliases: &6&l[100, 101, 102]"));
                player.sendMessage(ChatUtils.format("&7&m------------------"));
            }
        }
    }
}
