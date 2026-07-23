package dev.threeadd.packetentities.entity.status;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityStatus;

/**
 * Represents Entity Statuses used in the {@link WrapperPlayServerEntityStatus}, categorized by entity type.
 * <br>
 * <strong>This is not version agnostic, current values are for {@code 26.2}</strong>
 * <br>
 * You may implement your own version's entity status like below:
 * <pre>{@code
 * // suggested to store as public static final values
 * public static final EntityStatus HONEY_SLIDE = new EntityStatus(EntityTypes.ENTITY, 53);
 * }</pre>
 */
public record EntityStatus(EntityType boundType, int index) {

    public static final class Entity {

        /**
         * Spawns honey block slide particles at the entity's feet.
         */
        public static final EntityStatus HONEY_SLIDE = new EntityStatus(null, 53);

    }

    public static final class Arrow {

        /**
         * Spawns tipped arrow particle effects.
         */
        public static final EntityStatus TIPPED_PARTICLES = new EntityStatus(EntityTypes.ARROW, 0);

    }

    public static final class Snowball {

        /**
         * Displays 8 snowball poof particles.
         */
        public static final EntityStatus PARTICLES = new EntityStatus(EntityTypes.SNOWBALL, 3);

    }

    public static final class Egg {

        /**
         * Displays 8 icon crack particles with the egg as a parameter.
         */
        public static final EntityStatus PARTICLES = new EntityStatus(EntityTypes.EGG, 3);

    }

    public static final class FishingHook {

        /**
         * Pulls the caught entity toward the caster.
         */
        public static final EntityStatus PULL = new EntityStatus(EntityTypes.FISHING_BOBBER, 31);

    }

    public static final class FireworkRocket {

        /**
         * Triggers the firework explosion effect.
         */
        public static final EntityStatus EXPLOSION = new EntityStatus(EntityTypes.FIREWORK_ROCKET, 17);

    }

    public static final class EvokerFangs {

        /**
         * Starts the attack animation and plays the evocation fangs attack sound.
         */
        public static final EntityStatus ATTACK = new EntityStatus(EntityTypes.EVOKER_FANGS, 4);

    }

    public static final class LivingEntity {

        /**
         * Plays the spear charge attack animation.
         */
        public static final EntityStatus SPEAR_CHARGE = new EntityStatus(null, 2);
        /**
         * Plays the death sound and death animation.
         */
        public static final EntityStatus DEATH = new EntityStatus(null, 3);
        /**
         * Plays the shield block sound.
         */
        public static final EntityStatus SHIELD_BLOCK = new EntityStatus(null, 29);
        /**
         * Plays the shield break sound.
         */
        public static final EntityStatus SHIELD_BREAK = new EntityStatus(null, 30);
        /**
         * Plays totem of undying animation and sound.
         */
        public static final EntityStatus TOTEM_OF_UNDYING = new EntityStatus(null, 35);
        /**
         * Spawns portal particles when teleporting (Chorus fruit/Enderman).
         */
        public static final EntityStatus TELEPORT = new EntityStatus(null, 46);
        /**
         * Plays equipment break sound and spawns break particles (main hand).
         */
        public static final EntityStatus BREAK_MAINHAND = new EntityStatus(null, 47);
        /**
         * Plays equipment break sound and spawns break particles (off hand).
         */
        public static final EntityStatus BREAK_OFFHAND = new EntityStatus(null, 48);
        /**
         * Plays equipment break sound and spawns break particles (head).
         */
        public static final EntityStatus BREAK_HEAD = new EntityStatus(null, 49);
        /**
         * Plays equipment break sound and spawns break particles (chest).
         */
        public static final EntityStatus BREAK_CHEST = new EntityStatus(null, 50);
        /**
         * Plays equipment break sound and spawns break particles (legs).
         */
        public static final EntityStatus BREAK_LEGS = new EntityStatus(null, 51);
        /**
         * Plays equipment break sound and spawns break particles (feet).
         */
        public static final EntityStatus BREAK_FEET = new EntityStatus(null, 52);
        /**
         * Spawns honey block fall particles at the entity's feet.
         */
        public static final EntityStatus HONEY_FALL = new EntityStatus(null, 54);
        /**
         * Swaps the hand items of the entity.
         */
        public static final EntityStatus SWAP_HANDS = new EntityStatus(null, 55);
        /**
         * Spawns death smoke particles.
         */
        public static final EntityStatus DEATH_SMOKE = new EntityStatus(null, 60);

    }

    public static final class Player {

