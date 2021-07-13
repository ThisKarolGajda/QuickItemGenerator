package me.opkarol.quickitemgenerator.commands;

import me.opkarol.quickitemgenerator.QuickItemGenerator;
import me.opkarol.quickitemgenerator.voids.MainMethods;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.opkarol.quickitemgenerator.utils.ConfigUtils.getString;

public class MainCommand implements CommandExecutor {

    private final MainMethods methods;

    public String badUsage = getString("messages.badUsage");
    public String note = getString("messages.note");
    public String onlyPlayer = getString("messages.onlyPlayer");
    public String itemNotExist = getString("messages.itemNotExist");
    public String reloadedConfig = getString("messages.reloadedConfig");

    public MainCommand(QuickItemGenerator quickItemGenerator) {
        methods = new MainMethods();
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission("quikitemgenerator.command.qik")||!sender.isOp()) return false;
        if(args.length==0){
            sender.sendMessage(badUsage);
            return false;
        }
        if(args[0].equals("give")){
            String itemName = args[1];
            if (methods.isItemExists(itemName) || itemName!=null){
                if(sender instanceof Player){
                    Player player = (Player) sender;
                    methods.setItem(itemName, player);
                    sender.sendMessage(note);
                } else sender.sendMessage(onlyPlayer);

            } else sender.sendMessage(itemNotExist);

        } else if(args[0].equals("reload")){
            QuickItemGenerator.configReload();
            sender.sendMessage(reloadedConfig);
        }
        return false;
    }
}
