package net.psychoticfairy.thefairyworldmod.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.psychoticfairy.thefairyworldmod.TheFairyWorldMod;
import net.psychoticfairy.thefairyworldmod.entity.ModEntities;
import net.psychoticfairy.thefairyworldmod.entity.custom.MermanEntity;

@Mod.EventBusSubscriber(modid = TheFairyWorldMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.MERMAN.get(), MermanEntity.createMobAttributes().build());
    }
}
