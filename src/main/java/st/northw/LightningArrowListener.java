/*
-------------------------------------------------
   __  ___               ______            __
  /  |/  /___  __ _  ___/_  __/___  ___   / /___
 / /|_/ // -_)/  ' \/ -_)/ /  / _ \/ _ \ / /(_-<
/_/  /_/ \__//_/_/_/\__//_/   \___/\___//_//___/

Michael Peters
northw.st
© 2019, All rights reserved.
dev testing branch

-------------------------------------------------
*/


package st.northw;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class LightningArrowListener implements Listener, CommandExecutor {

    boolean toggleState = false;
    String mt_prefix = String.format("%s[%smt%s] ", ChatColor.DARK_BLUE, ChatColor.BLUE, ChatColor.DARK_BLUE);

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player damager = (Player) event.getDamager();
            LivingEntity damaged = (LivingEntity) event.getEntity();
            Player damagedp = (Player) damaged;
            if(toggleState) {
                damager.sendMessage(mt_prefix + ChatColor.WHITE + damager.getDisplayName()
                        + "hit" + damagedp.getDisplayName() + "for" + damaged.getLastDamage());
            }
        }
        if(event.getDamager() instanceof Arrow){
            final Arrow arrow = (Arrow) event.getDamager();
            Player shoota = (Player) arrow.getShooter();
            World currWorld = shoota.getWorld();
            Location defLocation = event.getEntity().getLocation();

            if(shoota instanceof Player){
                if (toggleState) {
                    currWorld.strikeLightning(defLocation);
                    shoota.sendMessage(mt_prefix + ChatColor.WHITE +
                            event.getDamager().getName() + "shot" + event.getEntity().getName());

                }
            }

        }
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        toggleState = !toggleState;
        if(toggleState){
            commandSender.sendMessage(mt_prefix + ChatColor.GREEN + "toggled on");
        }
        else{
            commandSender.sendMessage(mt_prefix + ChatColor.RED + "toggled off");
        }
        return true;
    }
}
