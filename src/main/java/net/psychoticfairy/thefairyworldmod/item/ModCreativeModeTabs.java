package net.psychoticfairy.thefairyworldmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.psychoticfairy.thefairyworldmod.TheFairyWorldMod;
import net.psychoticfairy.thefairyworldmod.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheFairyWorldMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> THE_FAIRY_WORLD_TAB = CREATIVE_MODE_TABS.register("the_fairy_world_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PINEAPPLE_SKIN.get()))
                    .title(Component.translatable("creativetab.the_fairy_world_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.PINEAPPLE_SKIN_CHESTPLATE.get());
                        pOutput.accept(ModItems.PINEAPPLE_SKIN.get());
                        pOutput.accept(ModItems.PEARL.get());
                        pOutput.accept(ModItems.MAGIC_WAND.get());

                        pOutput.accept(ModItems.PINEAPPLE.get());

                        pOutput.accept(ModItems.PINEAPPLE_SKIN_HELMET.get());
                        pOutput.accept(ModItems.PINEAPPLE_SKIN_CHESTPLATE.get());
                        pOutput.accept(ModItems.PINEAPPLE_SKIN_LEGGINGS.get());
                        pOutput.accept(ModItems.PINEAPPLE_SKIN_BOOTS.get());

                        pOutput.accept(ModBlocks.FAIRY_ALTAR.get());
                        pOutput.accept(ModBlocks.PERIDOTITE_BLOCK.get());

                        pOutput.accept(ModBlocks.TINY_BED.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
