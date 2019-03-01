package me.joran.politietools.commands.subcommands;

import me.joran.politietools.manager.FileManager;
import me.joran.politietools.utils.ChatUtils;
import me.joran.politietools.utils.Icon;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpSubCommand {

    private String perm = FileManager.get("config.yml").getString("permissions.help");

    public void onCommand(CommandSender sender, String label, String[] args) {
        Player player = (Player) sender;

        if (args.length == 0) {
            if (player.hasPermission(perm)) player.sendMessage(ChatUtils.format("&a" + Icon.CHECKMARK + " /112, 100, 101, 102 <bericht>"));
            if (player.hasPermission(perm)) player.sendMessage(ChatUtils.format("&a" + Icon.CHECKMARK + " /politietools <help>"));
            if (!player.hasPermission(perm)) player.sendMessage(ChatUtils.format("&c" + Icon.CROSS + " /politietools <help>"));
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
