package com.example.item;

import com.example.MugMod;
import net.minecraft.item.Item;

public class ModItem extends Item {
    public ModItem(Settings settings) {
        super(settings);
    }

    public static void registerModItems() {
        MugMod.LOGGER.info("Registering Mod Items for ");
    }
}