        /**
         * Marks item use as finished (finished eating, finished drinking, etc.).
         */
        public static final EntityStatus FINISH_ITEM_USE = new EntityStatus(EntityTypes.PLAYER, 9);
        public static final EntityStatus ENABLE_REDUCED_DEBUG = new EntityStatus(EntityTypes.PLAYER, 22);
        public static final EntityStatus DISABLE_REDUCED_DEBUG = new EntityStatus(EntityTypes.PLAYER, 23);
        public static final EntityStatus OP_LEVEL_0 = new EntityStatus(EntityTypes.PLAYER, 24);
        public static final EntityStatus OP_LEVEL_1 = new EntityStatus(EntityTypes.PLAYER, 25);
        public static final EntityStatus OP_LEVEL_2 = new EntityStatus(EntityTypes.PLAYER, 26);
        public static final EntityStatus OP_LEVEL_3 = new EntityStatus(EntityTypes.PLAYER, 27);
        public static final EntityStatus OP_LEVEL_4 = new EntityStatus(EntityTypes.PLAYER, 28);
        /**
         * Spawns cloud particles at the player (Bad Omen removed).
         */
        public static final EntityStatus BAD_OMEN_CLOUD = new EntityStatus(EntityTypes.PLAYER, 43);

    }

    public static final class ArmorStand {

        /**
         * Plays the hit sound, and resets a hit cooldown.
         */
        public static final EntityStatus HIT = new EntityStatus(EntityTypes.ARMOR_STAND, 32);

    }

    public static final class Mob {

        /**
         * Spawns explosion particle (Silverfish enter/exit, Mob Spawner).
         */
        public static final EntityStatus EXPLOSION_PARTICLE = new EntityStatus(null, 20);

    }

    public static final class Animal {

        /**
         * Spawns "love mode" heart particles.
         */
        public static final EntityStatus LOVE_MODE = new EntityStatus(null, 18);

    }

    public static final class AbstractHorse {

        /**
         * Spawns smoke particles (taming failed).
         */
        public static final EntityStatus TAMING_FAILED = new EntityStatus(null, 6);
        /**
         * Spawns heart particles (taming succeeded).
         */
        public static final EntityStatus TAMING_SUCCEEDED = new EntityStatus(null, 7);

    }

    public static final class TameableAnimal {

        /**
         * Spawns smoke particles (taming failed).
         */
        public static final EntityStatus TAMING_FAILED = new EntityStatus(null, 6);
        /**
         * Spawns heart particles (taming succeeded).
         */
        public static final EntityStatus TAMING_SUCCEEDED = new EntityStatus(null, 7);

    }

    public static final class Wolf {

        /**
         * Plays wolf shaking water animation.
         */
        public static final EntityStatus SHAKE_WATER = new EntityStatus(EntityTypes.WOLF, 8);
        /**
         * Stops wolf shaking water animation.
         */
        public static final EntityStatus STOP_SHAKE_WATER = new EntityStatus(EntityTypes.WOLF, 56);

    }

    public static final class Rabbit {

        /**
         * Causes the rabbit to use its rotated jumping animation and display particles.
         */
        public static final EntityStatus JUMP = new EntityStatus(EntityTypes.RABBIT, 1);

    }

    public static final class Sheep {

        /**
         * Causes the sheep to play the eating grass animation for the next 40 ticks.
         */
        public static final EntityStatus EAT_GRASS = new EntityStatus(EntityTypes.SHEEP, 10);

    }

    public static final class Ocelot {

        /**
         * Spawns smoke particles (taming failed).
         */
        public static final EntityStatus TAMING_FAILED = new EntityStatus(EntityTypes.OCELOT, 40);
        /**
         * Spawns heart particles (taming succeeded).
         */
        public static final EntityStatus TAMING_SUCCEEDED = new EntityStatus(EntityTypes.OCELOT, 41);

    }

    public static final class Fox {

        /**
         * Spawns chew particles based on item in mouth.
         */
        public static final EntityStatus CHEW = new EntityStatus(EntityTypes.FOX, 45);

    }

    public static final class Goat {

        /**
         * Lowers head for ramming.
         */
        public static final EntityStatus LOWER_HEAD = new EntityStatus(EntityTypes.GOAT, 58);
        /**
         * Stops lowering head.
         */
        public static final EntityStatus STOP_LOWER_HEAD = new EntityStatus(EntityTypes.GOAT, 59);

    }

    public static final class Dolphin {

        /**
         * Causes several "happy villager" particles to appear.
         */
        public static final EntityStatus HAPPY = new EntityStatus(EntityTypes.DOLPHIN, 38);

    }

