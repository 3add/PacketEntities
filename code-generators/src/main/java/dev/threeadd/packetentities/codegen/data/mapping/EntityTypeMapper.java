package dev.threeadd.packetentities.codegen.data.mapping;

import java.util.Locale;
import java.util.Map;

public final class EntityTypeMapper {

    // TODO no ai has yet been used, use AI!
    private static final Map<String, String> MANUAL_OVERRIDES = Map.ofEntries(
            Map.entry("Projectile", "PROJECTILE_ABSTRACT"),
            Map.entry("AbstractBoat", "BOAT"), // closest match in current pe; "vehicle" is missing from pe
            Map.entry("AbstractChestBoat", "CHEST_BOAT"), // closest match in current pe
            Map.entry("LivingEntity", "LIVINGENTITY"),
            Map.entry("AgableMob", "ABSTRACT_AGEABLE"), // closest match in current pe; "mob" is missing from pe
            Map.entry("AgeableMob", "ABSTRACT_AGEABLE"), // closest match in current pe
            Map.entry("Animal", "ABSTRACT_ANIMAL"), // closest match in current pe
            Map.entry("AbstractChestedHorse", "CHESTED_HORSE"), // closest match in current pe
            Map.entry("AbstractCow", "COW"), // closest match in current pe
            Map.entry("WaterAnimal", "ABSTRACT_WATERMOB"), // closest match in current pe
            Map.entry("AgeableWaterCreature", "ABSTRACT_WATERMOB"), // closest match in current pe
            Map.entry("AbstractFish", "ABSTRACT_FISHES"), // closest match in current pe
            Map.entry("Monster", "ABSTRACT_MONSTER"), // closest match in current pe
            Map.entry("AbstractIllager", "ABSTRACT_ILLAGER_BASE"), // closest match in current pe
            Map.entry("AbstractMinecart", "MINECART_ABSTRACT"), // closest match in current pe
            Map.entry("AbstractVillager", "VILLAGER"), // closest match in current pe
            Map.entry("AmbientCreature", "ABSTRACT_AMBIENT"), // closest match in current pe
            Map.entry("EnderMan", "ENDERMAN"),
            Map.entry("FallingBlockEntity", "FALLING_BLOCK"),
            Map.entry("FireworkRocketEntity", "FIREWORK_ROCKET"),
            Map.entry("FishingHook", "FISHING_BOBBER"),
            Map.entry("FlyingMob", "ABSTRACT_FLYING"), // closest match in current pe
            Map.entry("HangingEntity", "ABSTRACT_HANGING"),
            Map.entry("ItemEntity", "ITEM"), // closest match in current pe
            Map.entry("LargeFireball", "FIREBALL"), // closest match in current pe
            Map.entry("LeashFenceKnotEntity", "LEASH_KNOT"), // closest match in current pe
            Map.entry("MinecartCommandBlock", "COMMAND_BLOCK_MINECART"), // closest match in current pe
            Map.entry("MinecartSpawner", "SPAWNER_MINECART"), // closest match in current pe
            Map.entry("PigZombie", "ZOMBIFIED_PIGLIN"), // closest match in current pe
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

    /** Converts a class name to its default (non-overridden) upper-snake-case constant form. */
    public static String defaultConstantName(String metaClassName) {
        return metaClassName.replaceAll("([a-z])([A-Z]+)", "$1_$2").toUpperCase(Locale.ENGLISH);
    }

    /** Resolves the packetevents {@code EntityTypes} constant name for a meta class name. */
    public static String resolveConstantName(String metaClassName) {
        String override = MANUAL_OVERRIDES.get(metaClassName);
        return override != null ? override : defaultConstantName(metaClassName);
    }

}
