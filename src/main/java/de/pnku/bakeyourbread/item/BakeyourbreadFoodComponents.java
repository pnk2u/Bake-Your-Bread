package de.pnku.bakeyourbread.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.List;

import static net.minecraft.world.item.component.Consumables.defaultDrink;
import static net.minecraft.world.item.component.Consumables.defaultFood;

public class BakeyourbreadFoodComponents {
    // Foods
    public static final FoodProperties COOKIE_DOUGH_F = (new FoodProperties.Builder()).nutrition(1).saturationModifier(0.1F).build();
    public static final FoodProperties BREAD_DOUGH_F = (new FoodProperties.Builder()).nutrition(2).saturationModifier(0.5F).build();
    public static final FoodProperties PUMPKIN_PIE_DOUGH_F = (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.2F).build();
    public static final FoodProperties UNBAKED_CAKE_F = (new FoodProperties.Builder()).nutrition(6).saturationModifier(0.6F).build();
    public static final FoodProperties UNCOOKED_BEETROOT_SOUP_F = uncookedStew(5).build();
    public static final FoodProperties UNCOOKED_MUSHROOM_STEW_F = uncookedStew(4).build();
    public static final FoodProperties UNCOOKED_RABBIT_STEW_F = uncookedStew(5).build();

    private static FoodProperties.Builder uncookedStew(int nutrition) {
        return (new FoodProperties.Builder()).nutrition(nutrition).saturationModifier(0.4F);
    }


    // Consumables
    public static final Consumable COOKIE_DOUGH_C = defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    List.of(new MobEffectInstance(MobEffects.HUNGER, 100, 0),
                            new MobEffectInstance(MobEffects.CONFUSION, 100, 0)),0.1F))
            .build();
    public static final Consumable BREAD_DOUGH_C = defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    List.of(new MobEffectInstance(MobEffects.HUNGER, 100, 0),
                            new MobEffectInstance(MobEffects.CONFUSION, 100, 0)), 0.1F))
            .build();
    public static final Consumable PUMPKIN_PIE_DOUGH_C = defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 300, 1),0.15F))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.HUNGER, 200, 1), 0.2F))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.CONFUSION, 100, 0), 0.2F))
            .build();
    public static final Consumable UNBAKED_CAKE_C = defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 300, 0), 0.15F))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.HUNGER, 200, 1), 0.1F))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.CONFUSION, 100, 0), 0.25F))
            .build();
    public static final Consumable UNCOOKED_RABBIT_STEW_C = defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.POISON, 300, 1), 0.05F))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.HUNGER, 300, 0), 0.15F))
            .build();
}
