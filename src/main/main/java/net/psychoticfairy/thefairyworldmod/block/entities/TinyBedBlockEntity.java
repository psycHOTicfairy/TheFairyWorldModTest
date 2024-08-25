package net.psychoticfairy.thefairyworldmod.block.entities;


import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TinyBedBlockEntity extends BlockEntity {
 //   private DyeColor color;

    public TinyBedBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.TINY_BED_BLOCK_ENTITY.get(), pPos, pBlockState);
  //      this.color = ((BedBlock)pBlockState.getBlock()).getColor();
    }

 //   public TinyBedBlockEntity(BlockPos pPos, BlockState pBlockState, DyeColor pColor) {
   //     super(BlockEntityType.BED, pPos, pBlockState);
  //      this.color = pColor;
   // }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

 //   public DyeColor getColor() {
  //      return this.color;
  //  }

  //  public void setColor(DyeColor pColor) {
  //      this.color = pColor;
   // }
//}
}
