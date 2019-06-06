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
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class MemeTools extends JavaPlugin {


    @Override
    public void onEnable() {
        getLogger().info(" ");
        getLogger().info("\u001b[34m --------------\u001b[0m");
        getLogger().info("\u001b[34m MemeTools v1.0\u001b[0m");
        getLogger().info("\u001b[34m --------------\u001b[0m");
        getLogger().info(" ");


        getServer().getPluginManager().registerEvents(new LightningArrowListener(), this);

        try {
            getCommand("mt").setExecutor(new MainCommand()); //main command hook
            getCommand("chatspam").setExecutor(new ChatSpam()); //chat spam command hook
            getCommand("lightningbolt").setExecutor(new LightningArrowListener()); //LAL command hook
        }
        catch (Exception e) {
            getLogger().info("command hooks did not initialize properly");
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("MemeTools has been disabled");
    }

}
