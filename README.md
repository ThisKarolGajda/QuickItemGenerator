# QuickItemGenerator

This plugin is presentation for Fiverr.
SpigotMC link: https://www.spigotmc.org/resources/91033/

This plugin creates file which can be later use to summon custom items with custom name, lore, enchants without vanilla restrictions (e.g Sharpness 2021).
Plugin is easy to use.
You need to create "template" for your item, that means you add item with every value you want in config file.
E.g:
items:
  Item1:
    material: DIAMOND_PICKAXE
    name: "&bMiner's pickaxe"
    lore:
      - '&bThis pickaxe'
      - '&9&lis op'
      - '&klllllll'
    unbreakable: true
    glow: true
    enchants:
      DURABILITY: 10
      DIG_SPEED: 10
    hideAttributes: true
    
After saving configuration file, you can use /qig reload command to reload config (Thanks to this you don't need to restart your server),
and you can use /qig give (item name) command to summon created before item!
