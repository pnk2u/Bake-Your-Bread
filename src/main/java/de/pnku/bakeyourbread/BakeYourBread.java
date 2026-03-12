package de.pnku.bakeyourbread;

import de.pnku.bakeyourbread.init.BakeyourbreadBlockInit;
import de.pnku.bakeyourbread.init.BakeyourbreadItemInit;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.repository.PackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BakeYourBread implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("bakeyourbread");
    public static final String MODID = "bakeyourbread";

    @SuppressWarnings("deprecation") // Using deprecated Resource Pack registration for compatibility with 1.21.4(-9)
    @Override
    public void onInitialize() {
        BakeyourbreadBlockInit.registerUnbakedBlocks();
        BakeyourbreadItemInit.registerUncookedFoods();
        BakeyourbreadItemInit.registerCookedFoods();
        BakeyourbreadItemInit.registerUnbakedFoods();
        ResourceManagerHelper.registerBuiltinResourcePack(
                withModId("byb-recipe-override"),
                FabricLoader.getInstance().getModContainer(MODID).orElseThrow(),
                ResourcePackActivationType.DEFAULT_ENABLED
        );
        ResourceManagerHelper.registerBuiltinResourcePack(
                withModId("byb-eating-animations"),
                FabricLoader.getInstance().getModContainer(MODID).orElseThrow(),
                Component.translatable("resourcePack.byb_eating_animations.name"),
                ResourcePackActivationType.NORMAL
        );
    }

    public static Identifier withModId(String path) {
        return Identifier.fromNamespaceAndPath(MODID, path);
    }
}