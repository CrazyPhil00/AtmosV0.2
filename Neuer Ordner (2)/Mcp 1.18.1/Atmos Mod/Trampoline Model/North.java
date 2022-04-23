Stream.of(
Block.makeCuboidShape(15, 0, 15, 16, 4, 16),
Block.makeCuboidShape(0, 4, 0, 16, 5, 16),
Block.makeCuboidShape(15, 0, 0, 16, 4, 1),
Block.makeCuboidShape(0, 0, 0, 1, 4, 1),
Block.makeCuboidShape(0, 0, 15, 1, 4, 16)
).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();