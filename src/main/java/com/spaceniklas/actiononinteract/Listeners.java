package com.spaceniklas.actiononinteract;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;

public class Listeners implements Listener {

    ConsoleCommandSender console = Bukkit.getConsoleSender();
    @EventHandler
    public void onPlayerInteract(PlayerInteractAtEntityEvent e) {
        Player p = e.getPlayer();
        Player v = null;
        if (e.getRightClicked() instanceof Player){
            v = (Player)e.getRightClicked();
        }else {
            return;
        }

        if (Actiononinteract.config.getString("type-of-interaction").equalsIgnoreCase("rightclick")) {

            if (!Actiononinteract.config.getString("damager.give-item").equalsIgnoreCase("null")) {

                ItemStack is = new ItemStack(Material.getMaterial(Actiononinteract.config.getString("damager.give-item")), Actiononinteract.config.getInt("damager.amount-item"));
                p.getInventory().addItem(is);

            }

            if (!Actiononinteract.config.getString("damager.console-command").equalsIgnoreCase("null")) {

                String cmd = Actiononinteract.config.getString("damager.console-command");
                Bukkit.dispatchCommand(console, cmd.replace("%victim%", v.getName()).replace("%damager%", p.getName()));

            }
            if (!Actiononinteract.config.getString("victim.give-item").equalsIgnoreCase("null")) {

                ItemStack is = new ItemStack(Material.getMaterial(Actiononinteract.config.getString("victim.give-item")), Actiononinteract.config.getInt("victim.amount-item"));
                v.getInventory().addItem(is);

            }

            if (!Actiononinteract.config.getString("victim.console-command").equalsIgnoreCase("null")){

                String cmd = Actiononinteract.config.getString("victim.console-command");
                Bukkit.dispatchCommand(console, cmd.replace("%victim%", v.getName()).replace("%damager%", p.getName()));

            }

            if (!Actiononinteract.config.getString("damager.player-command").equalsIgnoreCase("null")) {

                String cmd = Actiononinteract.config.getString("damager.player-command");
                Bukkit.dispatchCommand(p, cmd.replace("%victim%", v.getName()).replace("%damager%", p.getName()));

            }

            if (!Actiononinteract.config.getString("victim.player-command").equalsIgnoreCase("null")) {

                String cmd = Actiononinteract.config.getString("victim.player-command");
                Bukkit.dispatchCommand(v, cmd.replace("%victim%", v.getName()).replace("%damager%", p.getName()));

            }
        }
    }

    @EventHandler
    public void onPlayerHit(EntityDamageByEntityEvent e) {
        Player p = (Player)e.getDamager();
        Player v = null;
        if (e.getEntity() instanceof Player){
            v = (Player)e.getEntity();
        }else {
            return;
        }

        if (Actiononinteract.config.getString("type-of-interaction").equalsIgnoreCase("damage")) {
            if (!Actiononinteract.config.getString("damager.give-item").equalsIgnoreCase("null")) {

                ItemStack is = new ItemStack(Material.getMaterial(Actiononinteract.config.getString("damager.give-item")), Actiononinteract.config.getInt("damager.amount-item"));
                p.getInventory().addItem(is);

            }

            if (!Actiononinteract.config.getString("damager.console-command").equalsIgnoreCase("null")) {

                String cmd = Actiononinteract.config.getString("damager.console-command");
                Bukkit.dispatchCommand(console, cmd.replace("%victim%", v.getName()).replace("%damager%", p.getName()));

            }
            if (!Actiononinteract.config.getString("victim.give-item").equalsIgnoreCase("null")) {

                ItemStack is = new ItemStack(Material.getMaterial(Actiononinteract.config.getString("victim.give-item")), Actiononinteract.config.getInt("victim.amount-item"));
                v.getInventory().addItem(is);

            }

            if (!Actiononinteract.config.getString("victim.console-command").equalsIgnoreCase("null")){

                String cmd = Actiononinteract.config.getString("victim.console-command");
                Bukkit.dispatchCommand(console, cmd.replace("%victim%", v.getName()).replace("%damager%", p.getName()));

            }

            if (!Actiononinteract.config.getString("damager.player-command").equalsIgnoreCase("null")) {

                String cmd = Actiononinteract.config.getString("damager.player-command");
                Bukkit.dispatchCommand(p, cmd.replace("%victim%", v.getName()).replace("%damager%", p.getName()));

            }

            if (!Actiononinteract.config.getString("victim.player-command").equalsIgnoreCase("null")) {

                String cmd = Actiononinteract.config.getString("victim.player-command");
                Bukkit.dispatchCommand(v, cmd.replace("%victim%", v.getName()).replace("%damager%", p.getName()));

            }
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){

        Player p = e.getEntity().getKiller();
        Player v = e.getEntity();

        if (!Actiononinteract.config.getString("killer.give-item").equalsIgnoreCase("null")) {

            ItemStack is = new ItemStack(Material.getMaterial(Actiononinteract.config.getString("killer.give-item")), Actiononinteract.config.getInt("killer.amount-item"));
            p.getInventory().addItem(is);

        }

        if (!Actiononinteract.config.getString("killer.console-command").equalsIgnoreCase("null")) {

            String cmd = Actiononinteract.config.getString("killer.console-command");
            Bukkit.dispatchCommand(console, cmd.replace("%victim%", v.getName()).replace("%damager%", p.getName()));

        }
        if (!Actiononinteract.config.getString("dead-player.give-item").equalsIgnoreCase("null")) {

            ItemStack is = new ItemStack(Material.getMaterial(Actiononinteract.config.getString("dead-player.give-item")), Actiononinteract.config.getInt("dead-player.amount-item"));
            v.getInventory().addItem(is);

        }

        if (!Actiononinteract.config.getString("dead-player.console-command").equalsIgnoreCase("null")){

            String cmd = Actiononinteract.config.getString("dead-player.console-command");
            Bukkit.dispatchCommand(console, cmd.replace("%victim%", v.getName()).replace("%damager%", p.getName()));

        }

        if (!Actiononinteract.config.getString("killer.player-command").equalsIgnoreCase("null")) {

            String cmd = Actiononinteract.config.getString("killer.player-command");
            Bukkit.dispatchCommand(p, cmd.replace("%victim%", v.getName()).replace("%damager%", p.getName()));

        }

        if (!Actiononinteract.config.getString("dead-player.player-command").equalsIgnoreCase("null")) {

            String cmd = Actiononinteract.config.getString("dead-player.player-command");
            Bukkit.dispatchCommand(v, cmd.replace("%victim%", v.getName()).replace("%damager%", p.getName()));

        }

    }
}