package com.mugmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.DispenserBlock;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Parasol extends ModItem {
    public Parasol(Settings settings) {
        super(settings, "parasol");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> entries.add(this));

    }

    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return !miner.isCreative();
    }

//    public UseAction getUseAction(ItemStack stack) {
//        return UseAction.BLOCK;
//    }

//    public int getMaxUseTime(ItemStack stack) {
//        return 72000;
//    }

//    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
//        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
//        return true;
//    }
//
//    public static AttributeModifiersComponent createAttributeModifiers() {
//        return AttributeModifiersComponent.builder().add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
//                new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Tool modifier", 4.0, EntityAttributeModifier.Operation.ADD_VALUE),
//                AttributeModifierSlot.MAINHAND).add(EntityAttributes.GENERIC_ATTACK_SPEED,
//                new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Tool modifier", -2.9000000953674316, EntityAttributeModifier.Operation.ADD_VALUE),
//                AttributeModifierSlot.MAINHAND).build();
//    }

}
