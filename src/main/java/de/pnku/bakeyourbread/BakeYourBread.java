package de.pnku.bakeyourbread;

import de.pnku.bakeyourbread.init.BakeyourbreadItemInit;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BakeYourBread implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("bakeyourbread");
    public static final String MODID = "bakeyourbread";

    @Override
    public void onInitialize() {
        BakeyourbreadItemInit.registerUncookedFoods();
        BakeyourbreadItemInit.registerUnbakedFoods();
    }

    public static ResourceLocation asId(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}