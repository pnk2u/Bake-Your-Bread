package de.pnku.bakeyourbread.init;

import de.pnku.bakeyourbread.BakeYourBread;
import de.pnku.bakeyourbread.item.BakeyourbreadFoodComponents;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.*;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Blocks;

import static de.pnku.bakeyourbread.BakeYourBread.LOGGER;

public class BakeyourbreadItemInit {
    public static final Item UNCOOKED_BEETROOT_SOUP = new Item(new Item.Properties().food(BakeyourbreadFoodComponents.UNCOOKED_BEETROUP_SOUP));
    public static final Item UNCOOKED_MUSHROOM_STEW = new Item(new Item.Properties().food(BakeyourbreadFoodComponents.UNCOOKED_MUSHROOM_STEW));
    public static final Item UNCOOKED_RABBIT_STEW = new Item(new Item.Properties().food(BakeyourbreadFoodComponents.UNCOOKED_RABBIT_STEW));
    public static final Item UNBAKED_BREAD = new Item(new Item.Properties().food(BakeyourbreadFoodComponents.BREAD_DOUGH));
    public static final Item UNBAKED_CAKE = new BlockItem(BakeyourbreadBlockInit.UNBAKED_CAKE, new Item.Properties().food(BakeyourbreadFoodComponents.UNBAKED_CAKE));
    public static final Item UNBAKED_COOKIE = new Item(new Item.Properties().food(BakeyourbreadFoodComponents.COOKIE_DOUGH));
    public static final Item UNBAKED_PUMPKIN_PIE = new Item(new Item.Properties().food(BakeyourbreadFoodComponents.PUMPKIN_PIE_DOUGH));


    public static void registerUncookedFoods() {
        LOGGER.info("Stews, Soups and Carrots are being cooked...");
        registerUncookedFood(Items.BEETROOT_SOUP, UNCOOKED_BEETROOT_SOUP);
        registerUncookedFood(Items.MUSHROOM_STEW, UNCOOKED_MUSHROOM_STEW);
        registerUncookedFood(Items.RABBIT_STEW, UNCOOKED_RABBIT_STEW);
    }
    public static void registerCookedFoods() {
    }
    public static void registerUnbakedFoods() {
        LOGGER.info("Bread, Cakes, Cookies and Pies are being baked...");
        registerUnbakedFood(Items.BREAD, UNBAKED_BREAD);
        registerUnbakedFood(Items.CAKE, UNBAKED_CAKE);
        registerUnbakedFood(Items.COOKIE, UNBAKED_COOKIE);
        registerUnbakedFood(Items.PUMPKIN_PIE, UNBAKED_PUMPKIN_PIE);
    }


    private static void registerUncookedFood(Item heatedItem, Item rawItem) {
        Registry.register(BuiltInRegistries.ITEM, BakeYourBread.withModId("uncooked_" + heatedItem.getDescriptionId().replaceFirst("item.minecraft.", "")), rawItem);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(entries -> entries.addBefore(heatedItem, rawItem));
    }

    private static void registerCookedFood(Item rawItem, Item heatedItem) {
        Registry.register(BuiltInRegistries.ITEM, BakeYourBread.withModId("cooked_" + rawItem.getDescriptionId().replaceFirst("item.minecraft.", "")), heatedItem);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(entries -> entries.addAfter(rawItem, heatedItem));
    }

    private static void registerUnbakedFood(Item heatedItem, Item rawItem) {
        Registry.register(BuiltInRegistries.ITEM, BakeYourBread.withModId("unbaked_" + heatedItem.getDescriptionId().replaceFirst("item.minecraft.", "").replaceFirst("block.minecraft.","")), rawItem);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(entries -> entries.addBefore(heatedItem, rawItem));
    }


}