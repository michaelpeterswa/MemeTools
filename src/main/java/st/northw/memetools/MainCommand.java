/*
-------------------------------------------------
   __  ___               ______            __
  /  |/  /___  __ _  ___/_  __/___  ___   / /___
 / /|_/ // -_)/  ' \/ -_)/ /  / _ \/ _ \ / /(_-<
/_/  /_/ \__//_/_/_/\__//_/   \___/\___//_//___/

Michael Peters
northw.st
© 2019, All rights reserved.

-------------------------------------------------
*/


package st.northw.memetools;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MainCommand implements CommandExecutor {

    private void intro(CommandSender sender) {
        String mt_prefix = String.format("%s[%smt%s] ", ChatColor.DARK_BLUE, ChatColor.BLUE, ChatColor.DARK_BLUE);

        sender.sendMessage(mt_prefix + ChatColor.WHITE + "-------------------------------");
        sender.sendMessage(mt_prefix + ChatColor.WHITE + "MemeTools for Minecraft Fools");
        sender.sendMessage(mt_prefix + ChatColor.RED + "/chatspam : spam the chat");
        sender.sendMessage(mt_prefix + ChatColor.RED + "/lightningbolt : electric arrows");
        sender.sendMessage(mt_prefix + ChatColor.RED + "/mtbc : simple broadcast");
        sender.sendMessage(mt_prefix + ChatColor.WHITE + "-------------------------------");

    }

    public boolean onCommand(final CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            intro(sender);
        }
        return true;
    }
}
