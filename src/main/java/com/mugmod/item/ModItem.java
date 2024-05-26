package com.mugmod.item;

import com.mugmod.ModdedObject;
import com.mugmod.MugMod;
import com.mugmod.entity.ModEntities;
import com.mugmod.item.custom.FalconryGloveItem;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import org.apache.commons.lang3.text.WordUtils;

public class ModItem extends Item implements ModdedObject {

    public ModItem(Settings settings, String path) {
        super(settings);
        this.path = path;
        // Sets name to path such that "block_name" becomes "Block Name"
        this.name = WordUtils.capitalizeFully(path.replace("_", " "));
        registerObject();
    }

    public static final ModItem MUG_ROOT_BEER = new MugCan(new Item.Settings().food(FoodComponents.MugCan));
    public static final ModItem AW_ROOT_BEER = new AwCan(new Item.Settings().food(FoodComponents.AwCan));
    public static final ModItem MUG_ESSENCE = new MugEssence(new Item.Settings().rarity(Rarity.EPIC));

    public static final ModItem FALCONRY_GLOVE = new FalconryGloveItem(new Item.Settings());



    public static void registerModItems() {
        MugMod.LOGGER.info("Registering Mod Items for " + MugMod.MOD_ID);
    }

    public String name;
    public String path;

    @Override
    public void registerObject() {
        MugMod.LOGGER.info("Registering Item " + this.name);
        ModItemGroup.MUG_ITEMS.add(this);
        Registry.register(Registries.ITEM, new Identifier(MugMod.MOD_ID, this.path), this);
    }

    @Override
    public ItemStack getItemStack() {
        return null;
    }
}
