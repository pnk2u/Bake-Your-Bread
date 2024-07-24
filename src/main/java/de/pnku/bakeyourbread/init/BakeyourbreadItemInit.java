package de.pnku.bakeyourbread.init;

import de.pnku.bakeyourbread.BakeYourBread;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.core.Registry;

import static de.pnku.bakeyourbread.BakeYourBread.LOGGER;

public class BakeyourbreadItemInit {
    public static final Item UNCOOKED_BEETROOT_SOUP = new Item(new Item.Properties());
    public static final Item UNCOOKED_MUSHROOM_STEW = new Item(new Item.Properties());
    public static final Item UNCOOKED_RABBIT_STEW = new Item(new Item.Properties());
    public static final Item UNBAKED_BREAD = new Item(new Item.Properties());
    public static final Item UNBAKED_CAKE = new Item(new Item.Properties());
    public static final Item UNBAKED_COOKIE = new Item(new Item.Properties());
    public static final Item UNBAKED_PUMPKIN_PIE = new Item(new Item.Properties());


    public static void registerUncookedFoods() {
        registerUncookedFood(Items.BEETROOT_SOUP, UNCOOKED_BEETROOT_SOUP);
        registerUncookedFood(Items.MUSHROOM_STEW, UNCOOKED_MUSHROOM_STEW);
        registerUncookedFood(Items.RABBIT_STEW, UNCOOKED_RABBIT_STEW);

    }
    public static void registerUnbakedFoods() {
        registerUnbakedFood(Items.BREAD, UNBAKED_BREAD);
        registerUnbakedFood(Items.CAKE, UNBAKED_CAKE);
        registerUnbakedFood(Items.COOKIE, UNBAKED_COOKIE);
        registerUnbakedFood(Items.PUMPKIN_PIE, UNBAKED_PUMPKIN_PIE);
    }


    private static void registerUncookedFood(Item heatedItem, Item rawItem) {
        Registry.register(BuiltInRegistries.ITEM, BakeYourBread.asId("uncooked_" + heatedItem.getDescriptionId().replaceFirst("item.minecraft.", "")), rawItem);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(entries -> entries.addBefore(heatedItem, rawItem));
        LOGGER.info("Stews and soups are cooking...");
    }

    private static void registerUnbakedFood(Item heatedItem, Item rawItem) {
        Registry.register(BuiltInRegistries.ITEM, BakeYourBread.asId("unbaked_" + heatedItem.getDescriptionId().replaceFirst("item.minecraft.", "").replaceFirst("block.minecraft.","")), rawItem);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(entries -> entries.addBefore(heatedItem, rawItem));
        LOGGER.info("Breads, cakes, cookies and pies are baking...");
    }


}