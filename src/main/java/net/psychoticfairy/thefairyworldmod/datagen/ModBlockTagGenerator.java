package net.psychoticfairy.thefairyworldmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.psychoticfairy.thefairyworldmod.TheFairyWorldMod;
import net.psychoticfairy.thefairyworldmod.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TheFairyWorldMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
  //      this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
  //              .add(ModBlocks.SAPPHIRE_ORE.get()).addTag(Tags.Blocks.ORES)
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PERIDOTITE_BLOCK.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.PERIDOTITE_BLOCK.get()
                        ,ModBlocks.TINY_BED.get()

                //,ModBlocks.RAW_SAPPHIRE_BLOCK.get()
                        );
    }
}
