package me.opkarol.quickitemgenerator.utils;

import me.opkarol.quickitemgenerator.QuickItemGenerator;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigUtils {

    public static FileConfiguration configuration(){ return QuickItemGenerator.getInstance().getConfig();}

    public static String getString(String path){ return configuration().getString(path);}

    public static int getInt(String path){ return configuration().getInt(path); }

    public static boolean getBoolean(String path) { return configuration().getBoolean(path); }
}
