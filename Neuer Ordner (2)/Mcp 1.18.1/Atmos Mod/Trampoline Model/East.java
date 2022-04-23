Stream.of(
Block.makeCuboidShape(-16, 0, 15, -15, 4, 16),
Block.makeCuboidShape(-16, 4, 0, 0, 5, 16),
Block.makeCuboidShape(-1, 0, 15, 0, 4, 16),
Block.makeCuboidShape(-1, 0, 0, 0, 4, 1),
Block.makeCuboidShape(-16, 0, 0, -15, 4, 1)
).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();