package doxilegaming.ezmotd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class reloadMOTD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage(EzMOTD.getInstance().convertTextColor("&aEzMOTD Reloaded :)"));
        EzMOTD.getInstance().reloadConfig();
        EzMOTD.getInstance().getServer().setMotd(EzMOTD.getInstance().convertTextColor(EzMOTD.getInstance().config.getString("MOTD")));
        return true;
    }
}
