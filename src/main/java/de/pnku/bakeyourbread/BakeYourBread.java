package de.pnku.bakeyourbread;

import de.pnku.bakeyourbread.init.BakeyourbreadBlockInit;
import de.pnku.bakeyourbread.init.BakeyourbreadItemInit;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BakeYourBread implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("bakeyourbread");
    public static final String MODID = "bakeyourbread";

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
        if (FabricLoader.getInstance().isModLoaded("eatinganimationid")) {
            ResourceManagerHelper.registerBuiltinResourcePack(
                    withModId("byb-eating-animations"),
                    FabricLoader.getInstance().getModContainer(MODID).orElseThrow(),
                    Component.translatable("resourcePack.byb_eating_animations.name"),
                    ResourcePackActivationType.ALWAYS_ENABLED
            );
        }
    }

    public static Identifier withModId(String path) {
        return Identifier.fromNamespaceAndPath(MODID, path);
    }
}