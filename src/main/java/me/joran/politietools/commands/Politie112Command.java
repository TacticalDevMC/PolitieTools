package me.joran.politietools.commands;

import me.joran.politietools.manager.FileManager;
import me.joran.politietools.utils.ChatUtils;
import nl.minetopiasdb.api.SDBPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Politie112Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("112")) {
            if (args.length == 0) {
                player.sendMessage(ChatUtils.format("&7&m-------------"));
                player.sendMessage(ChatUtils.format("&c&lAliasesMainCommand: &6&l[plt, politie]"));
                player.sendMessage(ChatUtils.format("&c&lGebruik: &6&l/politietools help 112"));
                player.sendMessage(ChatUtils.format("&7&m-------------"));
                return false;
            }

            StringBuilder bericht = new StringBuilder();
            for(int i = 0; i < args.length; i++) {
                if (i > 0) bericht.append(" ");
                bericht.append(args[i]);
            }

            String playerName = player.getName();
            UUID playerUuid = player.getUniqueId();

            Location loc = player.getLocation();

            World world = loc.getWorld();
            double x = loc.getX();
            double y = loc.getY();
            double z = loc.getZ();

            for (Player allPlayersWithPrefix : Bukkit.getServer().getOnlinePlayers()) {
                String hasPrefix = SDBPlayer.createSDBPlayer(allPlayersWithPrefix.getUniqueId()).getPrefix();

                if (hasPrefix.equalsIgnoreCase(FileManager.get("config.yml").get("meldingingen-krijg-prefix").toString())) {
                    allPlayersWithPrefix.sendMessage(ChatUtils.format("&7&m------------&3&lBERICHT VOOR POLITIE&7&m-----------------"));
                    allPlayersWithPrefix.sendMessage(ChatUtils.format("&9&lGebruiker: &b&l" + playerName));
                    allPlayersWithPrefix.sendMessage(ChatUtils.format("&9&lUuid: &b&l" + playerUuid));
                    allPlayersWithPrefix.sendMessage(ChatUtils.format("&9&lBericht: &b&l" + bericht));
                    allPlayersWithPrefix.sendMessage(ChatUtils.format("&9&lLocatie: &b&lX:&3 " + x + " &b&lY:&3 " + y + " &b&lZ&3 " + z));
                    allPlayersWithPrefix.sendMessage(ChatUtils.format("&9&lWereld: &b&l" + world.getName()));
                    allPlayersWithPrefix.sendMessage(ChatUtils.format("&7&m------------&3&lBERICHT VOOR POLITIE&7&m-----------------"));
                }
            }

            player.sendMessage(ChatUtils.format("&7&m------------&a&lSUCCESVOL&7&m-----------------"));
            player.sendMessage(ChatUtils.format("&b&lBericht: &7&l" + bericht));
            player.sendMessage(ChatUtils.format("&7&m------------&a&lSUCCESVOL&7&m-----------------"));
//            player.sendMessage(ChatUtils.prefix + ChatUtils.format("&7&lUw bericht *" + bericht + "* is verzonden."));

        }

        return false;
    }
}
