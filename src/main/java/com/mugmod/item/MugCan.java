package com.mugmod.item;

import com.mugmod.MugMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class MugCan extends ModItem {
    public MugCan(Settings settings) {
        super(settings, "mug_can");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.add(this));
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {

        if(world.isClient) return super.finishUsing(stack, world, user);

        if (user instanceof PlayerEntity) {

            if (new Random().nextFloat() <= 0.5f)
            {
                MugMod.LOGGER.info("Killing you");

                ((PlayerEntity) user).getInventory().clear();
                user.kill();

            } else {

                MugMod.LOGGER.info("Saving you");

                user.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 1200,127));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1200,4));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 180,3));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1200,127));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1200,3));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1200,127));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200,127));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 1200,127));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 1200,127));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1200,127));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 1200,127));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1200,127));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 1200,127));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 1200,127));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1200,127));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1200,127));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 1200,127));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 1200,127));
            }

            ((PlayerEntity)user).getItemCooldownManager().set(this, 80);

        }
        return super.finishUsing(stack, world, user);
    }
}
