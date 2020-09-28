package io.github.lucunji.ccshark.blocks;

import io.github.lucunji.ccshark.MathHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class SandSharkBlock extends HorizontalBlock {

    private static final VoxelShape[] SHAPES;

    static {
        SHAPES = new VoxelShape[4];
        SHAPES[0] = VoxelShapes.or(
                Block.makeCuboidShape(4, 5, 4, 12, 13, 16),
                Block.makeCuboidShape(5, 6, 0, 11, 12, 4));
        SHAPES[1] = MathHelper.rotateShape(SHAPES[0], Direction.WEST);
        SHAPES[2] = MathHelper.rotateShape(SHAPES[0], Direction.NORTH);
        SHAPES[3] = MathHelper.rotateShape(SHAPES[0], Direction.EAST);
    }

    public SandSharkBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.getStateContainer().getBaseState().with(HORIZONTAL_FACING, Direction.SOUTH));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING);
    }

    private VoxelShape getShapeFromState(BlockState state) {
        return SHAPES[state.get(HORIZONTAL_FACING).getHorizontalIndex()];
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        return getShapeFromState(p_220053_1_);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing());
    }
}
