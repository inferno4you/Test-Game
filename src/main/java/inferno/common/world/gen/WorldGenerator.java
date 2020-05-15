package inferno.common.world.gen;

import inferno.common.world.World;
import inferno.utils.Referance;

public abstract class WorldGenerator {
    private World world;
    private long seed;

    public WorldGenerator(World world){
        world = world;
        seed = Referance.RANDOM.nextLong();
    }

    public abstract void generate();
}