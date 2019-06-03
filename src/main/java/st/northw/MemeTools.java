/*
   __  ___               ______            __
  /  |/  /___  __ _  ___/_  __/___  ___   / /___
 / /|_/ // -_)/  ' \/ -_)/ /  / _ \/ _ \ / /(_-<
/_/  /_/ \__//_/_/_/\__//_/   \___/\___//_//___/

Michael Peters
northw.st
© 2019, All rights reserved.

 */

package st.northw;

import org.bukkit.plugin.java.JavaPlugin;

public class MemeTools extends JavaPlugin {


    @Override
    public void onEnable() {
        getLogger().info(" ");
        getLogger().info("\u001b[34m --------------\u001b[0m");
        getLogger().info("\u001b[34m MemeTools v1.0\u001b[0m");
        getLogger().info("\u001b[34m --------------\u001b[0m");
        getLogger().info(" ");

        getCommand("mt").setExecutor(new MainCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("MemeTools has been disabled");
    }

}
