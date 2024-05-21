package com.example;

import com.example.item.MugCan;
import com.example.item.MugEssence;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MugMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "mugmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final Item MUG_ROOT_BEER = new MugCan(new Item.Settings());
	public static final Item MUG_ESSENCE = new MugEssence(new Item.Settings());

	public static final ItemGroup MUG_ITEM_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(MUG_ESSENCE))
			.displayName(Text.literal("Mug"))
			.entries((context, entries) -> {
				entries.add(MUG_ROOT_BEER);
				entries.add(MUG_ESSENCE);
			})
			.build();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "mug_can"), MUG_ROOT_BEER);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "mug_essence"), MUG_ESSENCE);
		Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, "mug"), MUG_ITEM_GROUP);
	}
}