package net.psychoticfairy.thefairyworldmod.item;

import com.mojang.authlib.yggdrasil.ServicesKeyInfo;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.psychoticfairy.thefairyworldmod.TheFairyWorldMod;
import net.psychoticfairy.thefairyworldmod.item.custom.WandItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TheFairyWorldMod.MOD_ID);

    public static final RegistryObject<Item> PINEAPPLE_SKIN = ITEMS.register("pineapple_skin",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PINEAPPLE_SKIN_CHESTPLATE = ITEMS.register("pineapple_skin_chestplate",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PINEAPPLE = ITEMS.register("pineapple",
            () -> new Item(new Item.Properties().food(ModFoods.PINEAPPLE)));
    public static final RegistryObject<Item> PERIDOTITE = ITEMS.register("peridotite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PEARL = ITEMS.register("pearl",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAGIC_WAND = ITEMS.register("magic_wand",
            () -> new WandItem(new Item.Properties().durability(500)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }}
