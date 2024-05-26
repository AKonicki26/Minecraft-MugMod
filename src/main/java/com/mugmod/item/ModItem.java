package com.mugmod.item;

import com.mugmod.ModdedObject;
import com.mugmod.MugMod;
import com.mugmod.entity.ModEntities;
import com.mugmod.item.custom.FalconryGloveItem;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
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
        this.name = getNameFromPath(path);
        registerObject();
    }

    public static final ModItem MUG_ROOT_BEER = new MugCan(new Item.Settings().food(FoodComponents.MugCan));
    public static final ModItem AW_ROOT_BEER = new AwCan(new Item.Settings().food(FoodComponents.AwCan));
    public static final ModItem MUG_ESSENCE = new MugEssence(new Item.Settings().rarity(Rarity.EPIC));

    public static final ModItem FALCONRY_GLOVE = new FalconryGloveItem(new Item.Settings());
    public static final Item MOOSE_SPAWN_EGG = createSpawnEgg(ModEntities.MOOSE, "moose_spawn_egg", 0x423120, 0xcba987);

    public static Item createSpawnEgg(EntityType<? extends MobEntity> mob, String path, int primaryColor, int secondaryColor) {
        var egg =  new SpawnEggItem(mob, primaryColor, secondaryColor, new Item.Settings());
        ModItemGroup.MUG_ITEMS.add(egg);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> entries.add(egg));
        return Registry.register(Registries.ITEM, new Identifier(MugMod.MOD_ID, path), egg);
    }

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
