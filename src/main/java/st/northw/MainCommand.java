//Michael Peters, 2019

package st.northw;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MainCommand implements CommandExecutor {

    private void intro(CommandSender sender) {
        String mt_prefix = String.format("%s[%smt%s] ", ChatColor.DARK_BLUE, ChatColor.BLUE, ChatColor.DARK_BLUE);
        sender.sendMessage(mt_prefix + ChatColor.WHITE + "MemeTools for Minecraft Fools");
    }

    public boolean onCommand(final CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            intro(sender);
        }
        return true;
    }
}
