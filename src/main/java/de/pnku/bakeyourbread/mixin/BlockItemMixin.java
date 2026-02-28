package de.pnku.bakeyourbread.mixin;

import de.pnku.bakeyourbread.BakeYourBread;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static de.pnku.bakeyourbread.init.BakeyourbreadItemInit.UNBAKED_CAKE;

@Mixin(BlockItem.class)
public abstract class BlockItemMixin {
    @Inject(method = "place", at = @At("HEAD"), cancellable = true)
    private void injectedPlaceAtHead(BlockPlaceContext context, CallbackInfoReturnable<InteractionResult> cir) {
        if (context.getItemInHand().is(UNBAKED_CAKE) && context.getPlayer() != null && context.getPlayer().isShiftKeyDown()) {
            cir.setReturnValue(InteractionResult.FAIL);
        }
    }
}
