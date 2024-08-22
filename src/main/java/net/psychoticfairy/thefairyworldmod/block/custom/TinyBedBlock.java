package net.psychoticfairy.thefairyworldmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.psychoticfairy.thefairyworldmod.block.entities.TinyBedBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TinyBedBlock extends BedBlock {
    public static final VoxelShape SHAPE = Block.box(0,0,0,3,2,5);
    public static final BooleanProperty OCCUPIED = BooleanProperty.create("occupied");
    public TinyBedBlock(DyeColor pColor, BlockBehaviour.Properties pProperties) {
        super(pColor, pProperties);

        this.registerDefaultState((BlockState) ((BlockState) ((BlockState) this.stateDefinition.any()).setValue(OCCUPIED, false)));
    }


    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;

    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }
    public static boolean canSetSpawn(Level pLevel) {
        return pLevel.dimensionType().bedWorks();
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide) {
            return InteractionResult.CONSUME;

        } else if (!canSetSpawn(pLevel)) {
            if (!pLevel.isClientSide) {
                return InteractionResult.sidedSuccess(pLevel.isClientSide);
            }
            Vec3 $$7 = pPos.getCenter();
            pLevel.explode((Entity) null, pLevel.damageSources().badRespawnPointExplosion($$7), (ExplosionDamageCalculator) null, $$7, 5.0F, true, Level.ExplosionInteraction.BLOCK);
            return InteractionResult.SUCCESS;
        } else if ((Boolean) pState.getValue(OCCUPIED)) {
            if (!this.kickVillagerOutOfBed(pLevel, pPos)) {
                pPlayer.displayClientMessage(Component.translatable("block.minecraft.bed.occupied"), true);
            }

        } else {
            pPlayer.startSleepInBed(pPos).ifLeft((p_49477_) -> {
                if (p_49477_.getMessage() != null) {
                    pPlayer.displayClientMessage(p_49477_.getMessage(), true);
                }

            });
            return InteractionResult.SUCCESS;

        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    private boolean kickVillagerOutOfBed(Level pLevel, BlockPos pPos) {
        List<Villager> $$2 = pLevel.getEntitiesOfClass(Villager.class, new AABB(pPos), LivingEntity::isSleeping);
        if ($$2.isEmpty()) {
            return false;
        } else {
            ((Villager) $$2.get(0)).stopSleeping();
            return true;



}}

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pBlockState) {
        return new TinyBedBlockEntity(pPos, pBlockState);
    }
}