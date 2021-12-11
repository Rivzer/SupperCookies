package be.rivzer.supercookies.Commands;

import be.rivzer.supercookies.Config.Config;
import be.rivzer.supercookies.Logger;
import be.rivzer.supercookies.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class Cookie implements CommandExecutor {

    private Main plugin;

    public Cookie(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("cookie").setExecutor(this);
        plugin.getCommand("cookies").setExecutor(this);
        plugin.getCommand("supercookie").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage(Logger.color("&f---------------------"));
            sender.sendMessage(Logger.color("&cConsole can't use this!"));
            sender.sendMessage(Logger.color("&f---------------------"));
            return true;
        }

        Player p = (Player) sender;
        List events;
        List lijst;

        if(cmd.getName().equalsIgnoreCase("cookie") || cmd.getName().equalsIgnoreCase("supercookie") || cmd.getName().equalsIgnoreCase("cookies")){
            if(args.length == 0){
                if(p.hasPermission("cookie.help")){
                    p.sendMessage(Logger.color("&f---------------------"));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&d/supercookie help &7- &fLook at the commands."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&d/supercookie create &7- &fCreate a supper cookie."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&d/supercookie addeffect &7- &fAdd a effect to a cookie."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&d/supercookie give &7- &fGive a player a supercookie."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&d/supercookie info &7- &fLook at the plugin maker."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&d/supercookie reload &7- &fReload all config files."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&f---------------------"));
                    return true;
                }
                else{
                    p.sendMessage(Logger.color("&f---------------------"));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&d/supercookie help &7- &fLook at the commands."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&d/supercookie info &7- &fLook at the plugin maker."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&f---------------------"));
                    return true;
                }
            }
            else if(args[0].equalsIgnoreCase("help")){
                if(p.hasPermission("cookie.help")){
                    p.sendMessage(Logger.color("&f---------------------"));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&d/supercookie help &7- &fLook at the commands."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&d/supercookie create &7- &fCreate a supper cookie."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&d/supercookie addeffect &7- &fAdd a effect to a cookie."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&d/supercookie give &7- &fGet a cookie you made."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&d/supercookie info &7- &fLook at the plugin maker."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&d/supercookie reload &7- &fReload all config files."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&f---------------------"));
                    return true;
                }
                else{
                    p.sendMessage(Logger.color("&f---------------------"));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&d/supercookie help &7- &fLook at the commands."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&d/supercookie info &7- &fLook at the plugin maker."));
                    p.sendMessage("");
                    p.sendMessage(Logger.color("&f---------------------"));
                    return true;
                }
            }
            else if(args[0].equalsIgnoreCase("info")){
                p.sendMessage(Logger.color("&f---------------------"));
                p.sendMessage(Logger.color("&cThis plugin was created by &f&lRivzer"));
                p.sendMessage(Logger.color("&cVersion: &f&l1.0"));
                p.sendMessage(Logger.color("&cReselling this plugin is prohibited!"));
                p.sendMessage(Logger.color("&f---------------------"));
                return true;
            }
            else if(args[0].equalsIgnoreCase("reload")){
                if(p.hasPermission("cookie.reload")){
                    p.sendMessage(Logger.color("&c&lSorry we don't support plugin reload yet, please restart (or reload) the server for saving the config files!"));
                    return true;
                }
                else{
                    p.sendMessage(Logger.color(Config.getCustomConfig3().getString("NoPermisison")));
                    return true;
                }
            }
            else if(args[0].equalsIgnoreCase("give")){
                if(args.length == 1){
                    //provide name
                    p.sendMessage(Logger.color("&f---------------------"));
                    p.sendMessage(Logger.color(""));
                    p.sendMessage(Logger.color(Config.getCustomConfig3().getString("ProvideName")));
                    p.sendMessage(Logger.color(""));
                    p.sendMessage(Logger.color("&f---------------------"));
                    return true;
                }
                if(args.length == 2){
                    //provide name
                    p.sendMessage(Logger.color("&f---------------------"));
                    p.sendMessage(Logger.color(""));
                    p.sendMessage(Logger.color(Config.getCustomConfig3().getString("ProvidePlayerName")));
                    p.sendMessage(Logger.color(""));
                    p.sendMessage(Logger.color("&f---------------------"));
                    return true;
                }
                else{
                    String name = args[1];

                    if(Config.getCustomConfig2().getString("Cookies." + name) == null){
                        p.sendMessage(Logger.color("&f---------------------"));
                        p.sendMessage(Logger.color(""));
                        p.sendMessage(Logger.color(Config.getCustomConfig3().getString("CookieDoesNotExist")));
                        p.sendMessage(Logger.color(""));
                        p.sendMessage(Logger.color("&f---------------------"));
                        return true;
                    }
                    else{
                        Player player = Bukkit.getPlayerExact(args[2]);

                        if(player == null){
                            p.sendMessage(Logger.color("&f---------------------"));
                            p.sendMessage(Logger.color(""));
                            p.sendMessage(Logger.color(Config.getCustomConfig3().getString("NoPlayerFound")));
                            p.sendMessage(Logger.color(""));
                            p.sendMessage(Logger.color("&f---------------------"));
                            return true;
                        }
                        else{
                            if(player.getInventory().firstEmpty() == -1){
                                p.sendMessage(Logger.color("&f---------------------"));
                                p.sendMessage(Logger.color(""));
                                p.sendMessage(Logger.color(Config.getCustomConfig3().getString("InventoryFull")));
                                p.sendMessage(Logger.color(""));
                                p.sendMessage(Logger.color("&f---------------------"));
                                return true;
                            }
                            else{
                                ItemStack item = new ItemStack(Material.COOKIE, 1);
                                ItemMeta meta = item.getItemMeta();
                                meta.setDisplayName(Logger.color(Config.getCustomConfig2().getString("Cookies." + name + ".DisplayName")));

                                if(Config.getCustomConfig2().getString("Cookies." + name + ".Glow") == "true"){
                                    meta.addEnchant(Enchantment.LUCK, 1, false);
                                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                                }

                                item.setItemMeta(meta);

                                player.getInventory().addItem(item);

                                p.sendMessage(Logger.color(Config.getCustomConfig3().getString("PlayerHasRecievedCookie")));
                            }
                        }
                    }
                }
            }
            else if(args[0].equalsIgnoreCase("addeffect")){
                if(args.length == 1){
                    //provide name
                    p.sendMessage(Logger.color("&f---------------------"));
                    p.sendMessage(Logger.color(""));
                    p.sendMessage(Logger.color(Config.getCustomConfig3().getString("ProvideName")));
                    p.sendMessage(Logger.color(""));
                    p.sendMessage(Logger.color("&f---------------------"));
                    return true;
                }
                else if(args.length == 2){
                    if(Config.getCustomConfig2().getString("Cookies." + args[1]) == null){
                        p.sendMessage(Logger.color("&f---------------------"));
                        p.sendMessage(Logger.color(""));
                        p.sendMessage(Logger.color(Config.getCustomConfig3().getString("CookieDoesNotExist")));
                        p.sendMessage(Logger.color(""));
                        p.sendMessage(Logger.color("&f---------------------"));
                        return true;
                    }

                    //provide effect name
                    p.sendMessage(Logger.color("&f---------------------"));
                    p.sendMessage(Logger.color(""));
                    p.sendMessage(Logger.color(Config.getCustomConfig3().getString("ProvideEffectName")));
                    p.sendMessage(Logger.color(""));
                    p.sendMessage(Logger.color("&f---------------------"));
                    return true;
                }
                else if(args.length == 3){
                    if(Config.getCustomConfig2().getString("Cookies." + args[1]) == null){
                        p.sendMessage(Logger.color("&f---------------------"));
                        p.sendMessage(Logger.color(""));
                        p.sendMessage(Logger.color(Config.getCustomConfig3().getString("CookieDoesNotExist")));
                        p.sendMessage(Logger.color(""));
                        p.sendMessage(Logger.color("&f---------------------"));
                        return true;
                    }

                    //provide effect name
                    p.sendMessage(Logger.color("&f---------------------"));
                    p.sendMessage(Logger.color(""));
                    p.sendMessage(Logger.color(Config.getCustomConfig3().getString("ProvideEffectTime")));
                    p.sendMessage(Logger.color(""));
                    p.sendMessage(Logger.color("&f---------------------"));
                    return true;
                }
                else{
                    if(Config.getCustomConfig2().getString("Cookies." + args[1]) == null){
                        p.sendMessage(Logger.color("&f---------------------"));
                        p.sendMessage(Logger.color(""));
                        p.sendMessage(Logger.color(Config.getCustomConfig3().getString("CookieDoesNotExist")));
                        p.sendMessage(Logger.color(""));
                        p.sendMessage(Logger.color("&f---------------------"));
                        return true;
                    }
                    else{
                        String cookieName = args[1];
                        String effectName = args[2].toUpperCase();
                        if(!args[3].matches("\\d+")){
                            p.sendMessage(Logger.color(Config.getCustomConfig3().getString("YouNeedToProvideAIntenger")));
                            return true;
                        }
                        int effectTime = Integer.valueOf(args[3]);
                        PotionEffectType type = PotionEffectType.getByName(effectName);

                        if(type == null){
                            p.sendMessage(Logger.color(Config.getCustomConfig3().getString("NotValidEffectName")));
                            return true;
                        }

                        events = Config.getCustomConfig2().getStringList("Cookies." + cookieName + ".Effects");

                        if(events.contains(effectName)){
                            int huidigeTijd = Config.getCustomConfig2().getInt("Cookies." + cookieName + ".EffectsTime." + effectName + ".Time");

                            if(effectTime != huidigeTijd){
                                Config.getCustomConfig2().set("Cookies." + cookieName + ".EffectsTime." + effectName + ".Time", effectTime);
                                Config.saveConfig2();
                                p.sendMessage(Logger.color(Config.getCustomConfig3().getString("ThisEffectIsAlreadyAddedButChangedTime")));
                                return true;
                            }

                            p.sendMessage(Logger.color(Config.getCustomConfig3().getString("ThisEffectIsAlreadyAdded")));
                            return true;
                        }

                        String event = effectName;
                        events.add(event);

                        Config.getCustomConfig2().set("Cookies." + cookieName + ".Effects", events);
                        Config.getCustomConfig2().set("Cookies." + cookieName + ".EffectsTime." + effectName + ".Time", effectTime);
                        Config.saveConfig2();

                        p.sendMessage(Logger.color(Config.getCustomConfig3().getString("AddedEffect")));
                    }
                }
            }
            else if(args[0].equalsIgnoreCase("create")){
                if(args.length == 1){
                    //provide name
                    p.sendMessage(Logger.color("&f---------------------"));
                    p.sendMessage(Logger.color(""));
                    p.sendMessage(Logger.color(Config.getCustomConfig3().getString("ProvideName")));
                    p.sendMessage(Logger.color(""));
                    p.sendMessage(Logger.color("&f---------------------"));
                    return true;
                }
                else if(args.length == 2){
                    //glow true or false
                    p.sendMessage(Logger.color("&f---------------------"));
                    p.sendMessage(Logger.color(""));
                    p.sendMessage(Logger.color(Config.getCustomConfig3().getString("NeedsGlow")));
                    p.sendMessage(Logger.color(""));
                    p.sendMessage(Logger.color("&f---------------------"));
                    return true;
                }
                else{

                    String name = args[1];
                    String glow = args[2];

                    if(Config.getCustomConfig2().getString("Cookies." + name) != null){
                        p.sendMessage(Logger.color("&f---------------------"));
                        p.sendMessage(Logger.color(""));
                        p.sendMessage(Logger.color(Config.getCustomConfig3().getString("CookieAlreadyExist")));
                        p.sendMessage(Logger.color(""));
                        p.sendMessage(Logger.color("&f---------------------"));
                        return true;
                    }
                    else{
                        Config.getCustomConfig2().set("Cookies." + name + ".Name", name);
                        Config.getCustomConfig2().set("Cookies." + name + ".DisplayName", name);
                        Config.getCustomConfig2().set("Cookies." + name + ".DisplayName", Logger.color(name));
                        Config.getCustomConfig2().set("Cookies." + name + ".Glow", Boolean.valueOf(glow));

                        lijst = Config.getCustomConfig2().getStringList("CookieList");
                        lijst.add(name);

                        Config.getCustomConfig2().set("CookieList", lijst);

                        Config.saveConfig2();

                        p.sendMessage(Logger.color(Config.getCustomConfig3().getString("CreatedCookie")));
                    }
                }
            }
        }

        return false;
    }
}