package com.mugmod;

import com.mugmod.blocks.ModBlock;
import com.mugmod.entity.ModEntities;
import com.mugmod.entity.custom.MooseEntity;
import com.mugmod.item.ModItem;
import com.mugmod.item.ModItemGroup;
import com.mugmod.painting.ModPaintings;
import com.mugmod.sound.ModSounds;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MugMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "mugmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		ModItem.registerModItems();
		ModItemGroup.registerItemGroups();
		ModBlock.registerModBlocks();
		ModPaintings.registerPaintings();
		ModSounds.registerSounds();

		FabricDefaultAttributeRegistry.register(ModEntities.MOOSE, MooseEntity.createMooseAttributes());


		//ModWorldGeneration.generateModWorldGen();
	}
}