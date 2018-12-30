package me.joran.politietools.events;

import me.joran.politietools.utils.ChatUtils;
import nl.minetopiasdb.api.SDBPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onPlayerJoinQuitEvent implements Listener {

    @EventHandler
    public void joinGame(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        String nummer = SDBPlayer.createSDBPlayer(player.getUniqueId()).getPhoneNumber();

        if (nummer.equals("none")) {
            player.sendMessage(ChatUtils.format(ChatUtils.prefix + "&3U hebt geen telefoon nummer."));
        } else {
            player.sendMessage(ChatUtils.format(ChatUtils.prefix + "&3Uw telefoon nummer is " + nummer));
        }
    }
}
