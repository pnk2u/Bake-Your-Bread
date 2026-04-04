package de.pnku.bakeyourbread.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class BakeyourbreadFoodComponents {
    public static final int CAKE_DOUGH_POISON_DURATION = 300;
    public static final int CAKE_DOUGH_POISON_AMPLIFIER = 0;
    public static final float CAKE_DOUGH_POISON_CHANCE = 0.45F;
    public static final int CAKE_DOUGH_HUNGER_DURATION = 200;
    public static final int CAKE_DOUGH_HUNGER_AMPLIFIER = 1;
    public static final float CAKE_DOUGH_HUNGER_CHANCE = 0.3F;
    public static final int CAKE_DOUGH_CONFUSION_DURATION = 100;
    public static final int CAKE_DOUGH_CONFUSION_AMPLIFIER = 0;
    public static final float CAKE_DOUGH_CONFUSION_CHANCE = 0.75F;
    public static final FoodProperties COOKIE_DOUGH = (new FoodProperties.Builder()).nutrition(1).saturationModifier(0.1F).effect(new MobEffectInstance(MobEffects.HUNGER, 100, 0), 0.1F).effect(new MobEffectInstance(MobEffects.CONFUSION, 100, 0), 0.1F).build();
    public static final FoodProperties BREAD_DOUGH = (new FoodProperties.Builder()).nutrition(2).saturationModifier(0.5F).effect(new MobEffectInstance(MobEffects.HUNGER, 100, 0), 0.1F).effect(new MobEffectInstance(MobEffects.CONFUSION, 100, 0), 0.1F).build();
    public static final FoodProperties PUMPKIN_PIE_DOUGH = (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.2F).effect(new MobEffectInstance(MobEffects.POISON, 300, 1), 0.15F).effect(new MobEffectInstance(MobEffects.HUNGER, 200, 1), 0.2F).effect(new MobEffectInstance(MobEffects.CONFUSION, 100, 0), 0.2F).build();
    public static final FoodProperties UNBAKED_CAKE = (new FoodProperties.Builder()).nutrition(5).saturationModifier(0.5F).effect(new MobEffectInstance(MobEffects.POISON, CAKE_DOUGH_POISON_DURATION, CAKE_DOUGH_POISON_AMPLIFIER), CAKE_DOUGH_POISON_CHANCE).effect(new MobEffectInstance(MobEffects.HUNGER, CAKE_DOUGH_HUNGER_DURATION, CAKE_DOUGH_HUNGER_AMPLIFIER), CAKE_DOUGH_HUNGER_CHANCE).effect(new MobEffectInstance(MobEffects.CONFUSION, CAKE_DOUGH_CONFUSION_DURATION, CAKE_DOUGH_CONFUSION_AMPLIFIER), CAKE_DOUGH_CONFUSION_CHANCE).build();
    public static final FoodProperties UNCOOKED_BEETROUP_SOUP = uncookedStew(5).build();
    public static final FoodProperties UNCOOKED_MUSHROOM_STEW = uncookedStew(4).build();
    public static final FoodProperties UNCOOKED_RABBIT_STEW = uncookedStew(5).effect(new MobEffectInstance(MobEffects.POISON, 300, 1), 0.05F).effect(new MobEffectInstance(MobEffects.HUNGER, 300, 0), 0.15F).build();
    public static final FoodProperties COOKED_CARROT = (new FoodProperties.Builder()).nutrition(3).saturationModifier(0.6F).build();
    public static final FoodProperties UNCOOKED_GOLDEN_CARROT = (new FoodProperties.Builder()).nutrition(6).saturationModifier(0.2F).build();

    private static FoodProperties.Builder uncookedStew(int nutrition) {
        return (new FoodProperties.Builder()).nutrition(nutrition).saturationModifier(0.4F).usingConvertsTo(Items.BOWL);
    }
}
