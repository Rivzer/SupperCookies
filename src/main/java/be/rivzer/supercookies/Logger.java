package be.rivzer.supercookies;

import net.md_5.bungee.api.ChatColor;

public class Logger {

    public static String color(String message) {

        return ChatColor.translateAlternateColorCodes('&', message);

    }
}