package common.block;

import common.world.World;

public class BlockLeaf extends Block {
    public BlockLeaf(String name) {
        super(name);
    }

    @Override
    public void onBlockRightClick() { }

    @Override
    public void onBlockCollision() { }

    @Override
    public void onTick(World world, int x, int y) { }

}
