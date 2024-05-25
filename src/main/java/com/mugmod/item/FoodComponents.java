package com.mugmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class FoodComponents {
    public static final FoodComponent MugCan = new FoodComponent.Builder().nutrition(1).saturationModifier(0.25f).build();
    public static final FoodComponent AwCan = new FoodComponent.Builder().nutrition(1).saturationModifier(0.25f).build();

}