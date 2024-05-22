package com.example.blocks;

import com.example.ModdedObject;
import com.example.MugMod;
import com.example.item.ModItem;
import com.example.item.ModItemGroup;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.text.WordUtils;

public class ModBlock extends Block implements ModdedObject {
    ModBlock(Settings settings, String path) {
        super(settings);
        this.path = path;
        // Sets name to path such that "block_name" becomes "Block Name"
        this.name = WordUtils.capitalizeFully(path.replace("_", " "));
        registerObject();
    }

    public static final ModBlock MUG_ORE = new MugOre(Block.Settings.copy(Blocks.NETHER_GOLD_ORE), "mug_ore");

    public static void registerModBlocks() {
        MugMod.LOGGER.info("Registering Mod Items for " + MugMod.MOD_ID);
    }

    public String name;
    public String path;

    @Override
    public void registerObject() {
        MugMod.LOGGER.info("Registering Block " + this.name);
        Registry.register(Registries.BLOCK, new Identifier(MugMod.MOD_ID, this.path), this);
        ModItem BlockItem = new ModItem(new Item.Settings(), path);
    }

    @Override
    public ItemStack getItemStack() {
        return new ItemStack(this);
    }
}
