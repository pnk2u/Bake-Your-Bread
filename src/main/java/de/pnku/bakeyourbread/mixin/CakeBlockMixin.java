package de.pnku.bakeyourbread.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import de.pnku.bakeyourbread.init.BakeyourbreadBlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static de.pnku.bakeyourbread.init.BakeyourbreadBlockInit.UNBAKED_CAKE;
import static de.pnku.bakeyourbread.item.BakeyourbreadFoodComponents.*;

@Mixin(CakeBlock.class)
public abstract class CakeBlockMixin {

    @WrapOperation(method = "eat", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/food/FoodData;eat(IF)V"))
    private static void wrappedEatAtEat(FoodData instance, int foodLevelModifier, float saturationLevelModifier, Operation<Void> original, LevelAccessor level, BlockPos pos, BlockState state, Player player) {
        if (level.getBlockState(pos).is(UNBAKED_CAKE)) {
            if (level.isClientSide()) {
                boolean poisoned = player.getRandom().nextFloat() < CAKE_DOUGH_POISON_CHANCE/7;
                boolean hungered = player.getRandom().nextFloat() < CAKE_DOUGH_HUNGER_CHANCE/7;
                boolean confused = player.getRandom().nextFloat() < CAKE_DOUGH_NAUSEA_CHANCE/7;
                if (poisoned) player.addEffect(new MobEffectInstance(MobEffects.POISON, CAKE_DOUGH_POISON_DURATION, CAKE_DOUGH_POISON_AMPLIFIER));
                if (hungered) player.addEffect(new MobEffectInstance(MobEffects.HUNGER, CAKE_DOUGH_HUNGER_DURATION, CAKE_DOUGH_HUNGER_AMPLIFIER));
                if (confused) player.addEffect(new MobEffectInstance(MobEffects.NAUSEA, CAKE_DOUGH_NAUSEA_DURATION, CAKE_DOUGH_NAUSEA_AMPLIFIER));
            }
            original.call(instance, 1, 0.05F);
        } else {
            original.call(instance, foodLevelModifier, saturationLevelModifier);
        }
    }

    @Inject(method = "useItemOn", at = @At(value = "HEAD"), cancellable = true)
    private void injectedUseItemOnAtHead(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult, CallbackInfoReturnable<InteractionResult> cir) {
        if (level.getBlockState(pos).is(BakeyourbreadBlockInit.UNBAKED_CAKE) && Block.byItem(stack.getItem()) instanceof CandleBlock) {
            cir.setReturnValue(InteractionResult.PASS);
        }
    }
}
