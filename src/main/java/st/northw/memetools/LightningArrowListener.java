/*
-------------------------------------------------
   __  ___               ______            __
  /  |/  /___  __ _  ___/_  __/___  ___   / /___
 / /|_/ // -_)/  ' \/ -_)/ /  / _ \/ _ \ / /(_-<
/_/  /_/ \__//_/_/_/\__//_/   \___/\___//_//___/

Michael Peters
northw.st
© 2019, All rights reserved.
/dev testing branch

-------------------------------------------------
*/

package st.northw.memetools;

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

    private boolean toggleState;
    String mt_prefix = String.format("%s[%smt%s] ", ChatColor.DARK_BLUE, ChatColor.BLUE, ChatColor.DARK_BLUE);

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {

        if(event.getDamager() instanceof Arrow){
            final Arrow arrow = (Arrow) event.getDamager();

            if(arrow.getShooter() instanceof Player){
                if (toggleState) {
                    Player shoota = (Player) arrow.getShooter();
                    World currWorld = shoota.getWorld();
                    Location defLocation = event.getEntity().getLocation();
                    currWorld.strikeLightning(defLocation);
                    shoota.sendMessage(mt_prefix + ChatColor.WHITE +
                            shoota.getDisplayName() + " shot " + event.getEntity().getName() + " with lightning");
                }
            }
        }
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        toggleState = !toggleState;
        if(toggleState){
            commandSender.sendMessage(mt_prefix + ChatColor.GREEN + "lightning bolts toggled on");
            //commandSender.sendMessage(mt_prefix + toggleState);
        }
        else{
            commandSender.sendMessage(mt_prefix + ChatColor.RED + "lightning bolts toggled off");
            //commandSender.sendMessage(mt_prefix + toggleState);
        }
        return true;
    }

}
