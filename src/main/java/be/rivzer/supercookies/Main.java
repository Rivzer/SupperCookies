package be.rivzer.supercookies;

import be.rivzer.supercookies.Commands.Cookie;
import be.rivzer.supercookies.Config.Config;
import be.rivzer.supercookies.Listeners.PlayerInteract;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        //Console
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

        //Configs
        Config.createCustomConfig1();
        Config.createCustomConfig2();
        Config.createCustomConfig3();

        //Commands
        new Cookie(this);

        //Listener
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerInteract(), this);

        //Metrics
        Metrics metrics = new Metrics(this, 12369);

        console.sendMessage(Logger.color("&f----------------------------------------"));
        console.sendMessage(Logger.color(""));
        console.sendMessage(Logger.color("&dPlugin wordt aangezettt..."));
        console.sendMessage(Logger.color(""));
        console.sendMessage(Logger.color("&dCoded by&f: Rivzer"));
        console.sendMessage(Logger.color(""));
        console.sendMessage(Logger.color("&f----------------------------------------"));
    }

    @Override
    public void onDisable() {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

        console.sendMessage(Logger.color("&f----------------------------------------"));
        console.sendMessage(Logger.color(""));
        console.sendMessage(Logger.color("&dPlugin wordt uitgezet..."));
        console.sendMessage(Logger.color(""));
        console.sendMessage(Logger.color("&dCoded by&4: Rivzer"));
        console.sendMessage(Logger.color(""));
        console.sendMessage(Logger.color("&f----------------------------------------"));
    }

}
