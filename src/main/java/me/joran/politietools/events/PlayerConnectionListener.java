package me.joran.politietools.events;

import me.joran.politietools.manager.FileManager;
import me.joran.politietools.utils.ChatUtils;
import nl.minetopiasdb.api.SDBPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerConnectionListener implements Listener {

    @EventHandler
    public void joinGame(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        String nummer = SDBPlayer.createSDBPlayer(player.getUniqueId()).getPhoneNumber();

        if (nummer.equals("none")) {

            String geenTelefoonNummer = FileManager.get("messages.yml").getString("geenTelefoonNummerMessage").replace("&", "§").replace("{prefix}", ChatUtils.getPrefix());
            String geentelefoonNumberOnJoinMessageEnabled = FileManager.get("config.yml").getString("Join.geenTelefoonNummerJoinMessage");

            if (geentelefoonNumberOnJoinMessageEnabled.contains("true")) {

                player.sendMessage(geenTelefoonNummer);
            }
        } else {

            String telefoonNummer = FileManager.get("messages.yml").getString("telefoonnummer-on-join").replace("&", "§").replace("{prefix}", ChatUtils.getPrefix()).replace("{nummer}", nummer);
            String telefoonNumberOnJoinMessageEnabled = FileManager.get("config.yml").getString("Join.telefoonNummerJoinMessage");

            if (telefoonNumberOnJoinMessageEnabled.contains("true")) {
                player.sendMessage(telefoonNummer);
            }
        }
    }
}
