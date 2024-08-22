package net.psychoticfairy.thefairyworldmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.psychoticfairy.thefairyworldmod.TheFairyWorldMod;
import net.psychoticfairy.thefairyworldmod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TheFairyWorldMod.MOD_ID, existingFileHelper);
    }


    @Override
    protected void registerModels() {
            simpleItem(ModItems.PEARL);
            simpleItem(ModItems.MAGIC_WAND);
            simpleItem(ModItems.PINEAPPLE);
            simpleItem(ModItems.PINEAPPLE_SKIN);
            simpleItem(ModItems.PINEAPPLE_SKIN_CHESTPLATE);
            simpleItem(ModItems.PERIDOTITE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TheFairyWorldMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
