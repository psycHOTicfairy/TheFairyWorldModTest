package net.psychoticfairy.thefairyworldmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties PINEAPPLE = new FoodProperties.Builder().nutrition(2)
            .saturationMod(.2f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED,200),0.1f).build();
}
