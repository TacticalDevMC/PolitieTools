package me.joran.politietools;

import me.joran.politietools.commands.Politie112Command;
import me.joran.politietools.commands.PolitieToolsCommand;
import me.joran.politietools.events.onPlayerJoinQuitEvent;
import me.joran.politietools.manager.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class PolitieTools extends JavaPlugin {

    private static PolitieTools instance;

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getConsoleSender().sendMessage("§a§lThe PolitieTools has been enabled.");

        registerCommands();
        registerEvents(getServer().getPluginManager());

        FileManager.load(this, "config.yml");
        FileManager.load(this, "messages.yml");

        // || getServer().getPluginManager().getPlugin("MinetopiaSDB") == null //

        if (!getServer().getPluginManager().isPluginEnabled("MinetopiaSDB")) {
            getLogger().log(Level.SEVERE, "MinetopiaSDB plugin niet gevonden. Deze zit niet in de server, of is niet enabled!");
            getServer().getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§4§lThe PolitieTools has been disabled.");
    }

    public static PolitieTools getInstance() {
        return instance;
    }

    private void registerCommands() {
        getCommand("politietools").setExecutor(new PolitieToolsCommand());
        getCommand("112").setExecutor(new Politie112Command());
    }

    private void registerEvents(PluginManager pm) {
        pm.registerEvents(new onPlayerJoinQuitEvent(), this);
    }
}
