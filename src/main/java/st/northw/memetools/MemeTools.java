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

import org.bukkit.plugin.java.JavaPlugin;

public class MemeTools extends JavaPlugin {


    @Override
    public void onEnable() {
        getLogger().info(" ");
        getLogger().info("\u001b[34m --------------\u001b[0m");
        getLogger().info("\u001b[34m MemeTools v1.2\u001b[0m");
        getLogger().info("\u001b[34m --------------\u001b[0m");
        getLogger().info(" ");

        LightningArrowListener instance = new LightningArrowListener();
        //necessary to allow bool data between listener and command hook

        getServer().getPluginManager().registerEvents(instance, this);

        try {
            getCommand("mt").setExecutor(new MainCommand()); //main command hook
            getCommand("chatspam").setExecutor(new ChatSpam()); //chat spam command hook
            getCommand("lightningbolt").setExecutor(instance); //LAL command hook
            getCommand("mtbc").setExecutor(new Broadcast()); //Broadcast command hook
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
