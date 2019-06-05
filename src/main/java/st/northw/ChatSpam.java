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
    final Timer t = new Timer();
    String mt_prefix = String.format("%s[%smt%s] ", ChatColor.DARK_BLUE, ChatColor.BLUE, ChatColor.DARK_BLUE);

    public boolean onCommand(final CommandSender sender, Command cmd, String label, String[] args) {
        chatspam = !chatspam;
        final String message;

        if(args.length != 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < args.length; i++) {
                sb.append(args[i]).append(" ");
            }
            message = sb.toString().trim();
        }
        else {
            message =  ChatColor.WHITE + "This is the default message";
        }
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
                    Thread.currentThread().setName("ChatSpam");
                    Bukkit.broadcastMessage(mt_prefix + ChatColor.WHITE + message);
                    if(!chatspam){
                        this.cancel();
                        sender.sendMessage(mt_prefix + ChatColor.RED + "chatspam successfully turned off");
                    }
                }
            }, 0, 2000);

        }
        return true;
    }
}
