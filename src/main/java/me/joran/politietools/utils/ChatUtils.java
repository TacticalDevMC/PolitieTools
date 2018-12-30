package me.joran.politietools.utils;

import me.joran.politietools.manager.FileManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatUtils {

    public static String format(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String prefix = FileManager.get("config.yml").get("prefix").toString().replace("&", "§");

    public static void sendMessage(Player player, String message) {
        player.sendMessage(prefix + format(message));
    }
}
