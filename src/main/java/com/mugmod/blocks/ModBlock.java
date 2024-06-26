package com.mugmod.blocks;

import com.mugmod.ModdedObject;
import com.mugmod.MugMod;
import com.mugmod.item.ModItemGroup;
import com.mugmod.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlock extends Block implements ModdedObject {
    ModBlock(Settings settings, String path) {
        super(settings);
        this.path = path;
        this.name = getNameFromPath(path);
        registerObject();
    }

    public static final ModBlock Block_Test = new BlockTest(Block.Settings.copy(Blocks.NETHER_GOLD_ORE).sounds(ModSounds.WOWZERS_BLOCK_SOUNDS), "block_test");
    public static final ModBlock NETHER_MUG_ORE = new NetherMugOre(Block.Settings.copy(Blocks.NETHER_GOLD_ORE), "nether_mug_ore");

    public static void registerModBlocks() {
        MugMod.LOGGER.info("Registering Mod Items for " + MugMod.MOD_ID);
    }

    public String name;
    public String path;

    @Override
    public void registerObject() {
        MugMod.LOGGER.info("Registering Block " + this.name);
        Registry.register(Registries.BLOCK, new Identifier(MugMod.MOD_ID, this.path), this);
        ModItemGroup.MUG_ITEMS.add(Registry.register(Registries.ITEM, new Identifier(MugMod.MOD_ID, this.path), new BlockItem(this, new Item.Settings())));
    }

    @Override
    public ItemStack getItemStack() {
        return new ItemStack(this);
    }
}
