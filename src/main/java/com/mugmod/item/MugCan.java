package com.mugmod.item;

import com.mugmod.MugMod;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MugCan extends ModItem {
    public MugCan(Settings settings) {
        super(settings, "mug_can");
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof PlayerEntity) {
            //((PlayerEntity) user).getInventory().clear();
            //user.kill();
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 20));
        }
        return super.finishUsing(stack, world, user);
    }
}
