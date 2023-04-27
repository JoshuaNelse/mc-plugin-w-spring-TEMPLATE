package com.tcc.mchelloworld;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class McHelloWorldApplication extends JavaPlugin {


    public static void main(String[] args) {
        SpringApplication.run(McHelloWorldApplication.class, args);
    }

    @Override
    public void onEnable() {
        // on server startup / reloads / plugin reloads
        super.onEnable();
    }

    @Override
    public void onDisable() {
        // on shutdown / reloads /plugin reloads
        super.onDisable();
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("hello")) {
            if (sender instanceof Player) {
                // player
                Player player = (Player) sender;
                if (player.hasPermission("hello.user")) {
                    player.sendMessage(ChatColor.AQUA +String.valueOf(ChatColor.BOLD) + "Hello, welcome to the server!");
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&1H&2e&3l&4l*5o &6W&7o&8r&9ld!"));
                } else {
                    player.sendMessage(ChatColor.RED + "Missing permissions for hello command");
                }
                return true;
            } else {
                // console
                sender.sendMessage("Hey console!!!");
                return true;
            }
        }
        return false;
    }
}
