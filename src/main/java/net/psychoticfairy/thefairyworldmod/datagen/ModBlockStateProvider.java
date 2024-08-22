package net.psychoticfairy.thefairyworldmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.psychoticfairy.thefairyworldmod.TheFairyWorldMod;
import net.psychoticfairy.thefairyworldmod.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TheFairyWorldMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.PERIDOTITE_BLOCK);
        blockWithItem(ModBlocks.FAIRY_ALTAR);

        simpleBlock(ModBlocks.TINY_BED.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/tiny_bed")));

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
