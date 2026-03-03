package de.pnku.bakeyourbread.mixin;

import net.minecraft.world.food.Foods;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Foods.class)
public abstract class FoodsMixin {
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/food/FoodProperties$Builder;nutrition(I)Lnet/minecraft/world/food/FoodProperties$Builder;"), slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/world/food/FoodProperties$Builder;nutrition(I)Lnet/minecraft/world/food/FoodProperties$Builder;", ordinal = 5), to = @At(value = "INVOKE", target = "Lnet/minecraft/world/food/FoodProperties$Builder;effect(Lnet/minecraft/world/effect/MobEffectInstance;F)Lnet/minecraft/world/food/FoodProperties$Builder;", ordinal = 0)))
    private static int injectedClinitAtFoodPropertiesBuilderNutritionSliced(int nutrition) {
        return nutrition == 3 ? 1 : nutrition;
    }
}