    public static final class Squid {

        /**
         * Resets the squid's rotation to 0 radians.
         */
        public static final EntityStatus RESET_ROTATION = new EntityStatus(EntityTypes.SQUID, 19);

    }

    public static final class Allay {

        /**
         * Spawns heart particles, used upon Allay duplication.
         */
        public static final EntityStatus DUPLICATION = new EntityStatus(EntityTypes.ALLAY, 18);

    }

    public static final class Sniffer {

        /**
         * Plays the digging sound.
         */
        public static final EntityStatus DIG = new EntityStatus(EntityTypes.SNIFFER, 63);

    }

    public static final class Villager {

        /**
         * Spawns villager mating heart particles.
         */
        public static final EntityStatus MATE = new EntityStatus(EntityTypes.VILLAGER, 12);
        /**
         * Spawns villager angry particles.
         */
        public static final EntityStatus ANGRY = new EntityStatus(EntityTypes.VILLAGER, 13);
        /**
         * Spawns villager happy particles.
         */
        public static final EntityStatus HAPPY = new EntityStatus(EntityTypes.VILLAGER, 14);
        /**
         * Spawns "splash" particles during a raid.
         */
        public static final EntityStatus SPLASH = new EntityStatus(EntityTypes.VILLAGER, 42);

    }

    public static final class IronGolem {

        /**
         * Plays attack animation and attack sound.
         */
        public static final EntityStatus ATTACK = new EntityStatus(EntityTypes.IRON_GOLEM, 4);
        /**
         * Causes golem to hold out a poppy for 400 ticks.
         */
        public static final EntityStatus HOLD_POPPY = new EntityStatus(EntityTypes.IRON_GOLEM, 11);
        /**
         * Puts away golem's poppy.
         */
        public static final EntityStatus PUT_AWAY_POPPY = new EntityStatus(EntityTypes.IRON_GOLEM, 34);

    }

    public static final class Witch {

        /**
         * Spawns between 10 and 45 witchMagic particles.
         */
        public static final EntityStatus MAGIC_PARTICLES = new EntityStatus(EntityTypes.WITCH, 15);

    }

    public static final class ZombieVillager {

        /**
         * Plays the zombie villager cure sound effect.
         */
        public static final EntityStatus CURE_SOUND = new EntityStatus(EntityTypes.ZOMBIE_VILLAGER, 16);

    }

    public static final class Guardian {

        /**
         * Plays the guardian attack sound effect.
         */
        public static final EntityStatus ATTACK_SOUND = new EntityStatus(EntityTypes.GUARDIAN, 21);

    }

    public static final class Ravager {

        /**
         * Starts the attack animation.
         */
        public static final EntityStatus ATTACK = new EntityStatus(EntityTypes.RAVAGER, 4);
        /**
         * Marks the ravager as stunned for the next 40 ticks.
         */
        public static final EntityStatus STUNNED = new EntityStatus(EntityTypes.RAVAGER, 39);

    }

    public static final class Hoglin {

        /**
         * Plays the attack animation for 10 ticks and plays the attack sound.
         */
        public static final EntityStatus ATTACK = new EntityStatus(EntityTypes.HOGLIN, 4);

    }

    public static final class Zoglin {

        /**
         * Plays the attack animation for 10 ticks and plays the attack sound.
         */
        public static final EntityStatus ATTACK = new EntityStatus(EntityTypes.ZOGLIN, 4);

    }

    public static final class Warden {

        /**
         * Stops the roar animation and performs the attack animation.
         */
        public static final EntityStatus ATTACK = new EntityStatus(EntityTypes.WARDEN, 4);
        /**
         * Performs tendril shaking animation for 10 ticks.
         */
        public static final EntityStatus TENDRIL_SHAKE = new EntityStatus(EntityTypes.WARDEN, 61);
        /**
         * Performs the sonic boom attack animation.
         */
        public static final EntityStatus SONIC_BOOM = new EntityStatus(EntityTypes.WARDEN, 62);

    }

    public static final class MinecartSpawner {

        /**
         * Resets the delay of the spawner to 200 ticks.
         */
        public static final EntityStatus RESET_DELAY = new EntityStatus(EntityTypes.SPAWNER_MINECART, 1);

    }

    public static final class MinecartTNT {

        /**
         * Causes the TNT to ignite.
         */
        public static final EntityStatus IGNITE = new EntityStatus(EntityTypes.TNT_MINECART, 70);

    }

}
