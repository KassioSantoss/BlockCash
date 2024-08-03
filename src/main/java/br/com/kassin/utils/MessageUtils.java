package br.com.kassin.utils;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import static net.md_5.bungee.api.ChatMessageType.ACTION_BAR;

public class MessageUtils {

    public static class Chat {
        public static String sendMessage(Player player, String message) {
            return ChatColor.translateAlternateColorCodes('&', message);
        }
    }

    public static class ActionBar {
        public static void sendActionBar(Player player, String message) {
            player.spigot().sendMessage(ACTION_BAR, new TextComponent(
                    ChatColor.translateAlternateColorCodes('&', message)));
        }
    }

}
