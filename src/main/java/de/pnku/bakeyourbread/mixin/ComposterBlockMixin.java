package de.pnku.bakeyourbread.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import de.pnku.bakeyourbread.init.BakeyourbreadItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ComposterBlock.class)
public abstract class ComposterBlockMixin {

    @Inject(method = "bootStrap", at = @At("TAIL"))
    private static void injectedBootStrapAtTail(CallbackInfo ci) {
        ComposterBlock.COMPOSTABLES.put(BakeyourbreadItemInit.COOKED_CARROT, 0.65F);
        ComposterBlock.COMPOSTABLES.put(BakeyourbreadItemInit.UNBAKED_COOKIE, 0.85F);
    	ComposterBlock.COMPOSTABLES.put(BakeyourbreadItemInit.UNBAKED_BREAD, 0.85F);
    	ComposterBlock.COMPOSTABLES.put(BakeyourbreadItemInit.UNCOOKED_BEETROOT_SOUP, 0.85F);
    	ComposterBlock.COMPOSTABLES.put(BakeyourbreadItemInit.UNCOOKED_MUSHROOM_STEW, 0.85F);
    	ComposterBlock.COMPOSTABLES.put(BakeyourbreadItemInit.UNCOOKED_RABBIT_STEW, 1.0F);
        ComposterBlock.COMPOSTABLES.put(BakeyourbreadItemInit.UNBAKED_PUMPKIN_PIE, 1.0F);
        ComposterBlock.COMPOSTABLES.put(BakeyourbreadItemInit.UNBAKED_CAKE, 1.0F);
    }

    @WrapOperation(method = "useItemOn", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;consume(ILnet/minecraft/world/entity/LivingEntity;)V"))
    private void wrappedUseItemOnAtStackConsume(ItemStack instance, int amount, LivingEntity entity, Operation<Void> original, ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand) {
        if (instance.is(BakeyourbreadItemInit.UNCOOKED_BEETROOT_SOUP) || instance.is(BakeyourbreadItemInit.UNCOOKED_MUSHROOM_STEW) || instance.is(BakeyourbreadItemInit.UNCOOKED_RABBIT_STEW)) {
            original.call(instance, amount, entity);
            player.setItemInHand(hand, new ItemStack(Items.BOWL));
            return;
        }
        original.call(instance, amount, entity);
    }

}
