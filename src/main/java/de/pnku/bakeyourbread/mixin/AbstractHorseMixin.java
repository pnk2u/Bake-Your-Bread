package de.pnku.bakeyourbread.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import de.pnku.bakeyourbread.init.BakeyourbreadItemInit;
import net.minecraft.world.entity.animal.equine.AbstractHorse;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AbstractHorse.class)
public abstract class AbstractHorseMixin {

    @WrapOperation(method = "handleEating", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"))
    private boolean wrappedHandleEatingIsItem(ItemStack stack, Item item, Operation<Boolean> original) {
        if (item == Items.GOLDEN_CARROT) {
            if (stack.is(BakeyourbreadItemInit.UNCOOKED_GOLDEN_CARROT)) return true;
        }
        return original.call(stack, item);
    }

}
