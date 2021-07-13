package me.opkarol.quickitemgenerator;

import me.opkarol.quickitemgenerator.commands.MainCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

import static me.opkarol.quickitemgenerator.utils.ConfigUtils.getString;

public final class QuickItemGenerator extends JavaPlugin {
    private static QuickItemGenerator generator;

    @Override
    public void onEnable() {
        generator = this;
        Objects.requireNonNull(Bukkit.getPluginCommand("qig")).setExecutor(new MainCommand(this));
        configReload();

    }

    @Override
    public void onDisable() {
        generator = null;
    }

    public static QuickItemGenerator getInstance(){
        return generator;
    }

    public static void configReload(){
        getInstance().saveDefaultConfig();
        getInstance().reloadConfig();

        MainCommand command = new MainCommand(QuickItemGenerator.generator);
        command.badUsage = getString("messages.badUsage");
        command.itemNotExist = getString("messages.itemNotExist");
        command.reloadedConfig = getString("messages.reloadedConfig");
        command.note = getString("messages.note");
        command.onlyPlayer = getString("messages.onlyPlayer");
    }
}
