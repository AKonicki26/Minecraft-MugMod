package com.example.item;

import com.example.ModdedObject;
import com.example.MugMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.text.WordUtils;

public class ModItem extends Item implements ModdedObject {

    public ModItem(Settings settings, String path) {
        super(settings);
        this.path = path;
        // Sets name to path such that "item_name" becomes "Item Name"
        this.name = WordUtils.capitalizeFully(path.replace("_", " "));
        registerObject();
    }

    public static final ModItem MUG_ROOT_BEER = new MugCan(new Item.Settings());
    public static final ModItem MUG_ESSENCE = new MugEssence(new Item.Settings());

    @Override
    public void registerObject() {
        MugMod.LOGGER.info("Registering Item " + name);
        ModItemGroup.MUG_ITEMS.add(this);
        Registry.register(Registries.ITEM, new Identifier(MugMod.MOD_ID, path), this);
    }

    @Override
    public ItemStack getItemStack() {
        return new ItemStack(this);
    }

    public static void registerModItems() {
        MugMod.LOGGER.info("Registering Mod Items for " + MugMod.MOD_ID);
    }

    public String name;
    public String path;


}
