package dev.threeadd.packetentities.util;

public class ChunkKeyUtils {

    public static long toLongKey(double locX, double locZ) {
        return toLongKey((int) Math.floor(locX) >> 4, (int) Math.floor(locZ) >> 4);
    }

    public static long toLongKey(int chunkX, int chunkZ) {
        return ((long) chunkX << 32) | (chunkZ & 0xFFFFFFFFL);
    }

}
