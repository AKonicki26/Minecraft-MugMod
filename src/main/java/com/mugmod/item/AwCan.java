package com.mugmod.item;

import com.mugmod.MugMod;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class AwCan extends ModItem {
    public AwCan(Settings settings) {
        super(settings, "aw_can");
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

                MugMod.LOGGER.info("Blinding you");

                user.addStatusEffect(new StatusEffectInstance(StatusEffects.UNLUCK, 1200,127));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 1200,127));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 1200,127));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 1200,127));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 1200,127));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 1200,127));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.BAD_OMEN, 1200,127));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 1200,127));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 1200,127));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 1200,127));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 1200,127));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 1200,127));
            }

            ((PlayerEntity)user).getItemCooldownManager().set(this, 80);

        }
        return super.finishUsing(stack, world, user);
    }
}
