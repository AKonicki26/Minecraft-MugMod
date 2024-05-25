package com.mugmod.item.custom;

import com.mugmod.item.ModItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;

public class FalconryGloveItem extends ModItem {
    public FalconryGloveItem(Settings settings) {
        super(settings, "falconry_glove");
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        user.kill();

        return super.useOnEntity(stack, user, entity, hand);
    }
}
