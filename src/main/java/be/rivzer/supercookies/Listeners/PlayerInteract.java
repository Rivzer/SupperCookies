package be.rivzer.supercookies.Listeners;

import be.rivzer.supercookies.Config.Config;
import be.rivzer.supercookies.Logger;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class PlayerInteract implements Listener {

    @EventHandler
    public void onUse(PlayerInteractEvent e){
        Player p = e.getPlayer();

        if(p.getInventory().getItemInMainHand().getType() == Material.COOKIE){
            if(e.getAction() == Action.RIGHT_CLICK_AIR){
                List<String> itemlijst = Config.getCustomConfig2().getStringList("CookieList");
                String[] items = (String[])itemlijst.toArray(new String[0]);
                String[] var11 = items;
                int var10 = items.length;

                for(int var9 = 0; var9 < var10; ++var9) {
                    String item = var11[var9];
                    String cookieDisplay = ChatColor.stripColor(Logger.color(Config.getCustomConfig2().getString("Cookies." + item + ".DisplayName")));
                    String nameInHand = ChatColor.stripColor(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName());

                    if(nameInHand.equalsIgnoreCase(cookieDisplay)){
                        List<String> effectLijst = Config.getCustomConfig2().getStringList("Cookies." + item + ".Effects");
                        String[] effects = (String[])effectLijst.toArray(new String[0]);
                        String[] var0 = effects;
                        int var1 = effects.length;

                        for(int var2 = 0; var2 < var1; ++var2) {
                            String effect = var0[var2];
                            int duration = Config.getCustomConfig2().getInt("Cookies." + item + ".EffectsTime." + effect + ".Time");

                            String message = Config.getCustomConfig3().getString("ConsumedCookie");

                            message = message.replaceAll("%cookie_name%", item);
                            message = message.replaceAll("%effect_name%", effect);

                            p.addPotionEffect(new PotionEffect(PotionEffectType.getByName(effect), duration, 1));

                            p.sendMessage(Logger.color(message));
                        }
                    }
                }
                return;
            }
        }
    }
}