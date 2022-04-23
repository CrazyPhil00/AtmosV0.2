Stream.of(
Block.makeCuboidShape(15, 0, -16, 16, 4, -15),
Block.makeCuboidShape(0, 4, -16, 16, 5, 0),
Block.makeCuboidShape(0, 0, -16, 1, 4, -15),
Block.makeCuboidShape(0, 0, -1, 1, 4, 0),
Block.makeCuboidShape(15, 0, -1, 16, 4, 0)
).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();