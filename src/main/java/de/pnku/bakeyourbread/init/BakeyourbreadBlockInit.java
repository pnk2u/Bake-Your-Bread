package de.pnku.bakeyourbread.init;

import de.pnku.bakeyourbread.BakeYourBread;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BakeyourbreadBlockInit {
    public static final Block UNBAKED_CAKE = new CakeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE).setId(ResourceKey.create(Registries.BLOCK, BakeYourBread.withModId("unbaked_cake"))));

    public static void registerUnbakedBlocks() {
        registerBlock("unbaked_cake", UNBAKED_CAKE);
    }

    private static void registerBlock(String name, Block block) {
        Registry.register(BuiltInRegistries.BLOCK, BakeYourBread.withModId(name), block);
    }
}
