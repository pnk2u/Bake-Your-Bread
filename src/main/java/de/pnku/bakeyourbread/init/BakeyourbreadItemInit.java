package de.pnku.bakeyourbread.init;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.core.Registry;
import net.minecraft.world.item.component.Consumable;

import static de.pnku.bakeyourbread.BakeYourBread.*;
import static de.pnku.bakeyourbread.item.BakeyourbreadFoodComponents.*;

public class BakeyourbreadItemInit {
    public static final Item UNCOOKED_BEETROOT_SOUP = new Item(setFoodProperties("uncooked_beetroot_soup", UNCOOKED_BEETROOT_SOUP_F).usingConvertsTo(Items.BOWL));
    public static final Item UNCOOKED_MUSHROOM_STEW = new Item(setFoodProperties("uncooked_mushroom_stew", UNCOOKED_MUSHROOM_STEW_F).usingConvertsTo(Items.BOWL));
    public static final Item UNCOOKED_RABBIT_STEW = new Item(setFoodProperties("uncooked_rabbit_stew", UNCOOKED_RABBIT_STEW_F, UNCOOKED_RABBIT_STEW_C).usingConvertsTo(Items.BOWL));
    public static final Item UNBAKED_BREAD = new Item(setFoodProperties("unbaked_bread", BREAD_DOUGH_F, BREAD_DOUGH_C));
    public static final Item UNBAKED_CAKE = new Item(setFoodProperties("unbaked_cake", UNBAKED_CAKE_F, UNBAKED_CAKE_C));
    public static final Item UNBAKED_COOKIE = new Item(setFoodProperties("unbaked_cookie", COOKIE_DOUGH_F, COOKIE_DOUGH_C));
    public static final Item UNBAKED_PUMPKIN_PIE = new Item(setFoodProperties("unbaked_pumpkin_pie", PUMPKIN_PIE_DOUGH_F, PUMPKIN_PIE_DOUGH_C));

    public static Item.Properties setFoodProperties(String foodName, FoodProperties foodProperties) {
        return new Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM, asId(foodName)))
                .food(foodProperties);
    }
    public static Item.Properties setFoodProperties(String foodName, FoodProperties foodProperties, Consumable consumable) {
        return new Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM, asId(foodName)))
                .food(foodProperties, consumable);
    }

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
        Registry.register(BuiltInRegistries.ITEM, asId("uncooked_" + heatedItem.getDescriptionId().replaceFirst("item.minecraft.", "")), rawItem);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(entries -> entries.addBefore(heatedItem, rawItem));
        LOGGER.info("Stews and soups are cooking...");
    }

    private static void registerUnbakedFood(Item heatedItem, Item rawItem) {
        Registry.register(BuiltInRegistries.ITEM, asId("unbaked_" + heatedItem.getDescriptionId().replaceFirst("item.minecraft.", "").replaceFirst("block.minecraft.","")), rawItem);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(entries -> entries.addBefore(heatedItem, rawItem));
        LOGGER.info("Breads, cakes, cookies and pies are baking...");
    }


}