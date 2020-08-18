package com.tertfret.gemstone_addon.common.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class GemstoneWorkbench extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    // Voxel shapes for collision box
    public static final VoxelShape SHAPE_N = Stream
            .of(Block.makeCuboidShape(0, 12, 0, 32, 15, 16), Block.makeCuboidShape(28, 0, 12, 31, 12, 15),
                    Block.makeCuboidShape(28, 0, 1, 31, 12, 4), Block.makeCuboidShape(0, 0, 0, 16, 12, 16),
                    Block.makeCuboidShape(6, 15, 10, 9, 16, 12), Block.makeCuboidShape(7, 15, 6, 8, 16, 10),
                    Block.makeCuboidShape(28, 15, 10, 30, 16, 11), Block.makeCuboidShape(27, 15, 9, 30, 16, 10),
                    Block.makeCuboidShape(28, 15, 6, 29, 16, 9), Block.makeCuboidShape(22, 15, 10, 23, 16, 12),
                    Block.makeCuboidShape(24, 15, 10, 25, 16, 12), Block.makeCuboidShape(22, 15, 13, 23, 16, 15),
                    Block.makeCuboidShape(24, 15, 13, 25, 16, 15), Block.makeCuboidShape(23, 15, 12, 24, 16, 13))
            .reduce((v1, v2) -> {
                return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
            }).get();

    public static final VoxelShape SHAPE_E = Stream
            .of(Block.makeCuboidShape(0, 12, 0, 16, 15, 32), Block.makeCuboidShape(1, 0, 28, 4, 12, 31),
                    Block.makeCuboidShape(12, 0, 28, 15, 12, 31), Block.makeCuboidShape(0, 0, 0, 16, 12, 16),
                    Block.makeCuboidShape(4, 15, 6, 6, 16, 9), Block.makeCuboidShape(6, 15, 7, 10, 16, 8),
                    Block.makeCuboidShape(5, 15, 28, 6, 16, 30), Block.makeCuboidShape(6, 15, 27, 7, 16, 30),
                    Block.makeCuboidShape(7, 15, 28, 10, 16, 29), Block.makeCuboidShape(4, 15, 22, 6, 16, 23),
                    Block.makeCuboidShape(4, 15, 24, 6, 16, 25), Block.makeCuboidShape(1, 15, 22, 3, 16, 23),
                    Block.makeCuboidShape(1, 15, 24, 3, 16, 25), Block.makeCuboidShape(3, 15, 23, 4, 16, 24))
            .reduce((v1, v2) -> {
                return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
            }).get();

    public static final VoxelShape SHAPE_S = Stream
            .of(Block.makeCuboidShape(-16, 12, 0, 16, 15, 16), Block.makeCuboidShape(-15, 0, 1, -12, 12, 4),
                    Block.makeCuboidShape(-15, 0, 12, -12, 12, 15), Block.makeCuboidShape(0, 0, 0, 16, 12, 16),
                    Block.makeCuboidShape(7, 15, 4, 10, 16, 6), Block.makeCuboidShape(8, 15, 6, 9, 16, 10),
                    Block.makeCuboidShape(-14, 15, 5, -12, 16, 6), Block.makeCuboidShape(-14, 15, 6, -11, 16, 7),
                    Block.makeCuboidShape(-13, 15, 7, -12, 16, 10), Block.makeCuboidShape(-7, 15, 4, -6, 16, 6),
                    Block.makeCuboidShape(-9, 15, 4, -8, 16, 6), Block.makeCuboidShape(-7, 15, 1, -6, 16, 3),
                    Block.makeCuboidShape(-9, 15, 1, -8, 16, 3), Block.makeCuboidShape(-8, 15, 3, -7, 16, 4))
            .reduce((v1, v2) -> {
                return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
            }).get();

    public static final VoxelShape SHAPE_W = Stream
            .of(Block.makeCuboidShape(0, 12, -16, 16, 15, 16), Block.makeCuboidShape(12, 0, -15, 15, 12, -12),
                    Block.makeCuboidShape(1, 0, -15, 4, 12, -12), Block.makeCuboidShape(0, 0, 0, 16, 12, 16),
                    Block.makeCuboidShape(10, 15, 7, 12, 16, 10), Block.makeCuboidShape(6, 15, 8, 10, 16, 9),
                    Block.makeCuboidShape(10, 15, -14, 11, 16, -12), Block.makeCuboidShape(9, 15, -14, 10, 16, -11),
                    Block.makeCuboidShape(6, 15, -13, 9, 16, -12), Block.makeCuboidShape(10, 15, -7, 12, 16, -6),
                    Block.makeCuboidShape(10, 15, -9, 12, 16, -8), Block.makeCuboidShape(13, 15, -7, 15, 16, -6),
                    Block.makeCuboidShape(13, 15, -9, 15, 16, -8), Block.makeCuboidShape(12, 15, -8, 13, 16, -7))
            .reduce((v1, v2) -> {
                return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
            }).get();

    public GemstoneWorkbench() {
        super(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.5f, 4.2f).sound(SoundType.WOOD)
                .harvestLevel(0).harvestTool(ToolType.AXE));
    }

    // Placement of collision box
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    // Making sure the block is placed right from where you're looking
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    // Ambient occlusion value
    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.9f;
    }

}