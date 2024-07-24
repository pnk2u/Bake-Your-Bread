package de.pnku.bakeyourbread.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class BakeyourbreadFoodComponents {
    public static final FoodProperties COOKIE_DOUGH = (new FoodProperties.Builder()).nutrition(1).saturationModifier(0.1F).effect(new MobEffectInstance(MobEffects.HUNGER, 100, 0), 0.1F).effect(new MobEffectInstance(MobEffects.CONFUSION, 100, 0), 0.1F).build();
    public static final FoodProperties BREAD_DOUGH = (new FoodProperties.Builder()).nutrition(2).saturationModifier(0.5F).effect(new MobEffectInstance(MobEffects.HUNGER, 100, 0), 0.1F).effect(new MobEffectInstance(MobEffects.CONFUSION, 100, 0), 0.1F).build();
    public static final FoodProperties PUMPKIN_PIE_DOUGH = (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.2F).effect(new MobEffectInstance(MobEffects.POISON, 300, 1), 0.15F).effect(new MobEffectInstance(MobEffects.HUNGER, 200, 1), 0.2F).effect(new MobEffectInstance(MobEffects.CONFUSION, 100, 0), 0.2F).build();
    public static final FoodProperties UNBAKED_CAKE = (new FoodProperties.Builder()).nutrition(6).saturationModifier(0.6F).effect(new MobEffectInstance(MobEffects.POISON, 300, 0), 0.15F).effect(new MobEffectInstance(MobEffects.HUNGER, 200, 1), 0.1F).effect(new MobEffectInstance(MobEffects.CONFUSION, 100, 0), 0.25F).build();
    public static final FoodProperties UNCOOKED_BEETROUP_SOUP = uncookedStew(5).build();
    public static final FoodProperties UNCOOKED_MUSHROOM_STEW = uncookedStew(4).build();
    public static final FoodProperties UNCOOKED_RABBIT_STEW = uncookedStew(5).effect(new MobEffectInstance(MobEffects.POISON, 300, 1), 0.05F).effect(new MobEffectInstance(MobEffects.HUNGER, 300, 0), 0.15F).build();

    private static FoodProperties.Builder uncookedStew(int nutrition) {
        return (new FoodProperties.Builder()).nutrition(nutrition).saturationModifier(0.4F);
    }
}
