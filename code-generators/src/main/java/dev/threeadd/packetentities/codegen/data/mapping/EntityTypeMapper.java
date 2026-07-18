package dev.threeadd.packetentities.codegen.data.mapping;

import java.util.Locale;
import java.util.Map;

public final class EntityTypeMapper {

    private static final Map<String, String> MANUAL_OVERRIDES = Map.ofEntries(
            Map.entry("Projectile", "PROJECTILE_ABSTRACT"),
            // vehicle is missing from pe
            Map.entry("AbstractBoat", "BOAT"), // I think this is closest in current pe
            Map.entry("AbstractChestBoat", "CHEST_BOAT"), // I think this is closest in current pe
            Map.entry("LivingEntity", "LIVINGENTITY"),
            // mob is missing from pe
            // pathfinder mob is missing from pe
            Map.entry("AgableMob", "ABSTRACT_AGEABLE"), // I think this is closest in current pe
            Map.entry("AgeableMob", "ABSTRACT_AGEABLE"), // I think this is closest in current pe
            Map.entry("Animal", "ABSTRACT_ANIMAL"), // I think this is closest in current pe
            Map.entry("AbstractChestedHorse", "CHESTED_HORSE"), // I think this is closest in current pe
            Map.entry("AbstractCow", "COW"), // I think this is closest in current pe
            // abstract cube mob is missing from pe
            Map.entry("WaterAnimal", "ABSTRACT_WATERMOB"), // I think this is closest in current pe
            Map.entry("AgeableWaterCreature", "ABSTRACT_WATERMOB"), // I think this is closest in current pe
            Map.entry("AbstractFish", "ABSTRACT_FISHES"), // I think this is closest in current pe
            // abstract hurting projectile is missing from pe
            Map.entry("Monster", "ABSTRACT_MONSTER"), // I think this is closest in current pe
            // patrolling monster is missing from pe
            // raider is missing from pe
            Map.entry("AbstractIllager", "ABSTRACT_ILLAGER_BASE"), // I think this is closest in current pe
            Map.entry("AbstractMinecart", "MINECART_ABSTRACT"), // I think this is closest in current pe
            // abstract minecart container is missing from pe
            // tamable animal is missing from pe
            // abstract schooling fish is missing from pe
            // throwable projectile is missing from pe
            // throwable item projectile is missing from pe
            // abstract thrown potion is missing from pe
            Map.entry("AbstractVillager", "VILLAGER"), // I think this is closest in current pe
            Map.entry("AmbientCreature", "ABSTRACT_AMBIENT"), // I think this is closest in current pe
            // block attached entity is missing from pe
            // chest raft is missing from pe
            Map.entry("EnderMan", "ENDERMAN"),
            // spellcaster illager is missing from pe
            Map.entry("FallingBlockEntity", "FALLING_BLOCK"),
            Map.entry("FireworkRocketEntity", "FIREWORK_ROCKET"),
            Map.entry("FishingHook", "FISHING_BOBBER"),
            Map.entry("FlyingMob", "ABSTRACT_FLYING"), // I think this is closest in current pe
            Map.entry("HangingEntity", "ABSTRACT_HANGING"),
            Map.entry("ItemEntity", "ITEM"), // I think this is closest in current pe
            Map.entry("LargeFireball", "FIREBALL"), // I think this is closest in current pe
            Map.entry("LeashFenceKnotEntity", "LEASH_KNOT"), // I think this is closest in current pe
            Map.entry("MinecartCommandBlock", "COMMAND_BLOCK_MINECART"), // I think this is closest in current pe
            Map.entry("MinecartSpawner", "SPAWNER_MINECART"), // I think this is closest in current pe
            // mushroom cow is missing from pe
            // shoulder riding entity is missing from pe
            Map.entry("PigZombie", "ZOMBIFIED_PIGLIN"), // I think this is closest in current pe
            // raft is missing from pe
            Map.entry("ThrownEgg", "EGG"),
            Map.entry("ThrownEnderpearl", "ENDER_PEARL"),
            Map.entry("ThrownExperienceBottle", "EXPERIENCE_BOTTLE"),
            Map.entry("ThrownLingeringPotion", "LINGERING_POTION"),
            Map.entry("ThrownPotion", "POTION"),
            Map.entry("ThrownSplashPotion", "SPLASH_POTION"),
            Map.entry("ThrownTrident", "TRIDENT"),
            Map.entry("WitherBoss", "WITHER")
    );

    private EntityTypeMapper() {
    }

    public static String defaultConstantName(String metaClassName) {
        return metaClassName.replaceAll("([a-z])([A-Z]+)", "$1_$2").toUpperCase(Locale.ENGLISH);
    }

    public static String resolveConstantName(String metaClassName) {
        String override = MANUAL_OVERRIDES.get(metaClassName);
        return override != null ? override : defaultConstantName(metaClassName);
    }

}
