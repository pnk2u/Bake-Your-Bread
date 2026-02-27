package de.pnku.bakeyourbread.init;

import de.pnku.bakeyourbread.BakeYourBread;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;

public class BakeyourbreadBlockInit {
    public static final Block UNBAKED_CAKE = new CakeBlock(Block.Properties.ofFullCopy(Blocks.CAKE));

    public static void registerUnbakedBlocks() {
        registerBlock("unbaked_cake", UNBAKED_CAKE);
    }

    private static void registerBlock(String name, Block block) {
        Registry.register(BuiltInRegistries.BLOCK, BakeYourBread.withModId(name), block);
    }
}
