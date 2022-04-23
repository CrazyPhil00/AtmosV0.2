Stream.of(
Block.makeCuboidShape(-16, 0, -16, -15, 4, -15),
Block.makeCuboidShape(-16, 4, -16, 0, 5, 0),
Block.makeCuboidShape(-16, 0, -1, -15, 4, 0),
Block.makeCuboidShape(-1, 0, -1, 0, 4, 0),
Block.makeCuboidShape(-1, 0, -16, 0, 4, -15)
).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();