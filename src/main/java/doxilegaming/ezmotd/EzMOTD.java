package doxilegaming.ezmotd;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class EzMOTD extends JavaPlugin {
    FileConfiguration config = getConfig();
    private static EzMOTD instance;


    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getLogger().info(ChatColor.GREEN + "EzMOTD Enabled :)");
        getServer().setMotd(convertTextColor(config.getString("MOTD")));
        this.getCommand("reloadmotd").setExecutor(new reloadMOTD());

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(ChatColor.RED + "EzMOTD Disabled :(");
    }

    //simple and easy way to convert & characters to color
    public String convertTextColor(String txt) {
        return ChatColor.translateAlternateColorCodes('&', txt);
    }
    //lame developer stuff to access variable easier
    public static EzMOTD getInstance(){
        return instance;
    }

    @Override
    public void reloadConfig() {
        super.reloadConfig();

        saveDefaultConfig();
        config = getConfig();
        config.options().copyDefaults(true);
        saveConfig();
    }
}
