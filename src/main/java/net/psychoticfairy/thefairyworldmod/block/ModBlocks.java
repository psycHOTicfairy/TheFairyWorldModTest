package net.psychoticfairy.thefairyworldmod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.psychoticfairy.thefairyworldmod.TheFairyWorldMod;



import net.psychoticfairy.thefairyworldmod.block.custom.TinyBedBlock;
import net.psychoticfairy.thefairyworldmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, TheFairyWorldMod.MOD_ID);


    public static final RegistryObject<Block> FAIRY_ALTAR = registerBlock("fairy_altar",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> PERIDOTITE_BLOCK = registerBlock("peridotite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> TINY_BED = registerBlock("tiny_bed",
            () -> new TinyBedBlock(DyeColor.RED, BlockBehaviour.Properties.copy(Blocks.BLACK_BED).noOcclusion()));


    //if I want to add ores vvvvv this is the code
    //public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
    //        () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).
    //                strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;

    }


    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block)  {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }


}
