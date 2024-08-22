package net.psychoticfairy.thefairyworldmod.block.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.psychoticfairy.thefairyworldmod.TheFairyWorldMod;
import net.psychoticfairy.thefairyworldmod.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TheFairyWorldMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<TinyBedBlockEntity>> TINY_BED_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("tiny_bed_block_entity", () ->
                    BlockEntityType.Builder.of(TinyBedBlockEntity::new,
                            ModBlocks.TINY_BED.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}