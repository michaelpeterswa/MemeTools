//Michael Peters, 2019

package st.northw;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Timer;
import java.util.TimerTask;

public class MainCommand implements CommandExecutor {

    private boolean chatspam = false;
    final Timer t = new Timer();

    private void intro() {
        String mt_prefix = String.format("%s[%smt%s] ", ChatColor.DARK_BLUE, ChatColor.BLUE, ChatColor.DARK_BLUE);
        Bukkit.broadcastMessage(mt_prefix + ChatColor.WHITE + "MemeTools for Minecraft Fools");
    }

    public boolean onCommand(final CommandSender sender, Command cmd, String label, String[] args) {
        final String mt_prefix = String.format("%s[%smt%s] ", ChatColor.DARK_BLUE, ChatColor.BLUE, ChatColor.DARK_BLUE);

        if (args.length == 0) {
            intro();
        } else if (args.length == 1) {
            if (args[0].equals("cs")) {
                chatspam = !chatspam;
                if (!chatspam){
                   //sender.sendMessage(mt_prefix + ChatColor.WHITE + "chatspam toggled off");
                   t.cancel();
                   t.purge();
                   //t.cancel(); //IAE, timer already cancelled
                   //chatspam = !chatspam;
                }
                if (chatspam) {
                   sender.sendMessage(mt_prefix + ChatColor.RED + "chatspam toggled on");
                   Timer t = new Timer();
                   t.schedule(new TimerTask() {
                       @Override
                       public void run() {
                           Bukkit.broadcastMessage(mt_prefix + ChatColor.WHITE + "lol get memed on fool");
                           if(!chatspam){
                               this.cancel();
                               sender.sendMessage(mt_prefix + ChatColor.RED + "chatspam successfully turned off");
                           }
                       }
                   }, 0, 2000);

                }
            }
        }
        return true;
    }
}
