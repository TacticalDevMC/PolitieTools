package me.joran.politietools.utils;

import me.joran.politietools.manager.FileManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatUtils {

    private static String prefix = FileManager.get("config.yml").getString("prefix");

    public static String format(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static void sendMessage(Player player, String message) {
        player.sendMessage(prefix + format(message));
    }

    public static String getPrefix() {
        return prefix;
    }

}
