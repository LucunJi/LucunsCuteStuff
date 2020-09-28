package io.github.lucunji.ccshark;

import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

public class MathHelper {
    /**
     * @param direction the default direction is SOUTH, in which no rotation will be applied
     * @return the shape rotated according to the direction with the center in the middle of the block (8, 8, 8)
     */
    public static VoxelShape rotateShape(VoxelShape shape, Direction direction) {
        switch (direction) {
            case SOUTH:
                return shape;
            case EAST:
                VoxelShape voxelShape1 = VoxelShapes.empty();
                for (AxisAlignedBB aabb : shape.toBoundingBoxList()) {
                    voxelShape1 = VoxelShapes.or(voxelShape1, Block.makeCuboidShape(aabb.minZ * 16, aabb.minY * 16, (1-aabb.maxX) * 16, aabb.maxZ * 16, aabb.maxY * 16, (1-aabb.minX) * 16));
                }
                return voxelShape1;
            case NORTH:
                VoxelShape voxelShape2 = VoxelShapes.empty();
                for (AxisAlignedBB aabb : shape.toBoundingBoxList()) {
                    voxelShape2 = VoxelShapes.or(voxelShape2, Block.makeCuboidShape((1-aabb.maxX) * 16, aabb.minY * 16, (1-aabb.maxZ) * 16, (1-aabb.minX) * 16, aabb.maxY * 16, (1-aabb.minZ) * 16));
                }
                return voxelShape2;
            case WEST:
                VoxelShape voxelShape3 = VoxelShapes.empty();
                for (AxisAlignedBB aabb : shape.toBoundingBoxList()) {
                    voxelShape3 = VoxelShapes.or(voxelShape3, Block.makeCuboidShape((1-aabb.maxZ) * 16, aabb.minY * 16, aabb.minX * 16, (1-aabb.minZ) * 16, aabb.maxY * 16, aabb.maxX * 16));
                }
                return voxelShape3;
            default:
                return shape;
        }
    }
}
