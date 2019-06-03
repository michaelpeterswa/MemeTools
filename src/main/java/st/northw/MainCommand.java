package st.northw;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MainCommand implements CommandExecutor {

    private void intro(){
        String mt_prefix = String.format("%s[%smt%s] ", ChatColor.DARK_BLUE, ChatColor.BLUE, ChatColor.DARK_BLUE);
        Bukkit.broadcastMessage(mt_prefix + ChatColor.WHITE + "MemeTools for Minecraft Fools");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        intro();
        return true;
    }

}
