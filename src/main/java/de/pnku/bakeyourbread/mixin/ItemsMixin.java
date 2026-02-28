package de.pnku.bakeyourbread.mixin;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(Items.class)
public abstract class ItemsMixin {
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item$Properties;food(Lnet/minecraft/world/food/FoodProperties;)Lnet/minecraft/world/item/Item$Properties;", ordinal = 0))
    private static FoodProperties injectedClinitAtInvokeAssignFoodPropertiesBuilderBuild(FoodProperties food) {
        if (food.getNutrition() == 3 && food.getNutrition() == 0.6F) {
            return new FoodProperties.Builder().nutrition(1).saturationMod(food.getNutrition()).build();
        } else return food;
    }
}
