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

package st.northw;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Timer;
import java.util.TimerTask;

public class ChatSpam implements CommandExecutor {

    private boolean chatspam = false;
    int period = 2000;
    final Timer t = new Timer();
    String mt_prefix = String.format("%s[%smt%s] ", ChatColor.DARK_BLUE, ChatColor.BLUE, ChatColor.DARK_BLUE);

    public boolean onCommand(final CommandSender sender, Command cmd, String label, String[] args) {
        chatspam = !chatspam;
        final String message;

        if(args.length != 0) {
            StringBuilder sb = new StringBuilder();
            for (String arg : args) {
                sb.append(arg).append(" ");
            }
            message = sb.toString().trim();
        }
        else {
            message =  ChatColor.WHITE + "This is the default message";
        }
        if (!chatspam){
            t.cancel();
            t.purge();
        }
        if (chatspam) {
            sender.sendMessage(mt_prefix + ChatColor.GREEN + "chatspam toggled on");
            Timer t = new Timer();
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    Bukkit.broadcastMessage(mt_prefix + ChatColor.WHITE + message);
                    if(!chatspam){
                        this.cancel();
                        sender.sendMessage(mt_prefix + ChatColor.RED + "chatspam successfully turned off");
                    }
                }
            }, 0, period);

        }
        return true;
    }
}
