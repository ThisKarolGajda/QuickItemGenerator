package me.opkarol.quickitemgenerator.voids;


import me.opkarol.quickitemgenerator.utils.ConfigUtils;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static me.opkarol.quickitemgenerator.utils.ConfigUtils.*;
import static me.opkarol.quickitemgenerator.utils.FormatUtils.*;

public class MainMethods {
    String path = "items.";


    public boolean isItemExists(String itemName){
        return ConfigUtils.getString(path + itemName)!=null;
    }

    public void setItem(String itemName, Player toGive){
        String pathItem = path+itemName+".";
        ConfigurationSection section = configuration().getConfigurationSection(pathItem+"enchants");

        ItemStack item = new ItemStack(Material.valueOf(getString(pathItem+"material")), 1);
        ItemMeta meta = item.getItemMeta();

        assert meta != null;
        meta.setLore(formatList(configuration().getStringList(pathItem+"lore")));
        if(getBoolean(pathItem+"unbreakable")) meta.setUnbreakable(true);
        meta.setDisplayName(formatText(getString(pathItem+"name")));
        if(getBoolean(pathItem+"glow")) meta.addEnchant(Enchantment.LUCK, 1, true);
        if(getBoolean(pathItem+"hideAttributes")) meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES);

        if(section!=null){
            for(String key : section.getKeys(false)){
                Enchantment enchantment = Enchantment.getByName(key);
                if (enchantment != null) meta.addEnchant(enchantment, getInt(pathItem+"enchants."+key), true);
            }
        }
        item.setItemMeta(meta);
        toGive.getInventory().addItem(item);
        toGive.updateInventory();
    }
}
