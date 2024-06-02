package com.mugmod.item;


import com.mugmod.MugMod;
import com.mugmod.sound.ModSounds;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class Kazoo extends ModItem {
    public Kazoo(Settings settings) {
        super(settings, "kazoo");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> entries.add(this));

    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        MugMod.LOGGER.info("Used Kazoo");

        user.getWorld().playSound(null, user.getBlockPos(), ModSounds.WOWZERS_SOUND, SoundCategory.BLOCKS, 1f, 1f);

        return super.use(world, user, hand);
    }

}