package me.joran.politietools.commands;

import me.joran.politietools.commands.subcommands.HelpSubCommand;
import me.joran.politietools.manager.FileManager;
import me.joran.politietools.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PolitieToolsCommand implements CommandExecutor {

    HelpSubCommand help = new HelpSubCommand();

    private String perm = FileManager.get("config.yml").getString("permissions.main");

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if (player.hasPermission(perm)) {
            if (args.length == 0) {
                player.sendMessage(ChatUtils.format("&7&l-----------------------"));
                player.sendMessage(ChatUtils.format("&c&lAliases: &6&l[plt, politie, politietools]"));
                player.sendMessage(ChatUtils.format("&c&lGebruik /politietools <help> [category] : &6&lVoor de help lijst."));
                player.sendMessage(ChatUtils.format("&7&l-----------------------"));
            } else {
                switch (args[0]) {
                    case "help":
                        this.help.onCommand(sender, label, args);
                        break;
                    default:
                        player.sendMessage(ChatUtils.format("&7&l-----------------------"));
                        player.sendMessage(ChatUtils.format("&c&lAliases: &6&l[plt, politie, politietools]"));
                        player.sendMessage(ChatUtils.format(ChatUtils.getPrefix() + "&c&lGebruik /politietools <help> [category] : &6&lVoor de help lijst."));
                        player.sendMessage(ChatUtils.format("&7&l-----------------------"));
                }
            }
        } else {

            String geenperm = FileManager.get("messages.yml").getString("geen-permissions-message").replace("{prefix}", ChatUtils.getPrefix());

            player.sendMessage(ChatUtils.getPrefix() + ChatUtils.format(geenperm));
        }

        return false;
    }
}
