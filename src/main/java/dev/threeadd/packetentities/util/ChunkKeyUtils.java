package dev.threeadd.packetentities.util;

import com.github.retrooper.packetevents.util.Vector3d;

public class ChunkKeyUtils {

    public static long toLongKey(Vector3d position) {
        return toLongKey((int) Math.floor(position.getX()) >> 4, (int) Math.floor(position.getZ()) >> 4);
    }

    public static long toLongKey(int chunkX, int chunkZ) {
        return ((long) chunkX << 32) | (chunkZ & 0xFFFFFFFFL);
    }

}
