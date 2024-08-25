package net.psychoticfairy.thefairyworldmod.entity;


import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.psychoticfairy.thefairyworldmod.TheFairyWorldMod;
import net.minecraft.world.entity.EntityType;
import net.psychoticfairy.thefairyworldmod.entity.custom.MermanEntity;

import java.awt.event.InputEvent;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TheFairyWorldMod.MOD_ID);

    public static final RegistryObject<EntityType<MermanEntity>> MERMAN =
            ENTITY_TYPES.register("merman",
                    () -> EntityType.Builder.of(MermanEntity::new, MobCategory.WATER_CREATURE)
                    .sized(.4f,1.5f)
                    .build("merman"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
