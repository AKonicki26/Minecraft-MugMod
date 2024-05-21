package com.example.item;

import com.example.MugMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItem extends Item {

    public ModItem(Settings settings, String path) {
        super(settings);
        registerItem(this);
    }

    public static final ModItem MUG_ROOT_BEER = new MugCan(new Item.Settings());
    public static final ModItem MUG_ESSENCE = new MugEssence(new Item.Settings());

    private static Item registerItem(ModItem item) {
        MugMod.LOGGER.info("Registering Item " + item.name);
        ModItemGroup.MUG_ITEMS.add(item);
        return Registry.register(Registries.ITEM, new Identifier(MugMod.MOD_ID, item.path), item);
    }

    public static void registerModItems() {
        MugMod.LOGGER.info("Registering Mod Items for " + MugMod.MOD_ID);
    }

    public String name;
    public String path;
}
