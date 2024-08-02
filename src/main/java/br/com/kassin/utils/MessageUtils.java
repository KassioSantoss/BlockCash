package br.com.kassin.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatUtils {

    public static String sendMessage(Player player, String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}
