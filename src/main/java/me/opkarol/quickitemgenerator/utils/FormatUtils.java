package me.opkarol.quickitemgenerator.utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class FormatUtils {

    final static String doesntLoaded = "Message isnt loaded! Check your configuration file!";

    public static String formatText(String toFormat) {
        if(toFormat==null){
            return doesntLoaded;
        }
        return ChatColor.translateAlternateColorCodes('&', toFormat);
    }

    public static List<String> formatList(List<String> lore){
        List<String> Lore = new ArrayList<>();
        for(String s : lore){
            Lore.add(formatText(s));
        }
        return Lore;
    }
}
