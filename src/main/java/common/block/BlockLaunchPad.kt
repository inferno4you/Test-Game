package common.block

import common.world.World

class BlockLaunchPad(name: String) : Block(name) {

    override fun onBlockRightClick() {}

    override fun onBlockCollision() {}

    override fun onTick(world: World, x: Int, y: Int) {}

}
