// Auto-generated file. Do not edit manually.
//
package dev.threeadd.packetentities.entity.meta.protocol;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.component.builtin.item.ItemProfile;
import com.github.retrooper.packetevents.protocol.entity.armadillo.ArmadilloState;
import com.github.retrooper.packetevents.protocol.entity.cat.CatSoundVariant;
import com.github.retrooper.packetevents.protocol.entity.cat.CatVariant;
import com.github.retrooper.packetevents.protocol.entity.chicken.ChickenSoundVariant;
import com.github.retrooper.packetevents.protocol.entity.chicken.ChickenVariant;
import com.github.retrooper.packetevents.protocol.entity.cow.CowSoundVariant;
import com.github.retrooper.packetevents.protocol.entity.cow.CowVariant;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.entity.data.struct.CopperGolemState;
import com.github.retrooper.packetevents.protocol.entity.data.struct.WeatheringCopperState;
import com.github.retrooper.packetevents.protocol.entity.frog.FrogVariant;
import com.github.retrooper.packetevents.protocol.entity.nautilus.ZombieNautilusVariant;
import com.github.retrooper.packetevents.protocol.entity.pig.PigSoundVariant;
import com.github.retrooper.packetevents.protocol.entity.pig.PigVariant;
import com.github.retrooper.packetevents.protocol.entity.pose.EntityPose;
import com.github.retrooper.packetevents.protocol.entity.sniffer.SnifferState;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.entity.villager.VillagerData;
import com.github.retrooper.packetevents.protocol.entity.wolfvariant.WolfSoundVariant;
import com.github.retrooper.packetevents.protocol.entity.wolfvariant.WolfVariant;
import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.nbt.NBTCompound;
import com.github.retrooper.packetevents.protocol.particle.Particle;
import com.github.retrooper.packetevents.protocol.player.HumanoidArm;
import com.github.retrooper.packetevents.protocol.world.BlockFace;
import com.github.retrooper.packetevents.protocol.world.painting.PaintingVariant;
import com.github.retrooper.packetevents.util.Quaternion4f;
import com.github.retrooper.packetevents.util.Vector3f;
import com.github.retrooper.packetevents.util.Vector3i;
import dev.threeadd.packetentities.entity.meta.EntityMetaSchema;
import dev.threeadd.packetentities.entity.meta.field.IEntityMetaFieldHolder;
import dev.threeadd.packetentities.entity.meta.field.SimpleField;
import dev.threeadd.packetentities.entity.meta.field.ViewField;
import dev.threeadd.packetentities.entity.meta.protocol.view.bitmask.type.AbstractArrowIdFlagsView;
import dev.threeadd.packetentities.entity.meta.protocol.view.bitmask.type.AbstractHorseFlagsView;
import dev.threeadd.packetentities.entity.meta.protocol.view.bitmask.type.ArmorStandClientFlagsView;
import dev.threeadd.packetentities.entity.meta.protocol.view.bitmask.type.AvatarPlayerModeCustomizationFlagsView;
import dev.threeadd.packetentities.entity.meta.protocol.view.bitmask.type.BatFlagsView;
import dev.threeadd.packetentities.entity.meta.protocol.view.bitmask.type.BeeFlagsView;
import dev.threeadd.packetentities.entity.meta.protocol.view.bitmask.type.BlazeFlagsView;
import dev.threeadd.packetentities.entity.meta.protocol.view.bitmask.type.EntitySharedFlagsView;
import dev.threeadd.packetentities.entity.meta.protocol.view.bitmask.type.TamableAnimalFlagsView;
import dev.threeadd.packetentities.entity.meta.protocol.view.bitmask.type.VexFlagsView;
import dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.type.AxolotlVariantView;
import dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.type.CreeperSwellStateView;
import dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.type.DisplayBillboardView;
import dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.type.EnderDragonPhaseView;
import dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.type.ParrotVariantView;
import dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.type.SalmonTypeView;
import dev.threeadd.packetentities.entity.meta.protocol.view.enumurator.type.SpellcasterIllagerSpellCastingView;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import net.kyori.adventure.text.Component;

/**
 * Holds all {@link IEntityMetaFieldHolder} and {@link EntityMetaSchema}, grouped by their respective {@link EntityTypes}.
 */
@SuppressWarnings({"unused", "SpellCheckingInspection"})
public final class EntityMetaFields {

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Entity">Entity on the minecraft.wiki</a>
     */
    public static class Entity implements IEntityMetaFieldHolder {

        /**
         * @mcversions {@code 1.9.4 - 26.2}
         */
        public static final SimpleField<Integer> AIR_SUPPLY = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_26_2, 1, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 26.2}
         */
        public static final SimpleField<Optional<Component>> CUSTOM_NAME = SimpleField.<Optional<Component>>builder()
            // TODO type changed from 'String' to 'Optional<Component>', converter required
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_26_2, 2, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 26.2}
         */
        public static final SimpleField<Boolean> CUSTOM_NAME_VISIBLE = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_26_2, 3, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.11.2 - 26.2}
         */
        public static final SimpleField<Boolean> NO_GRAVITY = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_26_2, 5, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<EntityPose> POSE = SimpleField.<EntityPose>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_26_2, 6, EntityDataTypes.ENTITY_POSE)
            .build();

        /**
         * @view {@link EntitySharedFlagsView}
         * @mcversions {@code 1.9.4 - 26.2}
         */
        public static final ViewField<Byte, EntitySharedFlagsView> SHARED_FLAGS = ViewField.builder(EntitySharedFlagsView::new)
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_26_2, 0, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 26.2}
         */
        public static final SimpleField<Boolean> SILENT = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_26_2, 4, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.17 - 26.2}
         */
        public static final SimpleField<Integer> TICKS_FROZEN = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 7, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = EntityMetaSchema.builder(EntityTypes.ENTITY)
            .add(Entity.AIR_SUPPLY)
            .add(Entity.CUSTOM_NAME)
            .add(Entity.CUSTOM_NAME_VISIBLE)
            .add(Entity.NO_GRAVITY)
            .add(Entity.POSE)
            .add(Entity.SHARED_FLAGS)
            .add(Entity.SILENT)
            .add(Entity.TICKS_FROZEN)
            .build();

    }

    /**
     * @mcversions {@code 1.16 - 26.2}
     */
    public static class Projectile extends Entity {

        public static final EntityMetaSchema SCHEMA = Entity.SCHEMA.extend(EntityTypes.PROJECTILE_ABSTRACT)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Abstract_Arrow">Abstract Arrow on the minecraft.wiki</a>
     */
    public static class AbstractArrow extends Projectile {

        /**
         * @view {@link AbstractArrowIdFlagsView}
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final ViewField<Byte, AbstractArrowIdFlagsView> ID_FLAGS = ViewField.builder(AbstractArrowIdFlagsView::new)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 7, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 8, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.21.2 - 26.2}
         */
        public static final SimpleField<Boolean> IN_GROUND = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_21_2, ServerVersion.V_26_2, 10, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 1.15}
         */
        public static final SimpleField<Optional<UUID>> OWNERUUID = SimpleField.<Optional<UUID>>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_15, 8, EntityDataTypes.OPTIONAL_UUID)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Byte> PIERCE_LEVEL = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_15, 9, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_16, ServerVersion.V_1_16_2, 8, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 9, EntityDataTypes.BYTE)
            .build();

        public static final EntityMetaSchema SCHEMA = Projectile.SCHEMA.extend(EntityTypes.ABSTRACT_ARROW)
            .add(AbstractArrow.ID_FLAGS)
            .add(AbstractArrow.IN_GROUND)
            .add(AbstractArrow.OWNERUUID)
            .add(AbstractArrow.PIERCE_LEVEL)
            .build();

    }

    /**
     * @mcversions {@code 1.20.3 - 26.2}
     */
    public static class VehicleEntity extends Entity {

        /**
         * @mcversions {@code 1.20.3 - 26.2}
         */
        public static final SimpleField<Float> DAMAGE = SimpleField.<Float>builder()
            .addVersionRange(ServerVersion.V_1_20_3, ServerVersion.V_26_2, 10, EntityDataTypes.FLOAT)
            .build();

        /**
         * @mcversions {@code 1.20.3 - 26.2}
         */
        public static final SimpleField<Integer> HURT = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_20_3, ServerVersion.V_26_2, 8, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.20.3 - 26.2}
         */
        public static final SimpleField<Integer> HURTDIR = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_20_3, ServerVersion.V_26_2, 9, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = Entity.SCHEMA.extend(null) // TODO Entity Type need mappings
            .add(VehicleEntity.DAMAGE)
            .add(VehicleEntity.HURT)
            .add(VehicleEntity.HURTDIR)
            .build();

    }

    /**
     * @mcversions {@code 1.21.2 - 26.2}
     */
    public static class AbstractBoat extends VehicleEntity {

        /**
         * @mcversions {@code 1.21.2 - 26.2}
         */
        public static final SimpleField<Integer> BUBBLE_TIME = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_21_2, ServerVersion.V_26_2, 13, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.21.2 - 26.2}
         */
        public static final SimpleField<Boolean> PADDLE_LEFT = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_21_2, ServerVersion.V_26_2, 11, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.21.2 - 26.2}
         */
        public static final SimpleField<Boolean> PADDLE_RIGHT = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_21_2, ServerVersion.V_26_2, 12, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = VehicleEntity.SCHEMA.extend(EntityTypes.BOAT)
            .add(AbstractBoat.BUBBLE_TIME)
            .add(AbstractBoat.PADDLE_LEFT)
            .add(AbstractBoat.PADDLE_RIGHT)
            .build();

    }

    /**
     * @mcversions {@code 1.21.2 - 26.2}
     */
    public static class AbstractChestBoat extends AbstractBoat {

        public static final EntityMetaSchema SCHEMA = AbstractBoat.SCHEMA.extend(EntityTypes.CHEST_BOAT)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Living_Entity">Living Entity on the minecraft.wiki</a>
     */
    public static class LivingEntity extends Entity {

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Byte> AI_FLAGS = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 10, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 11, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Integer> ARROW_COUNT = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 11, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 12, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Integer> ARROW_COUNT_IN_ENTITY = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 9, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 10, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Boolean> EFFECT_AMBIENCE = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 10, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 11, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 1.20.3}
         */
        public static final SimpleField<Integer> EFFECT_COLOR = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 9, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_20_3, 10, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.20.5 - 26.2}
         */
        public static final SimpleField<List<Particle<?>>> EFFECT_PARTICLES = SimpleField.<List<Particle<?>>>builder()
            .addVersionRange(ServerVersion.V_1_20_5, ServerVersion.V_26_2, 10, EntityDataTypes.PARTICLES)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Byte> HAND_STATES = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 5, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 6, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 26.2}
         */
        public static final SimpleField<Float> HEALTH = SimpleField.<Float>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 6, EntityDataTypes.FLOAT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 7, EntityDataTypes.FLOAT)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 8, EntityDataTypes.FLOAT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 9, EntityDataTypes.FLOAT)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Boolean> HIDE_PARTICLES = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 8, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 9, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Byte> LIVING_ENTITY_FLAGS = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 7, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 8, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Integer> POTION_EFFECTS = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 7, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 8, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Optional<Vector3i>> SLEEPING_POS = SimpleField.<Optional<Vector3i>>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 12, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 13, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 14, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .build();

        /**
         * @mcversions {@code 1.15 - 26.2}
         */
        public static final SimpleField<Integer> STINGER_COUNT = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 12, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 13, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = Entity.SCHEMA.extend(EntityTypes.LIVINGENTITY)
            .add(LivingEntity.AI_FLAGS)
            .add(LivingEntity.ARROW_COUNT)
            .add(LivingEntity.ARROW_COUNT_IN_ENTITY)
            .add(LivingEntity.EFFECT_AMBIENCE)
            .add(LivingEntity.EFFECT_COLOR)
            .add(LivingEntity.EFFECT_PARTICLES)
            .add(LivingEntity.HAND_STATES)
            .add(LivingEntity.HEALTH)
            .add(LivingEntity.HIDE_PARTICLES)
            .add(LivingEntity.LIVING_ENTITY_FLAGS)
            .add(LivingEntity.POTION_EFFECTS)
            .add(LivingEntity.SLEEPING_POS)
            .add(LivingEntity.STINGER_COUNT)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Mob">Mob on the minecraft.wiki</a>
     */
    public static class Mob extends LivingEntity {

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Byte> MOB_FLAGS = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 13, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 14, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 15, EntityDataTypes.BYTE)
            .build();

        public static final EntityMetaSchema SCHEMA = LivingEntity.SCHEMA.extend(null) // TODO Entity Type need mappings
            .add(Mob.MOB_FLAGS)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class PathfinderMob extends Mob {

        public static final EntityMetaSchema SCHEMA = Mob.SCHEMA.extend(null) // TODO Entity Type need mappings
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Ageable_Mob">Ageable Mob on the minecraft.wiki</a>
     */
    public static class AgeableMob extends PathfinderMob {

        /**
         * @mcversions {@code 26.1 - 26.2}
         */
        public static final SimpleField<Boolean> AGE_LOCKED = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 17, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 26.2}
         */
        public static final SimpleField<Boolean> BABY = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 11, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 12, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 14, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 15, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 16, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = PathfinderMob.SCHEMA.extend(EntityTypes.ABSTRACT_AGEABLE)
            .add(AgeableMob.AGE_LOCKED)
            .add(AgeableMob.BABY)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Animal">Animal on the minecraft.wiki</a>
     */
    public static class Animal extends AgeableMob {

        public static final EntityMetaSchema SCHEMA = AgeableMob.SCHEMA.extend(EntityTypes.ABSTRACT_ANIMAL)
            .build();

    }

    /**
     * @mcversions {@code 1.11.2 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Abstract_Horse">Abstract Horse on the minecraft.wiki</a>
     */
    public static class AbstractHorse extends Animal {

        /**
         * @view {@link AbstractHorseFlagsView}
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final ViewField<Byte, AbstractHorseFlagsView> FLAGS = ViewField.builder(AbstractHorseFlagsView::new)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 15, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 16, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 17, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 18, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 1.19.3}
         */
        public static final SimpleField<Optional<UUID>> OWNER_UUID = SimpleField.<Optional<UUID>>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 16, EntityDataTypes.OPTIONAL_UUID)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 17, EntityDataTypes.OPTIONAL_UUID)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_19_3, 18, EntityDataTypes.OPTIONAL_UUID)
            .build();

        /**
         * @mcversions {@code 1.11.2 - 1.12.2}
         */
        public static final SimpleField<Byte> STATUS = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 13, EntityDataTypes.BYTE)
            .build();

        public static final EntityMetaSchema SCHEMA = Animal.SCHEMA.extend(EntityTypes.ABSTRACT_HORSE)
            .add(AbstractHorse.FLAGS)
            .add(AbstractHorse.OWNER_UUID)
            .add(AbstractHorse.STATUS)
            .build();

    }

    /**
     * @mcversions {@code 1.11.2 - 26.2}
     */
    public static class AbstractChestedHorse extends AbstractHorse {

        /**
         * @mcversions {@code 1.12.2 - 26.2}
         */
        public static final SimpleField<Boolean> CHEST = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_12_2, ServerVersion.V_1_12_2, 14, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 17, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 18, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_19_3, 19, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_21_11, 18, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 19, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractHorse.SCHEMA.extend(EntityTypes.CHESTED_HORSE)
            .add(AbstractChestedHorse.CHEST)
            .build();

    }

    /**
     * @mcversions {@code 1.21.9 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Avatar">Avatar on the minecraft.wiki</a>
     */
    public static class Avatar extends LivingEntity {

        /**
         * @mcversions {@code 1.21.9 - 26.2}
         */
        public static final SimpleField<HumanoidArm> PLAYER_MAIN_HAND = SimpleField.<HumanoidArm>builder()
            // TODO type changed from 'Byte' to 'HumanoidArm', converter required
            .addVersionRange(ServerVersion.V_1_21_11, ServerVersion.V_26_2, 15, EntityDataTypes.HUMANOID_ARM)
            .build();

        /**
         * @view {@link AvatarPlayerModeCustomizationFlagsView}
         * @mcversions {@code 1.21.9 - 26.2}
         */
        public static final ViewField<Byte, AvatarPlayerModeCustomizationFlagsView> PLAYER_MODE_CUSTOMISATION = ViewField.builder(AvatarPlayerModeCustomizationFlagsView::new)
            .addVersionRange(ServerVersion.V_1_21_9, ServerVersion.V_26_2, 16, EntityDataTypes.BYTE)
            .build();

        public static final EntityMetaSchema SCHEMA = LivingEntity.SCHEMA.extend(EntityTypes.AVATAR)
            .add(Avatar.PLAYER_MAIN_HAND)
            .add(Avatar.PLAYER_MODE_CUSTOMISATION)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Player">Player on the minecraft.wiki</a>
     */
    public static class Player extends Avatar {

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Float> ABSORPTION = SimpleField.<Float>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 10, EntityDataTypes.FLOAT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 11, EntityDataTypes.FLOAT)
            .build();

        /**
         * @mcversions {@code 1.12.2}
         */
        public static final SimpleField<NBTCompound> LEFT_SHOULDER_ENTITY = SimpleField.<NBTCompound>builder()
            .addVersionRange(ServerVersion.V_1_12_2, ServerVersion.V_1_12_2, 15, EntityDataTypes.NBT)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Byte> MAIN_HAND = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 13, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 14, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Float> PLAYER_ABSORPTION = SimpleField.<Float>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 13, EntityDataTypes.FLOAT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 14, EntityDataTypes.FLOAT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_6, 15, EntityDataTypes.FLOAT)
            .addVersionRange(ServerVersion.V_1_21_9, ServerVersion.V_26_2, 17, EntityDataTypes.FLOAT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 1.21.6}
         */
        public static final SimpleField<Byte> PLAYER_MAIN_HAND = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 16, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 17, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_6, 18, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Byte> PLAYER_MODEL_FLAG = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 12, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 13, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 1.21.6}
         */
        public static final SimpleField<Byte> PLAYER_MODE_CUSTOMISATION = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 15, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 16, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_6, 17, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Integer> PLAYER_SCORE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 11, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 12, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.12.2}
         */
        public static final SimpleField<NBTCompound> RIGHT_SHOULDER_ENTITY = SimpleField.<NBTCompound>builder()
            .addVersionRange(ServerVersion.V_1_12_2, ServerVersion.V_1_12_2, 16, EntityDataTypes.NBT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Integer> SCORE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 14, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 15, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_6, 16, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_21_9, ServerVersion.V_26_2, 18, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 1.21.6}
         */
        public static final SimpleField<NBTCompound> SHOULDER_LEFT = SimpleField.<NBTCompound>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 17, EntityDataTypes.NBT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 18, EntityDataTypes.NBT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_6, 19, EntityDataTypes.NBT)
            .build();

        /**
         * @mcversions {@code 1.21.9 - 26.2}
         */
        public static final SimpleField<Optional<Integer>> SHOULDER_PARROT_LEFT = SimpleField.<Optional<Integer>>builder()
            .addVersionRange(ServerVersion.V_1_21_9, ServerVersion.V_26_2, 19, EntityDataTypes.OPTIONAL_INT)
            .build();

        /**
         * @mcversions {@code 1.21.9 - 26.2}
         */
        public static final SimpleField<Optional<Integer>> SHOULDER_PARROT_RIGHT = SimpleField.<Optional<Integer>>builder()
            .addVersionRange(ServerVersion.V_1_21_9, ServerVersion.V_26_2, 20, EntityDataTypes.OPTIONAL_INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 1.21.6}
         */
        public static final SimpleField<NBTCompound> SHOULDER_RIGHT = SimpleField.<NBTCompound>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 18, EntityDataTypes.NBT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 19, EntityDataTypes.NBT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_6, 20, EntityDataTypes.NBT)
            .build();

        public static final EntityMetaSchema SCHEMA = Avatar.SCHEMA.extend(EntityTypes.PLAYER)
            .add(Player.ABSORPTION)
            .add(Player.LEFT_SHOULDER_ENTITY)
            .add(Player.MAIN_HAND)
            .add(Player.PLAYER_ABSORPTION)
            .add(Player.PLAYER_MAIN_HAND)
            .add(Player.PLAYER_MODEL_FLAG)
            .add(Player.PLAYER_MODE_CUSTOMISATION)
            .add(Player.PLAYER_SCORE)
            .add(Player.RIGHT_SHOULDER_ENTITY)
            .add(Player.SCORE)
            .add(Player.SHOULDER_LEFT)
            .add(Player.SHOULDER_PARROT_LEFT)
            .add(Player.SHOULDER_PARROT_RIGHT)
            .add(Player.SHOULDER_RIGHT)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class AbstractClientPlayer extends Player {

        public static final EntityMetaSchema SCHEMA = Player.SCHEMA.extend(null) // TODO Entity Type need mappings
            .build();

    }

    /**
     * @mcversions {@code 1.21.5 - 26.2}
     */
    public static class AbstractCow extends Animal {

        public static final EntityMetaSchema SCHEMA = Animal.SCHEMA.extend(EntityTypes.COW)
            .build();

    }

    /**
     * @mcversions {@code 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Abstract_Cube_Mob">Abstract Cube Mob on the minecraft.wiki</a>
     */
    public static class AbstractCubeMob extends AgeableMob {

        /**
         * @mcversions {@code 26.2}
         */
        public static final SimpleField<Integer> ID_SIZE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_26_2, ServerVersion.V_26_2, 18, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = AgeableMob.SCHEMA.extend(null) // TODO Entity Type need mappings
            .add(AbstractCubeMob.ID_SIZE)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class WaterAnimal extends PathfinderMob {

        public static final EntityMetaSchema SCHEMA = PathfinderMob.SCHEMA.extend(EntityTypes.ABSTRACT_WATERMOB)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Abstract_Fish">Abstract Fish on the minecraft.wiki</a>
     */
    public static class AbstractFish extends WaterAnimal {

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Boolean> FROM_BUCKET = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 14, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 15, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 16, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = WaterAnimal.SCHEMA.extend(EntityTypes.ABSTRACT_FISHES)
            .add(AbstractFish.FROM_BUCKET)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class AbstractGolem extends PathfinderMob {

        public static final EntityMetaSchema SCHEMA = PathfinderMob.SCHEMA.extend(EntityTypes.ABSTRACT_GOLEM)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     */
    public static class AbstractHurtingProjectile extends Projectile {

        public static final EntityMetaSchema SCHEMA = Projectile.SCHEMA.extend(null) // TODO Entity Type need mappings
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Monster">Monster on the minecraft.wiki</a>
     */
    public static class Monster extends PathfinderMob {

        public static final EntityMetaSchema SCHEMA = PathfinderMob.SCHEMA.extend(EntityTypes.ABSTRACT_MONSTER)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     */
    public static class PatrollingMonster extends Monster {

        public static final EntityMetaSchema SCHEMA = Monster.SCHEMA.extend(null) // TODO Entity Type need mappings
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Raider">Raider on the minecraft.wiki</a>
     */
    public static class Raider extends PatrollingMonster {

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Boolean> IS_CELEBRATING = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 14, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 15, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 16, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = PatrollingMonster.SCHEMA.extend(null) // TODO Entity Type need mappings
            .add(Raider.IS_CELEBRATING)
            .build();

    }

    /**
     * @mcversions {@code 1.12 - 26.2}
     */
    public static class AbstractIllager extends Raider {

        /**
         * @mcversions {@code 1.12.2}
         */
        public static final SimpleField<Byte> AGGRESSIVE = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_12_2, ServerVersion.V_1_12_2, 12, EntityDataTypes.BYTE)
            .build();

        public static final EntityMetaSchema SCHEMA = Raider.SCHEMA.extend(EntityTypes.ABSTRACT_ILLAGER_BASE)
            .add(AbstractIllager.AGGRESSIVE)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Abstract_Minecart">Abstract Minecart on the minecraft.wiki</a>
     */
    public static class AbstractMinecart extends VehicleEntity {

        /**
         * @mcversions {@code 1.14.4 - 1.21.4}
         */
        public static final SimpleField<Boolean> CUSTOM_DISPLAY = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 12, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_4, 13, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.21.5 - 26.2}
         */
        public static final SimpleField<Integer> CUSTOM_DISPLAY_BLOCK = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_21_5, ServerVersion.V_26_2, 11, EntityDataTypes.OPTIONAL_BLOCK_STATE)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 1.20.2}
         */
        public static final SimpleField<Float> DAMAGE = SimpleField.<Float>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 9, EntityDataTypes.FLOAT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_20_2, 10, EntityDataTypes.FLOAT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 1.21.4}
         */
        public static final SimpleField<Integer> DISPLAY_BLOCK = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 10, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_4, 11, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Integer> DISPLAY_OFFSET = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 11, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 12, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 1.20.2}
         */
        public static final SimpleField<Integer> HURT = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 7, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_20_2, 8, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 1.20.2}
         */
        public static final SimpleField<Integer> HURTDIR = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 8, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_20_2, 9, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = VehicleEntity.SCHEMA.extend(EntityTypes.MINECART_ABSTRACT)
            .add(AbstractMinecart.CUSTOM_DISPLAY)
            .add(AbstractMinecart.CUSTOM_DISPLAY_BLOCK)
            .add(AbstractMinecart.DAMAGE)
            .add(AbstractMinecart.DISPLAY_BLOCK)
            .add(AbstractMinecart.DISPLAY_OFFSET)
            .add(AbstractMinecart.HURT)
            .add(AbstractMinecart.HURTDIR)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class AbstractMinecartContainer extends AbstractMinecart {

        public static final EntityMetaSchema SCHEMA = AbstractMinecart.SCHEMA.extend(null) // TODO Entity Type need mappings
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class TamableAnimal extends Animal {

        /**
         * @view {@link TamableAnimalFlagsView}
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final ViewField<Byte, TamableAnimalFlagsView> FLAGS = ViewField.builder(TamableAnimalFlagsView::new)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 15, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 16, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 17, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 18, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Optional<UUID>> OWNERUUID = SimpleField.<Optional<UUID>>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 16, EntityDataTypes.OPTIONAL_UUID)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 17, EntityDataTypes.OPTIONAL_UUID)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_4, 18, EntityDataTypes.OPTIONAL_UUID)
            .addVersionRange(ServerVersion.V_1_21_5, ServerVersion.V_1_21_11, 18, EntityDataTypes.OPTIONAL_UUID)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 19, EntityDataTypes.OPTIONAL_UUID)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Byte> TAMED = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 12, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 13, EntityDataTypes.BYTE)
            .build();

        public static final EntityMetaSchema SCHEMA = Animal.SCHEMA.extend(null) // TODO Entity Type need mappings
            .add(TamableAnimal.FLAGS)
            .add(TamableAnimal.OWNERUUID)
            .add(TamableAnimal.TAMED)
            .build();

    }

    /**
     * @mcversions {@code 1.21.11 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Abstract_Nautilus">Abstract Nautilus on the minecraft.wiki</a>
     */
    public static class AbstractNautilus extends TamableAnimal {

        /**
         * @mcversions {@code 1.21.11 - 26.2}
         */
        public static final SimpleField<Boolean> DASH = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_21_11, ServerVersion.V_1_21_11, 19, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 20, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = TamableAnimal.SCHEMA.extend(EntityTypes.ABSTRACT_NAUTILUS)
            .add(AbstractNautilus.DASH)
            .build();

    }

    /**
     * @mcversions {@code 1.16.2 - 26.2}
     */
    public static class AbstractPiglin extends Monster {

        /**
         * @mcversions {@code 1.16.2 - 26.2}
         */
        public static final SimpleField<Boolean> IMMUNE_TO_ZOMBIFICATION = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_16_2, ServerVersion.V_1_16_2, 15, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 16, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = Monster.SCHEMA.extend(EntityTypes.ABSTRACT_PIGLIN)
            .add(AbstractPiglin.IMMUNE_TO_ZOMBIFICATION)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     */
    public static class AbstractSchoolingFish extends AbstractFish {

        public static final EntityMetaSchema SCHEMA = AbstractFish.SCHEMA.extend(null) // TODO Entity Type need mappings
            .build();

    }

    /**
     * @mcversions {@code 1.11.2 - 26.2}
     */
    public static class AbstractSkeleton extends Monster {

        /**
         * @mcversions {@code 1.11.2 - 1.12.2}
         */
        public static final SimpleField<Boolean> SWINGING_ARMS = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 12, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = Monster.SCHEMA.extend(EntityTypes.ABSTRACT_SKELETON)
            .add(AbstractSkeleton.SWINGING_ARMS)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     */
    public static class ThrowableProjectile extends Projectile {

        public static final EntityMetaSchema SCHEMA = Projectile.SCHEMA.extend(null) // TODO Entity Type need mappings
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class ThrowableItemProjectile extends ThrowableProjectile {

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<ItemStack> ITEM_STACK = SimpleField.<ItemStack>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 7, EntityDataTypes.ITEMSTACK)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 8, EntityDataTypes.ITEMSTACK)
            .build();

        public static final EntityMetaSchema SCHEMA = ThrowableProjectile.SCHEMA.extend(null) // TODO Entity Type need mappings
            .add(ThrowableItemProjectile.ITEM_STACK)
            .build();

    }

    /**
     * @mcversions {@code 1.21.5 - 26.2}
     */
    public static class AbstractThrownPotion extends ThrowableItemProjectile {

        public static final EntityMetaSchema SCHEMA = ThrowableItemProjectile.SCHEMA.extend(null) // TODO Entity Type need mappings
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Abstract_Villager">Abstract Villager on the minecraft.wiki</a>
     */
    public static class AbstractVillager extends AgeableMob {

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Integer> UNHAPPY_COUNTER = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 15, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 16, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 17, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 18, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = AgeableMob.SCHEMA.extend(EntityTypes.VILLAGER)
            .add(AbstractVillager.UNHAPPY_COUNTER)
            .build();

    }

    /**
     * @mcversions {@code 1.20.5 - 26.2}
     */
    public static class AbstractWindCharge extends AbstractHurtingProjectile {

        public static final EntityMetaSchema SCHEMA = AbstractHurtingProjectile.SCHEMA.extend(EntityTypes.ABSTRACT_WIND_CHARGE)
            .build();

    }

    /**
     * @mcversions {@code 1.21.2 - 26.2}
     */
    public static class AgeableWaterCreature extends AgeableMob {

        public static final EntityMetaSchema SCHEMA = AgeableMob.SCHEMA.extend(EntityTypes.ABSTRACT_WATERMOB)
            .build();

    }

    /**
     * @mcversions {@code 1.19 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Allay">Allay on the minecraft.wiki</a>
     */
    public static class Allay extends PathfinderMob {

        /**
         * @mcversions {@code 1.19.1 - 26.2}
         */
        public static final SimpleField<Boolean> CAN_DUPLICATE = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_19_1, ServerVersion.V_26_2, 17, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.19.1 - 26.2}
         */
        public static final SimpleField<Boolean> DANCING = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_19_1, ServerVersion.V_26_2, 16, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = PathfinderMob.SCHEMA.extend(EntityTypes.ALLAY)
            .add(Allay.CAN_DUPLICATE)
            .add(Allay.DANCING)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class AmbientCreature extends Mob {

        public static final EntityMetaSchema SCHEMA = Mob.SCHEMA.extend(EntityTypes.ABSTRACT_AMBIENT)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Area_Effect_Cloud">Area Effect Cloud on the minecraft.wiki</a>
     */
    public static class AreaEffectCloud extends Entity {

        /**
         * @mcversions {@code 1.9.4 - 1.20.3}
         */
        public static final SimpleField<Integer> COLOR = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 6, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 7, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 8, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_20_3, 9, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Boolean> IGNORE_RADIUS = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 7, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 8, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 26.2}
         */
        public static final SimpleField<Particle<?>> PARTICLE = SimpleField.<Particle<?>>builder()
            // TODO type changed from 'Integer' to 'ParticleOptions', converter required
            // TODO type changed from 'Integer' to 'ParticleOptions', converter required
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 10, EntityDataTypes.PARTICLE)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_20_3, 11, EntityDataTypes.PARTICLE)
            .addVersionRange(ServerVersion.V_1_20_5, ServerVersion.V_26_2, 10, EntityDataTypes.PARTICLE)
            .build();

        /**
         * @mcversions {@code 1.11.2 - 1.12.2}
         */
        public static final SimpleField<Integer> PARTICLE_PARAM_1 = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 10, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.11.2 - 1.12.2}
         */
        public static final SimpleField<Integer> PARTICLE_PARAM_2 = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 11, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 26.2}
         */
        public static final SimpleField<Float> RADIUS = SimpleField.<Float>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 5, EntityDataTypes.FLOAT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 6, EntityDataTypes.FLOAT)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 7, EntityDataTypes.FLOAT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 8, EntityDataTypes.FLOAT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Boolean> WAITING = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 9, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_20_3, 10, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_20_5, ServerVersion.V_26_2, 9, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = Entity.SCHEMA.extend(EntityTypes.AREA_EFFECT_CLOUD)
            .add(AreaEffectCloud.COLOR)
            .add(AreaEffectCloud.IGNORE_RADIUS)
            .add(AreaEffectCloud.PARTICLE)
            .add(AreaEffectCloud.PARTICLE_PARAM_1)
            .add(AreaEffectCloud.PARTICLE_PARAM_2)
            .add(AreaEffectCloud.RADIUS)
            .add(AreaEffectCloud.WAITING)
            .build();

    }

    /**
     * @mcversions {@code 1.20.5 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Armadillo">Armadillo on the minecraft.wiki</a>
     */
    public static class Armadillo extends Animal {

        /**
         * @mcversions {@code 1.20.5 - 26.2}
         */
        public static final SimpleField<ArmadilloState> ARMADILLO_STATE = SimpleField.<ArmadilloState>builder()
            .addVersionRange(ServerVersion.V_1_20_5, ServerVersion.V_1_21_11, 17, EntityDataTypes.ARMADILLO_STATE)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 18, EntityDataTypes.ARMADILLO_STATE)
            .build();

        public static final EntityMetaSchema SCHEMA = Animal.SCHEMA.extend(EntityTypes.ARMADILLO)
            .add(Armadillo.ARMADILLO_STATE)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Armor_Stand">Armor Stand on the minecraft.wiki</a>
     */
    public static class ArmorStand extends LivingEntity {

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Vector3f> BODY_POSE = SimpleField.<Vector3f>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 15, EntityDataTypes.VECTOR3F)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 16, EntityDataTypes.VECTOR3F)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 17, EntityDataTypes.VECTOR3F)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Vector3f> BODY_ROTATION = SimpleField.<Vector3f>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 12, EntityDataTypes.VECTOR3F)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 13, EntityDataTypes.VECTOR3F)
            .build();

        /**
         * @view {@link ArmorStandClientFlagsView}
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final ViewField<Byte, ArmorStandClientFlagsView> CLIENT_FLAGS = ViewField.builder(ArmorStandClientFlagsView::new)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 13, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 14, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 15, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Vector3f> HEAD_POSE = SimpleField.<Vector3f>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 14, EntityDataTypes.VECTOR3F)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 15, EntityDataTypes.VECTOR3F)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 16, EntityDataTypes.VECTOR3F)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Vector3f> HEAD_ROTATION = SimpleField.<Vector3f>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 11, EntityDataTypes.VECTOR3F)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 12, EntityDataTypes.VECTOR3F)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Vector3f> LEFT_ARM_POSE = SimpleField.<Vector3f>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 16, EntityDataTypes.VECTOR3F)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 17, EntityDataTypes.VECTOR3F)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 18, EntityDataTypes.VECTOR3F)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Vector3f> LEFT_ARM_ROTATION = SimpleField.<Vector3f>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 13, EntityDataTypes.VECTOR3F)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 14, EntityDataTypes.VECTOR3F)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Vector3f> LEFT_LEG_POSE = SimpleField.<Vector3f>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 18, EntityDataTypes.VECTOR3F)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 19, EntityDataTypes.VECTOR3F)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 20, EntityDataTypes.VECTOR3F)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Vector3f> LEFT_LEG_ROTATION = SimpleField.<Vector3f>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 15, EntityDataTypes.VECTOR3F)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 16, EntityDataTypes.VECTOR3F)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Vector3f> RIGHT_ARM_POSE = SimpleField.<Vector3f>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 17, EntityDataTypes.VECTOR3F)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 18, EntityDataTypes.VECTOR3F)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 19, EntityDataTypes.VECTOR3F)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Vector3f> RIGHT_ARM_ROTATION = SimpleField.<Vector3f>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 14, EntityDataTypes.VECTOR3F)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 15, EntityDataTypes.VECTOR3F)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Vector3f> RIGHT_LEG_POSE = SimpleField.<Vector3f>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 19, EntityDataTypes.VECTOR3F)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 20, EntityDataTypes.VECTOR3F)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 21, EntityDataTypes.VECTOR3F)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Vector3f> RIGHT_LEG_ROTATION = SimpleField.<Vector3f>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 16, EntityDataTypes.VECTOR3F)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 17, EntityDataTypes.VECTOR3F)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Byte> STATUS = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 10, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 11, EntityDataTypes.BYTE)
            .build();

        public static final EntityMetaSchema SCHEMA = LivingEntity.SCHEMA.extend(EntityTypes.ARMOR_STAND)
            .add(ArmorStand.BODY_POSE)
            .add(ArmorStand.BODY_ROTATION)
            .add(ArmorStand.CLIENT_FLAGS)
            .add(ArmorStand.HEAD_POSE)
            .add(ArmorStand.HEAD_ROTATION)
            .add(ArmorStand.LEFT_ARM_POSE)
            .add(ArmorStand.LEFT_ARM_ROTATION)
            .add(ArmorStand.LEFT_LEG_POSE)
            .add(ArmorStand.LEFT_LEG_ROTATION)
            .add(ArmorStand.RIGHT_ARM_POSE)
            .add(ArmorStand.RIGHT_ARM_ROTATION)
            .add(ArmorStand.RIGHT_LEG_POSE)
            .add(ArmorStand.RIGHT_LEG_ROTATION)
            .add(ArmorStand.STATUS)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Arrow">Arrow on the minecraft.wiki</a>
     */
    public static class Arrow extends AbstractArrow {

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Byte> CRITICAL = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 5, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 6, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Integer> ID_EFFECT_COLOR = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_15, 10, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_16, ServerVersion.V_1_16_2, 9, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21, 10, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_21_2, ServerVersion.V_26_2, 11, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractArrow.SCHEMA.extend(EntityTypes.ARROW)
            .add(Arrow.CRITICAL)
            .add(Arrow.ID_EFFECT_COLOR)
            .build();

    }

    /**
     * @mcversions {@code 1.17 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Axolotl">Axolotl on the minecraft.wiki</a>
     */
    public static class Axolotl extends Animal {

        /**
         * @mcversions {@code 1.17 - 26.2}
         */
        public static final SimpleField<Boolean> FROM_BUCKET = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 19, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 20, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.17 - 26.2}
         */
        public static final SimpleField<Boolean> PLAYING_DEAD = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 18, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 19, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @view {@link AxolotlVariantView}
         * @mcversions {@code 1.17 - 26.2}
         */
        public static final ViewField<Integer, AxolotlVariantView> VARIANT = ViewField.builder(AxolotlVariantView::new)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 17, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 18, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = Animal.SCHEMA.extend(EntityTypes.AXOLOTL)
            .add(Axolotl.FROM_BUCKET)
            .add(Axolotl.PLAYING_DEAD)
            .add(Axolotl.VARIANT)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Bat">Bat on the minecraft.wiki</a>
     */
    public static class Bat extends AmbientCreature {

        /**
         * @view {@link BatFlagsView}
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final ViewField<Byte, BatFlagsView> FLAGS = ViewField.builder(BatFlagsView::new)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 14, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 15, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 16, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Byte> HANGING = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 11, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 12, EntityDataTypes.BYTE)
            .build();

        public static final EntityMetaSchema SCHEMA = AmbientCreature.SCHEMA.extend(EntityTypes.BAT)
            .add(Bat.FLAGS)
            .add(Bat.HANGING)
            .build();

    }

    /**
     * @mcversions {@code 1.15 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Bee">Bee on the minecraft.wiki</a>
     */
    public static class Bee extends Animal {

        /**
         * @mcversions {@code 1.21.11 - 26.2}
         */
        public static final SimpleField<Long> ANGER_END_TIME = SimpleField.<Long>builder()
            .addVersionRange(ServerVersion.V_1_21_11, ServerVersion.V_1_21_11, 18, EntityDataTypes.LONG)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 19, EntityDataTypes.LONG)
            .build();

        /**
         * @mcversions {@code 1.15}
         */
        public static final SimpleField<Integer> ANGER_TIME = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_15, 17, EntityDataTypes.INT)
            .build();

        /**
         * @view {@link BeeFlagsView}
         * @mcversions {@code 1.15 - 26.2}
         */
        public static final ViewField<Byte, BeeFlagsView> FLAGS = ViewField.builder(BeeFlagsView::new)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 16, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 17, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 18, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.16 - 1.21.9}
         */
        public static final SimpleField<Integer> REMAINING_ANGER_TIME = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_16, ServerVersion.V_1_16_2, 17, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_9, 18, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = Animal.SCHEMA.extend(EntityTypes.BEE)
            .add(Bee.ANGER_END_TIME)
            .add(Bee.ANGER_TIME)
            .add(Bee.FLAGS)
            .add(Bee.REMAINING_ANGER_TIME)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Blaze">Blaze on the minecraft.wiki</a>
     */
    public static class Blaze extends Monster {

        /**
         * @view {@link BlazeFlagsView}
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final ViewField<Byte, BlazeFlagsView> FLAGS = ViewField.builder(BlazeFlagsView::new)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 14, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 15, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 16, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Byte> ON_FIRE = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 11, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 12, EntityDataTypes.BYTE)
            .build();

        public static final EntityMetaSchema SCHEMA = Monster.SCHEMA.extend(EntityTypes.BLAZE)
            .add(Blaze.FLAGS)
            .add(Blaze.ON_FIRE)
            .build();

    }

    /**
     * @mcversions {@code 1.21 - 26.2}
     */
    public static class BlockAttachedEntity extends Entity {

        public static final EntityMetaSchema SCHEMA = Entity.SCHEMA.extend(null) // TODO Entity Type need mappings
            .build();

    }

    /**
     * @mcversions {@code 1.19.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Display">Display on the minecraft.wiki</a>
     */
    public static class Display extends Entity {

        /**
         * @view {@link DisplayBillboardView}
         * @mcversions {@code 1.19.4 - 26.2}
         */
        public static final ViewField<Byte, DisplayBillboardView> BILLBOARD_RENDER_CONSTRAINTS = ViewField.builder(DisplayBillboardView::new)
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_19_4, 14, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_20_2, ServerVersion.V_26_2, 15, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.19.4 - 26.2}
         */
        public static final SimpleField<Integer> BRIGHTNESS_OVERRIDE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_19_4, 15, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_20_2, ServerVersion.V_26_2, 16, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.19.4 - 26.2}
         */
        public static final SimpleField<Integer> GLOW_COLOR_OVERRIDE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_19_4, 21, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_20_2, ServerVersion.V_26_2, 22, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.19.4 - 26.2}
         */
        public static final SimpleField<Float> HEIGHT = SimpleField.<Float>builder()
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_19_4, 20, EntityDataTypes.FLOAT)
            .addVersionRange(ServerVersion.V_1_20_2, ServerVersion.V_26_2, 21, EntityDataTypes.FLOAT)
            .build();

        /**
         * @mcversions {@code 1.19.4}
         */
        public static final SimpleField<Integer> INTERPOLATION_DURATION = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_19_4, 9, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.19.4}
         */
        public static final SimpleField<Integer> INTERPOLATION_START_DELTA_TICKS = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_19_4, 8, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.19.4 - 26.2}
         */
        public static final SimpleField<Quaternion4f> LEFT_ROTATION = SimpleField.<Quaternion4f>builder()
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_19_4, 12, EntityDataTypes.QUATERNION)
            .addVersionRange(ServerVersion.V_1_20_2, ServerVersion.V_1_21_9, 13, EntityDataTypes.QUATERNION)
            .addVersionRange(ServerVersion.V_1_21_11, ServerVersion.V_26_2, 13, EntityDataTypes.QUATERNION)
            .build();

        /**
         * @mcversions {@code 1.20.2 - 26.2}
         */
        public static final SimpleField<Integer> POS_ROT_INTERPOLATION_DURATION = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_20_2, ServerVersion.V_26_2, 10, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.19.4 - 26.2}
         */
        public static final SimpleField<Quaternion4f> RIGHT_ROTATION = SimpleField.<Quaternion4f>builder()
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_19_4, 13, EntityDataTypes.QUATERNION)
            .addVersionRange(ServerVersion.V_1_20_2, ServerVersion.V_1_21_9, 14, EntityDataTypes.QUATERNION)
            .addVersionRange(ServerVersion.V_1_21_11, ServerVersion.V_26_2, 14, EntityDataTypes.QUATERNION)
            .build();

        /**
         * @mcversions {@code 1.19.4 - 26.2}
         */
        public static final SimpleField<Vector3f> SCALE = SimpleField.<Vector3f>builder()
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_19_4, 11, EntityDataTypes.VECTOR3F)
            .addVersionRange(ServerVersion.V_1_20_2, ServerVersion.V_1_21_9, 12, EntityDataTypes.VECTOR3F)
            .addVersionRange(ServerVersion.V_1_21_11, ServerVersion.V_26_2, 12, EntityDataTypes.VECTOR3F)
            .build();

        /**
         * @mcversions {@code 1.19.4 - 26.2}
         */
        public static final SimpleField<Float> SHADOW_RADIUS = SimpleField.<Float>builder()
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_19_4, 17, EntityDataTypes.FLOAT)
            .addVersionRange(ServerVersion.V_1_20_2, ServerVersion.V_26_2, 18, EntityDataTypes.FLOAT)
            .build();

        /**
         * @mcversions {@code 1.19.4 - 26.2}
         */
        public static final SimpleField<Float> SHADOW_STRENGTH = SimpleField.<Float>builder()
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_19_4, 18, EntityDataTypes.FLOAT)
            .addVersionRange(ServerVersion.V_1_20_2, ServerVersion.V_26_2, 19, EntityDataTypes.FLOAT)
            .build();

        /**
         * @mcversions {@code 1.20.2 - 26.2}
         */
        public static final SimpleField<Integer> TRANSFORMATION_INTERPOLATION_DURATION = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_20_2, ServerVersion.V_26_2, 9, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.20.2 - 26.2}
         */
        public static final SimpleField<Integer> TRANSFORMATION_INTERPOLATION_START_DELTA_TICKS = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_20_2, ServerVersion.V_26_2, 8, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.19.4 - 26.2}
         */
        public static final SimpleField<Vector3f> TRANSLATION = SimpleField.<Vector3f>builder()
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_19_4, 10, EntityDataTypes.VECTOR3F)
            .addVersionRange(ServerVersion.V_1_20_2, ServerVersion.V_1_21_9, 11, EntityDataTypes.VECTOR3F)
            .addVersionRange(ServerVersion.V_1_21_11, ServerVersion.V_26_2, 11, EntityDataTypes.VECTOR3F)
            .build();

        /**
         * @mcversions {@code 1.19.4 - 26.2}
         */
        public static final SimpleField<Float> VIEW_RANGE = SimpleField.<Float>builder()
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_19_4, 16, EntityDataTypes.FLOAT)
            .addVersionRange(ServerVersion.V_1_20_2, ServerVersion.V_26_2, 17, EntityDataTypes.FLOAT)
            .build();

        /**
         * @mcversions {@code 1.19.4 - 26.2}
         */
        public static final SimpleField<Float> WIDTH = SimpleField.<Float>builder()
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_19_4, 19, EntityDataTypes.FLOAT)
            .addVersionRange(ServerVersion.V_1_20_2, ServerVersion.V_26_2, 20, EntityDataTypes.FLOAT)
            .build();

        public static final EntityMetaSchema SCHEMA = Entity.SCHEMA.extend(EntityTypes.DISPLAY)
            .add(Display.BILLBOARD_RENDER_CONSTRAINTS)
            .add(Display.BRIGHTNESS_OVERRIDE)
            .add(Display.GLOW_COLOR_OVERRIDE)
            .add(Display.HEIGHT)
            .add(Display.INTERPOLATION_DURATION)
            .add(Display.INTERPOLATION_START_DELTA_TICKS)
            .add(Display.LEFT_ROTATION)
            .add(Display.POS_ROT_INTERPOLATION_DURATION)
            .add(Display.RIGHT_ROTATION)
            .add(Display.SCALE)
            .add(Display.SHADOW_RADIUS)
            .add(Display.SHADOW_STRENGTH)
            .add(Display.TRANSFORMATION_INTERPOLATION_DURATION)
            .add(Display.TRANSFORMATION_INTERPOLATION_START_DELTA_TICKS)
            .add(Display.TRANSLATION)
            .add(Display.VIEW_RANGE)
            .add(Display.WIDTH)
            .build();

    }

    /**
     * @mcversions {@code 1.19.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Block_Display">Block Display on the minecraft.wiki</a>
     */
    public static class BlockDisplay extends Display {

        /**
         * @mcversions {@code 1.19.4 - 26.2}
         */
        public static final SimpleField<Integer> BLOCK_STATE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_19_4, 22, EntityDataTypes.BLOCK_STATE)
            .addVersionRange(ServerVersion.V_1_20_2, ServerVersion.V_26_2, 23, EntityDataTypes.BLOCK_STATE)
            .build();

        public static final EntityMetaSchema SCHEMA = Display.SCHEMA.extend(EntityTypes.BLOCK_DISPLAY)
            .add(BlockDisplay.BLOCK_STATE)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Boat">Boat on the minecraft.wiki</a>
     */
    public static class Boat extends AbstractBoat {

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Integer> BOAT_TYPE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 8, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 9, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 1.21}
         */
        public static final SimpleField<Integer> BUBBLE_TIME = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 13, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21, 14, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 1.20.2}
         */
        public static final SimpleField<Float> DAMAGE = SimpleField.<Float>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 9, EntityDataTypes.FLOAT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_20_2, 10, EntityDataTypes.FLOAT)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Float> DAMAGE_TAKEN = SimpleField.<Float>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 7, EntityDataTypes.FLOAT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 8, EntityDataTypes.FLOAT)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Integer> FORWARD_DIRECTION = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 6, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 7, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 1.20.2}
         */
        public static final SimpleField<Integer> HURT = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 7, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_20_2, 8, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 1.20.2}
         */
        public static final SimpleField<Integer> HURTDIR = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 8, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_20_2, 9, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 1.21}
         */
        public static final SimpleField<Boolean> PADDLE_LEFT = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 11, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21, 12, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 1.21}
         */
        public static final SimpleField<Boolean> PADDLE_RIGHT = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 12, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21, 13, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Integer> TIME_SINCE_HIT = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 5, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 6, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 1.21}
         */
        public static final SimpleField<Integer> TYPE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 10, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21, 11, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractBoat.SCHEMA.extend(EntityTypes.BOAT)
            .add(Boat.BOAT_TYPE)
            .add(Boat.BUBBLE_TIME)
            .add(Boat.DAMAGE)
            .add(Boat.DAMAGE_TAKEN)
            .add(Boat.FORWARD_DIRECTION)
            .add(Boat.HURT)
            .add(Boat.HURTDIR)
            .add(Boat.PADDLE_LEFT)
            .add(Boat.PADDLE_RIGHT)
            .add(Boat.TIME_SINCE_HIT)
            .add(Boat.TYPE)
            .build();

    }

    /**
     * @mcversions {@code 1.20.5 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Bogged">Bogged on the minecraft.wiki</a>
     */
    public static class Bogged extends AbstractSkeleton {

        /**
         * @mcversions {@code 1.20.5 - 26.2}
         */
        public static final SimpleField<Boolean> SHEARED = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_20_5, ServerVersion.V_26_2, 16, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractSkeleton.SCHEMA.extend(EntityTypes.BOGGED)
            .add(Bogged.SHEARED)
            .build();

    }

    /**
     * @mcversions {@code 1.20.3 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Breeze">Breeze on the minecraft.wiki</a>
     */
    public static class Breeze extends Monster {

        public static final EntityMetaSchema SCHEMA = Monster.SCHEMA.extend(EntityTypes.BREEZE)
            .build();

    }

    /**
     * @mcversions {@code 1.20.5 - 26.2}
     */
    public static class BreezeWindCharge extends AbstractWindCharge {

        public static final EntityMetaSchema SCHEMA = AbstractWindCharge.SCHEMA.extend(EntityTypes.BREEZE_WIND_CHARGE)
            .build();

    }

    /**
     * @mcversions {@code 1.19.3 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Camel">Camel on the minecraft.wiki</a>
     */
    public static class Camel extends AbstractHorse {

        /**
         * @mcversions {@code 1.19.3 - 26.2}
         */
        public static final SimpleField<Boolean> DASH = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_19_3, ServerVersion.V_1_19_3, 19, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_21_11, 18, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 19, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.19.3 - 26.2}
         */
        public static final SimpleField<Long> LAST_POSE_CHANGE_TICK = SimpleField.<Long>builder()
            .addVersionRange(ServerVersion.V_1_19_3, ServerVersion.V_1_19_3, 20, EntityDataTypes.LONG)
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_21_11, 19, EntityDataTypes.LONG)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 20, EntityDataTypes.LONG)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractHorse.SCHEMA.extend(EntityTypes.CAMEL)
            .add(Camel.DASH)
            .add(Camel.LAST_POSE_CHANGE_TICK)
            .build();

    }

    /**
     * @mcversions {@code 1.21.11 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Camel_Husk">Camel Husk on the minecraft.wiki</a>
     */
    public static class CamelHusk extends Camel {

        public static final EntityMetaSchema SCHEMA = Camel.SCHEMA.extend(EntityTypes.CAMEL_HUSK)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Cat">Cat on the minecraft.wiki</a>
     */
    public static class Cat extends TamableAnimal {

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Integer> COLLAR_COLOR = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 20, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 21, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 22, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 23, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Boolean> IS_LYING = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 18, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 19, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 20, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 21, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Boolean> RELAX_STATE_ONE = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 19, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 20, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 21, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 22, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 26.1 - 26.2}
         */
        public static final SimpleField<CatSoundVariant> SOUND_VARIANT = SimpleField.<CatSoundVariant>builder()
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 24, EntityDataTypes.CAT_SOUND_VARIANT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 1.17}
         */
        public static final SimpleField<Integer> TYPE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 17, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 18, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_17, 19, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.19 - 26.2}
         */
        public static final SimpleField<CatVariant> VARIANT = SimpleField.<CatVariant>builder()
            .addVersionRange(ServerVersion.V_1_19, ServerVersion.V_1_20_3, 19, EntityDataTypes.TYPED_CAT_VARIANT)
            .addVersionRange(ServerVersion.V_1_20_5, ServerVersion.V_1_21_11, 19, EntityDataTypes.TYPED_CAT_VARIANT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 20, EntityDataTypes.TYPED_CAT_VARIANT)
            .build();

        public static final EntityMetaSchema SCHEMA = TamableAnimal.SCHEMA.extend(EntityTypes.CAT)
            .add(Cat.COLLAR_COLOR)
            .add(Cat.IS_LYING)
            .add(Cat.RELAX_STATE_ONE)
            .add(Cat.SOUND_VARIANT)
            .add(Cat.TYPE)
            .add(Cat.VARIANT)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Spider">Spider on the minecraft.wiki</a>
     */
    public static class Spider extends Monster {

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Byte> CLIMBING = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 11, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 12, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Byte> FLAGS = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 14, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 15, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 16, EntityDataTypes.BYTE)
            .build();

        public static final EntityMetaSchema SCHEMA = Monster.SCHEMA.extend(EntityTypes.SPIDER)
            .add(Spider.CLIMBING)
            .add(Spider.FLAGS)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Cave_Spider">Cave Spider on the minecraft.wiki</a>
     */
    public static class CaveSpider extends Spider {

        public static final EntityMetaSchema SCHEMA = Spider.SCHEMA.extend(EntityTypes.CAVE_SPIDER)
            .build();

    }

    /**
     * @mcversions {@code 1.19 - 26.2}
     */
    public static class ChestBoat extends AbstractChestBoat {

        public static final EntityMetaSchema SCHEMA = AbstractChestBoat.SCHEMA.extend(EntityTypes.CHEST_BOAT)
            .build();

    }

    /**
     * @mcversions {@code 1.21.2 - 26.2}
     */
    public static class ChestRaft extends AbstractChestBoat {

        public static final EntityMetaSchema SCHEMA = AbstractChestBoat.SCHEMA.extend(null) // TODO Entity Type need mappings
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Chicken">Chicken on the minecraft.wiki</a>
     */
    public static class Chicken extends Animal {

        /**
         * @mcversions {@code 26.1 - 26.2}
         */
        public static final SimpleField<ChickenSoundVariant> SOUND_VARIANT = SimpleField.<ChickenSoundVariant>builder()
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 19, EntityDataTypes.CHICKEN_SOUND_VARIANT)
            .build();

        /**
         * @mcversions {@code 1.21.5 - 26.2}
         */
        public static final SimpleField<ChickenVariant> VARIANT = SimpleField.<ChickenVariant>builder()
            .addVersionRange(ServerVersion.V_1_21_5, ServerVersion.V_1_21_11, 17, EntityDataTypes.CHICKEN_VARIANT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 18, EntityDataTypes.CHICKEN_VARIANT)
            .build();

        public static final EntityMetaSchema SCHEMA = Animal.SCHEMA.extend(EntityTypes.CHICKEN)
            .add(Chicken.SOUND_VARIANT)
            .add(Chicken.VARIANT)
            .build();

    }

    /**
     * @mcversions {@code 1.21.9 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Mannequin">Mannequin on the minecraft.wiki</a>
     */
    public static class Mannequin extends Avatar {

        /**
         * @mcversions {@code 1.21.9 - 26.2}
         */
        public static final SimpleField<Optional<Component>> DESCRIPTION = SimpleField.<Optional<Component>>builder()
            .addVersionRange(ServerVersion.V_1_21_9, ServerVersion.V_26_2, 19, EntityDataTypes.OPTIONAL_ADV_COMPONENT)
            .build();

        /**
         * @mcversions {@code 1.21.9 - 26.2}
         */
        public static final SimpleField<Boolean> IMMOVABLE = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_21_9, ServerVersion.V_26_2, 18, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.21.9 - 26.2}
         */
        public static final SimpleField<ItemProfile> PROFILE = SimpleField.<ItemProfile>builder()
            .addVersionRange(ServerVersion.V_1_21_9, ServerVersion.V_26_2, 17, EntityDataTypes.RESOLVABLE_PROFILE)
            .build();

        public static final EntityMetaSchema SCHEMA = Avatar.SCHEMA.extend(EntityTypes.MANNEQUIN)
            .add(Mannequin.DESCRIPTION)
            .add(Mannequin.IMMOVABLE)
            .add(Mannequin.PROFILE)
            .build();

    }

    /**
     * @mcversions {@code 1.21.9 - 26.2}
     */
    public static class ClientMannequin extends Mannequin {

        public static final EntityMetaSchema SCHEMA = Mannequin.SCHEMA.extend(null) // TODO Entity Type need mappings
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Cod">Cod on the minecraft.wiki</a>
     */
    public static class Cod extends AbstractSchoolingFish {

        public static final EntityMetaSchema SCHEMA = AbstractSchoolingFish.SCHEMA.extend(EntityTypes.COD)
            .build();

    }

    /**
     * @mcversions {@code 1.21.9 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Copper_Golem">Copper Golem on the minecraft.wiki</a>
     */
    public static class CopperGolem extends AbstractGolem {

        /**
         * @mcversions {@code 1.21.9 - 26.2}
         */
        public static final SimpleField<CopperGolemState> COPPER_GOLEM_STATE = SimpleField.<CopperGolemState>builder()
            .addVersionRange(ServerVersion.V_1_21_9, ServerVersion.V_26_2, 17, EntityDataTypes.COPPER_GOLEM_STATE)
            .build();

        /**
         * @mcversions {@code 1.21.9 - 26.2}
         */
        public static final SimpleField<WeatheringCopperState> WEATHER_STATE = SimpleField.<WeatheringCopperState>builder()
            .addVersionRange(ServerVersion.V_1_21_9, ServerVersion.V_26_2, 16, EntityDataTypes.WEATHERING_COPPER_STATE)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractGolem.SCHEMA.extend(EntityTypes.COPPER_GOLEM)
            .add(CopperGolem.COPPER_GOLEM_STATE)
            .add(CopperGolem.WEATHER_STATE)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Cow">Cow on the minecraft.wiki</a>
     */
    public static class Cow extends AbstractCow {

        /**
         * @mcversions {@code 26.1 - 26.2}
         */
        public static final SimpleField<CowSoundVariant> SOUND_VARIANT = SimpleField.<CowSoundVariant>builder()
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 19, EntityDataTypes.COW_SOUND_VARIANT)
            .build();

        /**
         * @mcversions {@code 1.21.5 - 26.2}
         */
        public static final SimpleField<CowVariant> VARIANT = SimpleField.<CowVariant>builder()
            .addVersionRange(ServerVersion.V_1_21_5, ServerVersion.V_1_21_11, 17, EntityDataTypes.COW_VARIANT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 18, EntityDataTypes.COW_VARIANT)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractCow.SCHEMA.extend(EntityTypes.COW)
            .add(Cow.SOUND_VARIANT)
            .add(Cow.VARIANT)
            .build();

    }

    /**
     * @mcversions {@code 1.21.2 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Creaking">Creaking on the minecraft.wiki</a>
     */
    public static class Creaking extends Monster {

        /**
         * @mcversions {@code 1.21.2 - 26.2}
         */
        public static final SimpleField<Boolean> CAN_MOVE = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_21_2, ServerVersion.V_26_2, 16, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.21.4 - 26.2}
         */
        public static final SimpleField<Optional<Vector3i>> HOME_POS = SimpleField.<Optional<Vector3i>>builder()
            .addVersionRange(ServerVersion.V_1_21_4, ServerVersion.V_26_2, 19, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .build();

        /**
         * @mcversions {@code 1.21.2 - 26.2}
         */
        public static final SimpleField<Boolean> IS_ACTIVE = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_21_2, ServerVersion.V_26_2, 17, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.21.4 - 26.2}
         */
        public static final SimpleField<Boolean> IS_TEARING_DOWN = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_21_4, ServerVersion.V_26_2, 18, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = Monster.SCHEMA.extend(EntityTypes.CREAKING)
            .add(Creaking.CAN_MOVE)
            .add(Creaking.HOME_POS)
            .add(Creaking.IS_ACTIVE)
            .add(Creaking.IS_TEARING_DOWN)
            .build();

    }

    /**
     * @mcversions {@code 1.21.2}
     */
    public static class CreakingTransient extends Creaking {

        public static final EntityMetaSchema SCHEMA = Creaking.SCHEMA.extend(EntityTypes.CREAKING_TRANSIENT)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Creeper">Creeper on the minecraft.wiki</a>
     */
    public static class Creeper extends Monster {

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Boolean> IGNITED = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 13, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 14, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Boolean> IS_IGNITED = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 16, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 17, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 18, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Boolean> IS_POWERED = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 15, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 16, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 17, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Boolean> POWERED = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 12, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 13, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Integer> STATE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 11, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 12, EntityDataTypes.INT)
            .build();

        /**
         * @view {@link CreeperSwellStateView}
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final ViewField<Integer, CreeperSwellStateView> SWELL_DIR = ViewField.builder(CreeperSwellStateView::new)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 14, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 15, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 16, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = Monster.SCHEMA.extend(EntityTypes.CREEPER)
            .add(Creeper.IGNITED)
            .add(Creeper.IS_IGNITED)
            .add(Creeper.IS_POWERED)
            .add(Creeper.POWERED)
            .add(Creeper.STATE)
            .add(Creeper.SWELL_DIR)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Dolphin">Dolphin on the minecraft.wiki</a>
     */
    public static class Dolphin extends AgeableWaterCreature {

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Boolean> GOT_FISH = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 15, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 16, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21, 17, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_21_2, ServerVersion.V_1_21_4, 18, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_21_5, ServerVersion.V_1_21_11, 17, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 18, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Integer> MOISTNESS_LEVEL = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 16, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 17, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21, 18, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_21_2, ServerVersion.V_1_21_4, 19, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_21_5, ServerVersion.V_1_21_11, 18, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 19, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 1.21.4}
         */
        public static final SimpleField<Vector3i> TREASURE_POS = SimpleField.<Vector3i>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 14, EntityDataTypes.BLOCK_POSITION)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 15, EntityDataTypes.BLOCK_POSITION)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21, 16, EntityDataTypes.BLOCK_POSITION)
            .addVersionRange(ServerVersion.V_1_21_2, ServerVersion.V_1_21_4, 17, EntityDataTypes.BLOCK_POSITION)
            .build();

        public static final EntityMetaSchema SCHEMA = AgeableWaterCreature.SCHEMA.extend(EntityTypes.DOLPHIN)
            .add(Dolphin.GOT_FISH)
            .add(Dolphin.MOISTNESS_LEVEL)
            .add(Dolphin.TREASURE_POS)
            .build();

    }

    /**
     * @mcversions {@code 1.11.2 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Donkey">Donkey on the minecraft.wiki</a>
     */
    public static class Donkey extends AbstractChestedHorse {

        public static final EntityMetaSchema SCHEMA = AbstractChestedHorse.SCHEMA.extend(EntityTypes.DONKEY)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Dragon_Fireball">Dragon Fireball on the minecraft.wiki</a>
     */
    public static class DragonFireball extends AbstractHurtingProjectile {

        public static final EntityMetaSchema SCHEMA = AbstractHurtingProjectile.SCHEMA.extend(EntityTypes.DRAGON_FIREBALL)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Zombie">Zombie on the minecraft.wiki</a>
     */
    public static class Zombie extends Monster {

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Boolean> ARMS_RAISED = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_12_2, 14, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Boolean> BABY = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 14, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 15, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 16, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.10}
         */
        public static final SimpleField<Boolean> CONVERTING = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 13, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Boolean> DROWNED_CONVERSION = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 16, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 17, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 18, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Boolean> IS_CHILD = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 11, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 12, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Integer> SPECIAL_TYPE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 15, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 16, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 17, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Integer> VILLAGER_TYPE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 12, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 13, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = Monster.SCHEMA.extend(EntityTypes.ZOMBIE)
            .add(Zombie.ARMS_RAISED)
            .add(Zombie.BABY)
            .add(Zombie.CONVERTING)
            .add(Zombie.DROWNED_CONVERSION)
            .add(Zombie.IS_CHILD)
            .add(Zombie.SPECIAL_TYPE)
            .add(Zombie.VILLAGER_TYPE)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Drowned">Drowned on the minecraft.wiki</a>
     */
    public static class Drowned extends Zombie {

        public static final EntityMetaSchema SCHEMA = Zombie.SCHEMA.extend(EntityTypes.DROWNED)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Guardian">Guardian on the minecraft.wiki</a>
     */
    public static class Guardian extends Monster {

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Integer> ATTACK_TARGET = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 15, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 16, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 17, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.12.2 - 26.2}
         */
        public static final SimpleField<Boolean> MOVING = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_12_2, ServerVersion.V_1_12_2, 12, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 14, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 15, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 16, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.10}
         */
        public static final SimpleField<Byte> STATUS = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 11, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Integer> TARGET_ENTITY = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_12, 12, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_12_2, ServerVersion.V_1_12_2, 13, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = Monster.SCHEMA.extend(EntityTypes.GUARDIAN)
            .add(Guardian.ATTACK_TARGET)
            .add(Guardian.MOVING)
            .add(Guardian.STATUS)
            .add(Guardian.TARGET_ENTITY)
            .build();

    }

    /**
     * @mcversions {@code 1.11.2 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Elder_Guardian">Elder Guardian on the minecraft.wiki</a>
     */
    public static class ElderGuardian extends Guardian {

        public static final EntityMetaSchema SCHEMA = Guardian.SCHEMA.extend(EntityTypes.ELDER_GUARDIAN)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#End_Crystal">End Crystal on the minecraft.wiki</a>
     */
    public static class EndCrystal extends Entity {

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Optional<Vector3i>> BEAM_TARGET = SimpleField.<Optional<Vector3i>>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 7, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 8, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 26.2}
         */
        public static final SimpleField<Boolean> SHOW_BOTTOM = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 5, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 6, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 8, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 9, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = Entity.SCHEMA.extend(EntityTypes.END_CRYSTAL)
            .add(EndCrystal.BEAM_TARGET)
            .add(EndCrystal.SHOW_BOTTOM)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Ender_Dragon">Ender Dragon on the minecraft.wiki</a>
     */
    public static class EnderDragon extends Mob {

        /**
         * @view {@link EnderDragonPhaseView}
         * @mcversions {@code 1.9.4 - 26.2}
         */
        public static final ViewField<Integer, EnderDragonPhaseView> PHASE = ViewField.builder(EnderDragonPhaseView::new)
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 11, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 12, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 14, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 15, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 16, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = Mob.SCHEMA.extend(EntityTypes.ENDER_DRAGON)
            .add(EnderDragon.PHASE)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 1.11.2, 1.14.4 - 26.2}
     */
    public static class EnderDragonPart extends Entity {

        public static final EntityMetaSchema SCHEMA = Entity.SCHEMA.extend(null) // TODO Entity Type need mappings
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class EnderMan extends Monster {

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Integer> CARRY_STATE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 14, EntityDataTypes.OPTIONAL_BLOCK_STATE)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 15, EntityDataTypes.OPTIONAL_BLOCK_STATE)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 16, EntityDataTypes.OPTIONAL_BLOCK_STATE)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Boolean> CREEPY = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 15, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 16, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 17, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Boolean> SCREAMING = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 11, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 12, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.15 - 26.2}
         */
        public static final SimpleField<Boolean> STARED_AT = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 17, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 18, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = Monster.SCHEMA.extend(EntityTypes.ENDERMAN)
            .add(EnderMan.CARRY_STATE)
            .add(EnderMan.CREEPY)
            .add(EnderMan.SCREAMING)
            .add(EnderMan.STARED_AT)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Endermite">Endermite on the minecraft.wiki</a>
     */
    public static class Endermite extends Monster {

        public static final EntityMetaSchema SCHEMA = Monster.SCHEMA.extend(EntityTypes.ENDERMITE)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 1.12.2}
     */
    public static class EntityOtherPlayerMP extends AbstractClientPlayer {

        public static final EntityMetaSchema SCHEMA = AbstractClientPlayer.SCHEMA.extend(null) // TODO Entity Type need mappings
            .build();

    }

    /**
     * @mcversions {@code 1.12 - 26.2}
     */
    public static class ShoulderRidingEntity extends TamableAnimal {

        public static final EntityMetaSchema SCHEMA = TamableAnimal.SCHEMA.extend(null) // TODO Entity Type need mappings
            .build();

    }

    /**
     * @mcversions {@code 1.12 - 1.12.2}
     */
    public static class EntityParrot extends ShoulderRidingEntity {

        /**
         * @mcversions {@code 1.12.2}
         */
        public static final SimpleField<Integer> VARIANT = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_12_2, ServerVersion.V_1_12_2, 14, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = ShoulderRidingEntity.SCHEMA.extend(null) // TODO Entity Type need mappings
            .add(EntityParrot.VARIANT)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 1.12.2}
     */
    public static class EntityPig extends Animal {

        /**
         * @mcversions {@code 1.12.2}
         */
        public static final SimpleField<Integer> BOOST_TIME = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_12_2, ServerVersion.V_1_12_2, 14, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Boolean> SADDLED = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 12, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 13, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = Animal.SCHEMA.extend(null) // TODO Entity Type need mappings
            .add(EntityPig.BOOST_TIME)
            .add(EntityPig.SADDLED)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 1.12.2}
     */
    public static class EntityPlayerMP extends Player {

        public static final EntityMetaSchema SCHEMA = Player.SCHEMA.extend(null) // TODO Entity Type need mappings
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 1.12.2}
     */
    public static class EntityPlayerSP extends AbstractClientPlayer {

        public static final EntityMetaSchema SCHEMA = AbstractClientPlayer.SCHEMA.extend(null) // TODO Entity Type need mappings
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 1.12.2}
     */
    public static class EntityPotion extends ThrowableItemProjectile {

        /**
         * @mcversions {@code 1.11.2 - 1.12.2}
         */
        public static final SimpleField<ItemStack> ITEM = SimpleField.<ItemStack>builder()
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 6, EntityDataTypes.ITEMSTACK)
            .build();

        public static final EntityMetaSchema SCHEMA = ThrowableItemProjectile.SCHEMA.extend(null) // TODO Entity Type need mappings
            .add(EntityPotion.ITEM)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 1.12.2}
     */
    public static class EntityTippedArrow extends Arrow {

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Integer> COLOR = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 6, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 7, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = Arrow.SCHEMA.extend(null) // TODO Entity Type need mappings
            .add(EntityTippedArrow.COLOR)
            .build();

    }

    /**
     * @mcversions {@code 1.12 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Spellcaster_Illager">Spellcaster Illager on the minecraft.wiki</a>
     */
    public static class SpellcasterIllager extends AbstractIllager {

        /**
         * @mcversions {@code 1.12.2}
         */
        public static final SimpleField<Byte> SPELL = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_12_2, ServerVersion.V_1_12_2, 13, EntityDataTypes.BYTE)
            .build();

        /**
         * @view {@link SpellcasterIllagerSpellCastingView}
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final ViewField<Byte, SpellcasterIllagerSpellCastingView> SPELL_CASTING = ViewField.builder(SpellcasterIllagerSpellCastingView::new)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 15, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 16, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 17, EntityDataTypes.BYTE)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractIllager.SCHEMA.extend(null) // TODO Entity Type need mappings
            .add(SpellcasterIllager.SPELL)
            .add(SpellcasterIllager.SPELL_CASTING)
            .build();

    }

    /**
     * @mcversions {@code 1.11.2 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Evoker">Evoker on the minecraft.wiki</a>
     */
    public static class Evoker extends SpellcasterIllager {

        public static final EntityMetaSchema SCHEMA = SpellcasterIllager.SCHEMA.extend(EntityTypes.EVOKER)
            .build();

    }

    /**
     * @mcversions {@code 1.11.2 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Evoker_Fangs">Evoker Fangs on the minecraft.wiki</a>
     */
    public static class EvokerFangs extends Entity {

        public static final EntityMetaSchema SCHEMA = Entity.SCHEMA.extend(EntityTypes.EVOKER_FANGS)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Experience_Orb">Experience Orb on the minecraft.wiki</a>
     */
    public static class ExperienceOrb extends Entity {

        /**
         * @mcversions {@code 1.21.5 - 26.2}
         */
        public static final SimpleField<Integer> VALUE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_21_5, ServerVersion.V_26_2, 8, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = Entity.SCHEMA.extend(EntityTypes.EXPERIENCE_ORB)
            .add(ExperienceOrb.VALUE)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class EyeOfEnder extends Entity {

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<ItemStack> ITEM_STACK = SimpleField.<ItemStack>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 7, EntityDataTypes.ITEMSTACK)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 8, EntityDataTypes.ITEMSTACK)
            .build();

        public static final EntityMetaSchema SCHEMA = Entity.SCHEMA.extend(EntityTypes.EYE_OF_ENDER)
            .add(EyeOfEnder.ITEM_STACK)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class FallingBlockEntity extends Entity {

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Vector3i> ORIGIN = SimpleField.<Vector3i>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 5, EntityDataTypes.BLOCK_POSITION)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 6, EntityDataTypes.BLOCK_POSITION)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Vector3i> START_POS = SimpleField.<Vector3i>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 7, EntityDataTypes.BLOCK_POSITION)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 8, EntityDataTypes.BLOCK_POSITION)
            .build();

        public static final EntityMetaSchema SCHEMA = Entity.SCHEMA.extend(EntityTypes.FALLING_BLOCK)
            .add(FallingBlockEntity.ORIGIN)
            .add(FallingBlockEntity.START_POS)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Fireball">Fireball on the minecraft.wiki</a>
     */
    public static class Fireball extends AbstractHurtingProjectile {

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<ItemStack> ITEM_STACK = SimpleField.<ItemStack>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 7, EntityDataTypes.ITEMSTACK)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 8, EntityDataTypes.ITEMSTACK)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractHurtingProjectile.SCHEMA.extend(EntityTypes.FIREBALL)
            .add(Fireball.ITEM_STACK)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class FireworkRocketEntity extends Projectile {

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Optional<Integer>> ATTACHED_TO_TARGET = SimpleField.<Optional<Integer>>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 8, EntityDataTypes.OPTIONAL_INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 9, EntityDataTypes.OPTIONAL_INT)
            .build();

        /**
         * @mcversions {@code 1.12.2}
         */
        public static final SimpleField<Integer> BOOSTED_ENTITY = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_12_2, ServerVersion.V_1_12_2, 7, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<ItemStack> FIREWORKS_ITEM = SimpleField.<ItemStack>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 7, EntityDataTypes.ITEMSTACK)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 8, EntityDataTypes.ITEMSTACK)
            .build();

        /**
         * @mcversions {@code 1.11.2 - 1.12.2}
         */
        public static final SimpleField<ItemStack> FIREWORK_ITEM = SimpleField.<ItemStack>builder()
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 6, EntityDataTypes.ITEMSTACK)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Boolean> SHOT_AT_ANGLE = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 9, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 10, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = Projectile.SCHEMA.extend(EntityTypes.FIREWORK_ROCKET)
            .add(FireworkRocketEntity.ATTACHED_TO_TARGET)
            .add(FireworkRocketEntity.BOOSTED_ENTITY)
            .add(FireworkRocketEntity.FIREWORKS_ITEM)
            .add(FireworkRocketEntity.FIREWORK_ITEM)
            .add(FireworkRocketEntity.SHOT_AT_ANGLE)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class FishingHook extends Projectile {

        /**
         * @mcversions {@code 1.16 - 26.2}
         */
        public static final SimpleField<Boolean> BITING = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_16, ServerVersion.V_1_16_2, 8, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 9, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 26.2}
         */
        public static final SimpleField<Integer> HOOKED_ENTITY = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 5, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 6, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 7, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 8, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = Projectile.SCHEMA.extend(EntityTypes.FISHING_BOBBER)
            .add(FishingHook.BITING)
            .add(FishingHook.HOOKED_ENTITY)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 1.21.5}
     */
    public static class FlyingMob extends Mob {

        public static final EntityMetaSchema SCHEMA = Mob.SCHEMA.extend(EntityTypes.ABSTRACT_FLYING)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Fox">Fox on the minecraft.wiki</a>
     */
    public static class Fox extends Animal {

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Byte> FLAGS = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 16, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 17, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 18, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 19, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Optional<UUID>> TRUSTED_0 = SimpleField.<Optional<UUID>>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 17, EntityDataTypes.OPTIONAL_UUID)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 18, EntityDataTypes.OPTIONAL_UUID)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_4, 19, EntityDataTypes.OPTIONAL_UUID)
            .addVersionRange(ServerVersion.V_1_21_5, ServerVersion.V_1_21_11, 19, EntityDataTypes.OPTIONAL_UUID)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 20, EntityDataTypes.OPTIONAL_UUID)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Optional<UUID>> TRUSTED_1 = SimpleField.<Optional<UUID>>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 18, EntityDataTypes.OPTIONAL_UUID)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 19, EntityDataTypes.OPTIONAL_UUID)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_4, 20, EntityDataTypes.OPTIONAL_UUID)
            .addVersionRange(ServerVersion.V_1_21_5, ServerVersion.V_1_21_11, 20, EntityDataTypes.OPTIONAL_UUID)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 21, EntityDataTypes.OPTIONAL_UUID)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Integer> TYPE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 15, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 16, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 17, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 18, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = Animal.SCHEMA.extend(EntityTypes.FOX)
            .add(Fox.FLAGS)
            .add(Fox.TRUSTED_0)
            .add(Fox.TRUSTED_1)
            .add(Fox.TYPE)
            .build();

    }

    /**
     * @mcversions {@code 1.19 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Frog">Frog on the minecraft.wiki</a>
     */
    public static class Frog extends Animal {

        /**
         * @mcversions {@code 1.19 - 26.2}
         */
        public static final SimpleField<Optional<Integer>> TONGUE_TARGET = SimpleField.<Optional<Integer>>builder()
            .addVersionRange(ServerVersion.V_1_19, ServerVersion.V_1_21_11, 18, EntityDataTypes.OPTIONAL_INT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 19, EntityDataTypes.OPTIONAL_INT)
            .build();

        /**
         * @mcversions {@code 1.19 - 26.2}
         */
        public static final SimpleField<FrogVariant> VARIANT = SimpleField.<FrogVariant>builder()
            .addVersionRange(ServerVersion.V_1_19, ServerVersion.V_1_20_3, 17, EntityDataTypes.TYPED_FROG_VARIANT)
            .addVersionRange(ServerVersion.V_1_20_5, ServerVersion.V_1_21_11, 17, EntityDataTypes.TYPED_FROG_VARIANT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 18, EntityDataTypes.TYPED_FROG_VARIANT)
            .build();

        public static final EntityMetaSchema SCHEMA = Animal.SCHEMA.extend(EntityTypes.FROG)
            .add(Frog.TONGUE_TARGET)
            .add(Frog.VARIANT)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Ghast">Ghast on the minecraft.wiki</a>
     */
    public static class Ghast extends Mob {

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Boolean> ATTACKING = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 11, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 12, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Boolean> IS_CHARGING = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 14, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 15, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 16, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = Mob.SCHEMA.extend(EntityTypes.GHAST)
            .add(Ghast.ATTACKING)
            .add(Ghast.IS_CHARGING)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Giant">Giant on the minecraft.wiki</a>
     */
    public static class Giant extends Monster {

        public static final EntityMetaSchema SCHEMA = Monster.SCHEMA.extend(EntityTypes.GIANT)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class HangingEntity extends BlockAttachedEntity {

        /**
         * @mcversions {@code 1.21.6 - 26.2}
         */
        public static final SimpleField<BlockFace> DIRECTION = SimpleField.<BlockFace>builder()
            .addVersionRange(ServerVersion.V_1_21_6, ServerVersion.V_26_2, 8, EntityDataTypes.BLOCK_FACE)
            .build();

        public static final EntityMetaSchema SCHEMA = BlockAttachedEntity.SCHEMA.extend(EntityTypes.ABSTRACT_HANGING)
            .add(HangingEntity.DIRECTION)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Item_Frame">Item Frame on the minecraft.wiki</a>
     */
    public static class ItemFrame extends HangingEntity {

        /**
         * @mcversions {@code 1.11.2 - 26.2}
         */
        public static final SimpleField<ItemStack> ITEM = SimpleField.<ItemStack>builder()
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 6, EntityDataTypes.ITEMSTACK)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 7, EntityDataTypes.ITEMSTACK)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_5, 8, EntityDataTypes.ITEMSTACK)
            .addVersionRange(ServerVersion.V_1_21_6, ServerVersion.V_26_2, 9, EntityDataTypes.ITEMSTACK)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 26.2}
         */
        public static final SimpleField<Integer> ROTATION = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 5, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 7, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 8, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_5, 9, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_21_6, ServerVersion.V_26_2, 10, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = HangingEntity.SCHEMA.extend(EntityTypes.ITEM_FRAME)
            .add(ItemFrame.ITEM)
            .add(ItemFrame.ROTATION)
            .build();

    }

    /**
     * @mcversions {@code 1.17 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Glow_Item_Frame">Glow Item Frame on the minecraft.wiki</a>
     */
    public static class GlowItemFrame extends ItemFrame {

        public static final EntityMetaSchema SCHEMA = ItemFrame.SCHEMA.extend(EntityTypes.GLOW_ITEM_FRAME)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Squid">Squid on the minecraft.wiki</a>
     */
    public static class Squid extends AgeableWaterCreature {

        public static final EntityMetaSchema SCHEMA = AgeableWaterCreature.SCHEMA.extend(EntityTypes.SQUID)
            .build();

    }

    /**
     * @mcversions {@code 1.17 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Glow_Squid">Glow Squid on the minecraft.wiki</a>
     */
    public static class GlowSquid extends Squid {

        /**
         * @mcversions {@code 1.17 - 26.2}
         */
        public static final SimpleField<Integer> DARK_TICKS_REMAINING = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21, 16, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_21_2, ServerVersion.V_1_21_11, 17, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 18, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = Squid.SCHEMA.extend(EntityTypes.GLOW_SQUID)
            .add(GlowSquid.DARK_TICKS_REMAINING)
            .build();

    }

    /**
     * @mcversions {@code 1.17 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Goat">Goat on the minecraft.wiki</a>
     */
    public static class Goat extends Animal {

        /**
         * @mcversions {@code 1.19 - 26.2}
         */
        public static final SimpleField<Boolean> HAS_LEFT_HORN = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_19, ServerVersion.V_1_21_11, 18, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 19, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.19 - 26.2}
         */
        public static final SimpleField<Boolean> HAS_RIGHT_HORN = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_19, ServerVersion.V_1_21_11, 19, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 20, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.17 - 26.2}
         */
        public static final SimpleField<Boolean> IS_SCREAMING_GOAT = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 17, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 18, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = Animal.SCHEMA.extend(EntityTypes.GOAT)
            .add(Goat.HAS_LEFT_HORN)
            .add(Goat.HAS_RIGHT_HORN)
            .add(Goat.IS_SCREAMING_GOAT)
            .build();

    }

    /**
     * @mcversions {@code 1.21.6 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Happy_Ghast">Happy Ghast on the minecraft.wiki</a>
     */
    public static class HappyGhast extends Animal {

        /**
         * @mcversions {@code 1.21.6 - 26.2}
         */
        public static final SimpleField<Boolean> IS_LEASH_HOLDER = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_21_6, ServerVersion.V_1_21_11, 17, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 18, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.21.6 - 26.2}
         */
        public static final SimpleField<Boolean> STAYS_STILL = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_21_6, ServerVersion.V_1_21_11, 18, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 19, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = Animal.SCHEMA.extend(EntityTypes.HAPPY_GHAST)
            .add(HappyGhast.IS_LEASH_HOLDER)
            .add(HappyGhast.STAYS_STILL)
            .build();

    }

    /**
     * @mcversions {@code 1.16 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Hoglin">Hoglin on the minecraft.wiki</a>
     */
    public static class Hoglin extends Animal {

        /**
         * @mcversions {@code 1.16 - 26.2}
         */
        public static final SimpleField<Boolean> IMMUNE_TO_ZOMBIFICATION = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_16, ServerVersion.V_1_16_2, 16, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 17, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 18, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = Animal.SCHEMA.extend(EntityTypes.HOGLIN)
            .add(Hoglin.IMMUNE_TO_ZOMBIFICATION)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Horse">Horse on the minecraft.wiki</a>
     */
    public static class Horse extends AbstractHorse {

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Integer> HORSE_ARMOR = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_12_2, 15, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.10}
         */
        public static final SimpleField<Integer> HORSE_TYPE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 13, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Integer> HORSE_VARIANT = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_12_2, 14, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.10}
         */
        public static final SimpleField<Byte> STATUS = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 12, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Integer> TYPE_VARIANT = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 17, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 18, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_19_3, 19, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_21_11, 18, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 19, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractHorse.SCHEMA.extend(EntityTypes.HORSE)
            .add(Horse.HORSE_ARMOR)
            .add(Horse.HORSE_TYPE)
            .add(Horse.HORSE_VARIANT)
            .add(Horse.STATUS)
            .add(Horse.TYPE_VARIANT)
            .build();

    }

    /**
     * @mcversions {@code 1.11.2 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Husk">Husk on the minecraft.wiki</a>
     */
    public static class Husk extends Zombie {

        public static final EntityMetaSchema SCHEMA = Zombie.SCHEMA.extend(EntityTypes.HUSK)
            .build();

    }

    /**
     * @mcversions {@code 1.12 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Illusioner">Illusioner on the minecraft.wiki</a>
     */
    public static class Illusioner extends SpellcasterIllager {

        public static final EntityMetaSchema SCHEMA = SpellcasterIllager.SCHEMA.extend(EntityTypes.ILLUSIONER)
            .build();

    }

    /**
     * @mcversions {@code 1.19.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Interaction">Interaction on the minecraft.wiki</a>
     */
    public static class Interaction extends Entity {

        /**
         * @mcversions {@code 1.19.4 - 26.2}
         */
        public static final SimpleField<Float> HEIGHT = SimpleField.<Float>builder()
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_26_2, 9, EntityDataTypes.FLOAT)
            .build();

        /**
         * @mcversions {@code 1.19.4 - 26.2}
         */
        public static final SimpleField<Boolean> RESPONSE = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_26_2, 10, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.19.4 - 26.2}
         */
        public static final SimpleField<Float> WIDTH = SimpleField.<Float>builder()
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_26_2, 8, EntityDataTypes.FLOAT)
            .build();

        public static final EntityMetaSchema SCHEMA = Entity.SCHEMA.extend(EntityTypes.INTERACTION)
            .add(Interaction.HEIGHT)
            .add(Interaction.RESPONSE)
            .add(Interaction.WIDTH)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Iron_Golem">Iron Golem on the minecraft.wiki</a>
     */
    public static class IronGolem extends AbstractGolem {

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Byte> FLAGS = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 14, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 15, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 16, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Byte> PLAYER_CREATED = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 11, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 12, EntityDataTypes.BYTE)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractGolem.SCHEMA.extend(EntityTypes.IRON_GOLEM)
            .add(IronGolem.FLAGS)
            .add(IronGolem.PLAYER_CREATED)
            .build();

    }

    /**
     * @mcversions {@code 1.19.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Item_Display">Item Display on the minecraft.wiki</a>
     */
    public static class ItemDisplay extends Display {

        /**
         * @mcversions {@code 1.19.4 - 26.2}
         */
        public static final SimpleField<Byte> ITEM_DISPLAY = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_19_4, 23, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_20_2, ServerVersion.V_26_2, 24, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.19.4 - 26.2}
         */
        public static final SimpleField<ItemStack> ITEM_STACK = SimpleField.<ItemStack>builder()
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_19_4, 22, EntityDataTypes.ITEMSTACK)
            .addVersionRange(ServerVersion.V_1_20_2, ServerVersion.V_26_2, 23, EntityDataTypes.ITEMSTACK)
            .build();

        public static final EntityMetaSchema SCHEMA = Display.SCHEMA.extend(EntityTypes.ITEM_DISPLAY)
            .add(ItemDisplay.ITEM_DISPLAY)
            .add(ItemDisplay.ITEM_STACK)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class ItemEntity extends Entity {

        /**
         * @mcversions {@code 1.11.2 - 26.2}
         */
        public static final SimpleField<ItemStack> ITEM = SimpleField.<ItemStack>builder()
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 6, EntityDataTypes.ITEMSTACK)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 7, EntityDataTypes.ITEMSTACK)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 8, EntityDataTypes.ITEMSTACK)
            .build();

        public static final EntityMetaSchema SCHEMA = Entity.SCHEMA.extend(EntityTypes.ITEM)
            .add(ItemEntity.ITEM)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class LargeFireball extends Fireball {

        public static final EntityMetaSchema SCHEMA = Fireball.SCHEMA.extend(EntityTypes.FIREBALL)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class LeashFenceKnotEntity extends BlockAttachedEntity {

        public static final EntityMetaSchema SCHEMA = BlockAttachedEntity.SCHEMA.extend(EntityTypes.LEASH_KNOT)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Lightning_Bolt">Lightning Bolt on the minecraft.wiki</a>
     */
    public static class LightningBolt extends Entity {

        public static final EntityMetaSchema SCHEMA = Entity.SCHEMA.extend(EntityTypes.LIGHTNING_BOLT)
            .build();

    }

    /**
     * @mcversions {@code 1.11.2 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Llama">Llama on the minecraft.wiki</a>
     */
    public static class Llama extends AbstractChestedHorse {

        /**
         * @mcversions {@code 1.12.2}
         */
        public static final SimpleField<Integer> COLOR = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_12_2, ServerVersion.V_1_12_2, 16, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.12.2 - 26.2}
         */
        public static final SimpleField<Integer> STRENGTH = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_12_2, ServerVersion.V_1_12_2, 15, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 18, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 19, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_19_3, 20, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_21_11, 19, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 20, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 1.20.3}
         */
        public static final SimpleField<Integer> SWAG = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 19, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 20, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_19_3, 21, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_20_3, 20, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.12.2 - 26.2}
         */
        public static final SimpleField<Integer> VARIANT = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_12_2, ServerVersion.V_1_12_2, 17, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 20, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 21, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_19_3, 22, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_20_3, 21, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_20_5, ServerVersion.V_1_21_11, 20, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 21, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractChestedHorse.SCHEMA.extend(EntityTypes.LLAMA)
            .add(Llama.COLOR)
            .add(Llama.STRENGTH)
            .add(Llama.SWAG)
            .add(Llama.VARIANT)
            .build();

    }

    /**
     * @mcversions {@code 1.11.2 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Llama_Spit">Llama Spit on the minecraft.wiki</a>
     */
    public static class LlamaSpit extends Projectile {

        public static final EntityMetaSchema SCHEMA = Projectile.SCHEMA.extend(EntityTypes.LLAMA_SPIT)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     */
    public static class LocalPlayer extends AbstractClientPlayer {

        public static final EntityMetaSchema SCHEMA = AbstractClientPlayer.SCHEMA.extend(null) // TODO Entity Type need mappings
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Magma_Cube">Magma Cube on the minecraft.wiki</a>
     */
    public static class MagmaCube extends AbstractCubeMob {

        public static final EntityMetaSchema SCHEMA = AbstractCubeMob.SCHEMA.extend(EntityTypes.MAGMA_CUBE)
            .build();

    }

    /**
     * @mcversions {@code 1.17 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Marker">Marker on the minecraft.wiki</a>
     */
    public static class Marker extends Entity {

        public static final EntityMetaSchema SCHEMA = Entity.SCHEMA.extend(EntityTypes.MARKER)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Minecart">Minecart on the minecraft.wiki</a>
     */
    public static class Minecart extends AbstractMinecart {

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Float> DAMAGE = SimpleField.<Float>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 7, EntityDataTypes.FLOAT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 8, EntityDataTypes.FLOAT)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Integer> DISPLAY_TILE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 8, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 9, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Integer> DISPLAY_TILE_OFFSET = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 9, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 10, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Integer> ROLLING_AMPLITUDE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 5, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 6, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Integer> ROLLING_DIRECTION = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 6, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 7, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Boolean> SHOW_BLOCK = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 10, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 11, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractMinecart.SCHEMA.extend(EntityTypes.MINECART)
            .add(Minecart.DAMAGE)
            .add(Minecart.DISPLAY_TILE)
            .add(Minecart.DISPLAY_TILE_OFFSET)
            .add(Minecart.ROLLING_AMPLITUDE)
            .add(Minecart.ROLLING_DIRECTION)
            .add(Minecart.SHOW_BLOCK)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class MinecartChest extends AbstractMinecartContainer {

        public static final EntityMetaSchema SCHEMA = AbstractMinecartContainer.SCHEMA.extend(EntityTypes.MINECART_CHEST)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class MinecartCommandBlock extends AbstractMinecart {

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<String> COMMAND = SimpleField.<String>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 11, EntityDataTypes.STRING)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 12, EntityDataTypes.STRING)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<String> COMMAND_NAME = SimpleField.<String>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 13, EntityDataTypes.STRING)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_4, 14, EntityDataTypes.STRING)
            .addVersionRange(ServerVersion.V_1_21_5, ServerVersion.V_26_2, 13, EntityDataTypes.STRING)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 26.2}
         */
        public static final SimpleField<Component> LAST_OUTPUT = SimpleField.<Component>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 12, EntityDataTypes.ADV_COMPONENT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 13, EntityDataTypes.ADV_COMPONENT)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 14, EntityDataTypes.ADV_COMPONENT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_4, 15, EntityDataTypes.ADV_COMPONENT)
            .addVersionRange(ServerVersion.V_1_21_5, ServerVersion.V_26_2, 14, EntityDataTypes.ADV_COMPONENT)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractMinecart.SCHEMA.extend(EntityTypes.COMMAND_BLOCK_MINECART)
            .add(MinecartCommandBlock.COMMAND)
            .add(MinecartCommandBlock.COMMAND_NAME)
            .add(MinecartCommandBlock.LAST_OUTPUT)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class MinecartFurnace extends AbstractMinecart {

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Boolean> FUEL = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 13, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_4, 14, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_21_5, ServerVersion.V_26_2, 13, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Boolean> POWERED = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 11, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 12, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractMinecart.SCHEMA.extend(EntityTypes.MINECART_FURNACE)
            .add(MinecartFurnace.FUEL)
            .add(MinecartFurnace.POWERED)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class MinecartHopper extends AbstractMinecartContainer {

        public static final EntityMetaSchema SCHEMA = AbstractMinecartContainer.SCHEMA.extend(EntityTypes.MINECART_HOPPER)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class MinecartSpawner extends AbstractMinecart {

        public static final EntityMetaSchema SCHEMA = AbstractMinecart.SCHEMA.extend(EntityTypes.SPAWNER_MINECART)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class MinecartTNT extends AbstractMinecart {

        public static final EntityMetaSchema SCHEMA = AbstractMinecart.SCHEMA.extend(EntityTypes.MINECART_TNT)
            .build();

    }

    /**
     * @mcversions {@code 1.11.2 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Mule">Mule on the minecraft.wiki</a>
     */
    public static class Mule extends AbstractChestedHorse {

        public static final EntityMetaSchema SCHEMA = AbstractChestedHorse.SCHEMA.extend(EntityTypes.MULE)
            .build();

    }

    /**
     * @mcversions {@code 1.12 - 1.12.2}
     */
    public static class MultiPartEntityPart extends Entity {

        public static final EntityMetaSchema SCHEMA = Entity.SCHEMA.extend(null) // TODO Entity Type need mappings
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class MushroomCow extends AbstractCow {

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Integer> TYPE = SimpleField.<Integer>builder()
            // TODO type changed from 'String' to 'Integer', converter required
            // TODO type changed from 'String' to 'Integer', converter required
            // TODO type changed from 'String' to 'Integer', converter required
            .addVersionRange(ServerVersion.V_1_21_5, ServerVersion.V_1_21_11, 17, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 18, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractCow.SCHEMA.extend(null) // TODO Entity Type need mappings
            .add(MushroomCow.TYPE)
            .build();

    }

    /**
     * @mcversions {@code 1.21.11 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Nautilus">Nautilus on the minecraft.wiki</a>
     */
    public static class Nautilus extends AbstractNautilus {

        public static final EntityMetaSchema SCHEMA = AbstractNautilus.SCHEMA.extend(EntityTypes.NAUTILUS)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Ocelot">Ocelot on the minecraft.wiki</a>
     */
    public static class Ocelot extends Animal {

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Integer> OCELOT_VARIANT = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 13, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 14, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Boolean> TRUSTING = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 15, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 16, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 17, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 18, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = Animal.SCHEMA.extend(EntityTypes.OCELOT)
            .add(Ocelot.OCELOT_VARIANT)
            .add(Ocelot.TRUSTING)
            .build();

    }

    /**
     * @mcversions {@code 1.20.5 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Ominous_Item_Spawner">Ominous Item Spawner on the minecraft.wiki</a>
     */
    public static class OminousItemSpawner extends Entity {

        /**
         * @mcversions {@code 1.20.5 - 26.2}
         */
        public static final SimpleField<ItemStack> ITEM = SimpleField.<ItemStack>builder()
            .addVersionRange(ServerVersion.V_1_20_5, ServerVersion.V_26_2, 8, EntityDataTypes.ITEMSTACK)
            .build();

        public static final EntityMetaSchema SCHEMA = Entity.SCHEMA.extend(EntityTypes.OMINOUS_ITEM_SPAWNER)
            .add(OminousItemSpawner.ITEM)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Painting">Painting on the minecraft.wiki</a>
     */
    public static class Painting extends HangingEntity {

        /**
         * @mcversions {@code 1.19 - 26.2}
         */
        public static final SimpleField<PaintingVariant> PAINTING_VARIANT = SimpleField.<PaintingVariant>builder()
            .addVersionRange(ServerVersion.V_1_19, ServerVersion.V_1_21_5, 8, EntityDataTypes.PAINTING_VARIANT)
            .addVersionRange(ServerVersion.V_1_21_6, ServerVersion.V_26_2, 9, EntityDataTypes.PAINTING_VARIANT)
            .build();

        public static final EntityMetaSchema SCHEMA = HangingEntity.SCHEMA.extend(EntityTypes.PAINTING)
            .add(Painting.PAINTING_VARIANT)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Panda">Panda on the minecraft.wiki</a>
     */
    public static class Panda extends Animal {

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Integer> EAT_COUNTER = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 17, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 18, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 19, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 20, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Byte> FLAGS = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 20, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 21, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 22, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 23, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Byte> HIDDEN_GENE = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 19, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 20, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 21, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 22, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Byte> MAIN_GENE = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 18, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 19, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 20, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 21, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Integer> SNEEZE_COUNTER = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 16, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 17, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 18, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 19, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Integer> UNHAPPY_COUNTER = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 15, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 16, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 17, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 18, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = Animal.SCHEMA.extend(EntityTypes.PANDA)
            .add(Panda.EAT_COUNTER)
            .add(Panda.FLAGS)
            .add(Panda.HIDDEN_GENE)
            .add(Panda.MAIN_GENE)
            .add(Panda.SNEEZE_COUNTER)
            .add(Panda.UNHAPPY_COUNTER)
            .build();

    }

    /**
     * @mcversions {@code 1.21.11 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Parched">Parched on the minecraft.wiki</a>
     */
    public static class Parched extends AbstractSkeleton {

        public static final EntityMetaSchema SCHEMA = AbstractSkeleton.SCHEMA.extend(EntityTypes.PARCHED)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Parrot">Parrot on the minecraft.wiki</a>
     */
    public static class Parrot extends ShoulderRidingEntity {

        /**
         * @view {@link ParrotVariantView}
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final ViewField<Integer, ParrotVariantView> VARIANT = ViewField.builder(ParrotVariantView::new)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 17, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 18, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 19, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 20, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = ShoulderRidingEntity.SCHEMA.extend(EntityTypes.PARROT)
            .add(Parrot.VARIANT)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Phantom">Phantom on the minecraft.wiki</a>
     */
    public static class Phantom extends Mob {

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Integer> ID_SIZE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 14, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 15, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 16, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = Mob.SCHEMA.extend(EntityTypes.PHANTOM)
            .add(Phantom.ID_SIZE)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Pig">Pig on the minecraft.wiki</a>
     */
    public static class Pig extends Animal {

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Integer> BOOST_TIME = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 16, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 17, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_4, 18, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_21_5, ServerVersion.V_1_21_11, 17, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 18, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 1.21.4}
         */
        public static final SimpleField<Boolean> SADDLE = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 15, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 16, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_4, 17, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 26.1 - 26.2}
         */
        public static final SimpleField<PigSoundVariant> SOUND_VARIANT = SimpleField.<PigSoundVariant>builder()
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 20, EntityDataTypes.PIG_SOUND_VARIANT)
            .build();

        /**
         * @mcversions {@code 1.21.5 - 26.2}
         */
        public static final SimpleField<PigVariant> VARIANT = SimpleField.<PigVariant>builder()
            .addVersionRange(ServerVersion.V_1_21_5, ServerVersion.V_1_21_11, 18, EntityDataTypes.PIG_VARIANT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 19, EntityDataTypes.PIG_VARIANT)
            .build();

        public static final EntityMetaSchema SCHEMA = Animal.SCHEMA.extend(EntityTypes.PIG)
            .add(Pig.BOOST_TIME)
            .add(Pig.SADDLE)
            .add(Pig.SOUND_VARIANT)
            .add(Pig.VARIANT)
            .build();

    }

    /**
     * @mcversions {@code 1.16 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Piglin">Piglin on the minecraft.wiki</a>
     */
    public static class Piglin extends AbstractPiglin {

        /**
         * @mcversions {@code 1.16 - 26.2}
         */
        public static final SimpleField<Boolean> BABY = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_16, ServerVersion.V_1_16, 15, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_16_2, ServerVersion.V_1_16_2, 16, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 17, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.16}
         */
        public static final SimpleField<Boolean> IMMUNE_TO_ZOMBIFICATION = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_16, ServerVersion.V_1_16, 16, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.16 - 26.2}
         */
        public static final SimpleField<Boolean> IS_CHARGING_CROSSBOW = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_16, ServerVersion.V_1_16_2, 17, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 18, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.16 - 26.2}
         */
        public static final SimpleField<Boolean> IS_DANCING = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_16, ServerVersion.V_1_16_2, 18, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 19, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractPiglin.SCHEMA.extend(EntityTypes.PIGLIN)
            .add(Piglin.BABY)
            .add(Piglin.IMMUNE_TO_ZOMBIFICATION)
            .add(Piglin.IS_CHARGING_CROSSBOW)
            .add(Piglin.IS_DANCING)
            .build();

    }

    /**
     * @mcversions {@code 1.16.2 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Piglin_Brute">Piglin Brute on the minecraft.wiki</a>
     */
    public static class PiglinBrute extends AbstractPiglin {

        public static final EntityMetaSchema SCHEMA = AbstractPiglin.SCHEMA.extend(EntityTypes.PIGLIN_BRUTE)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Pillager">Pillager on the minecraft.wiki</a>
     */
    public static class Pillager extends AbstractIllager {

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Boolean> IS_CHARGING_CROSSBOW = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 15, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 16, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 17, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractIllager.SCHEMA.extend(EntityTypes.PILLAGER)
            .add(Pillager.IS_CHARGING_CROSSBOW)
            .build();

    }

    /**
     * @mcversions {@code 1.10 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Polar_Bear">Polar Bear on the minecraft.wiki</a>
     */
    public static class PolarBear extends Animal {

        /**
         * @mcversions {@code 1.11.2 - 1.12.2}
         */
        public static final SimpleField<Boolean> IS_STANDING = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 13, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Boolean> STANDING = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 15, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 16, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 17, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 18, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = Animal.SCHEMA.extend(EntityTypes.POLAR_BEAR)
            .add(PolarBear.IS_STANDING)
            .add(PolarBear.STANDING)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class PrimedTnt extends Entity {

        /**
         * @mcversions {@code 1.20.3 - 26.2}
         */
        public static final SimpleField<Integer> BLOCK_STATE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_20_3, ServerVersion.V_26_2, 9, EntityDataTypes.BLOCK_STATE)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 26.2}
         */
        public static final SimpleField<Integer> FUSE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 5, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 6, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 7, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 8, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = Entity.SCHEMA.extend(EntityTypes.PRIMED_TNT)
            .add(PrimedTnt.BLOCK_STATE)
            .add(PrimedTnt.FUSE)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Pufferfish">Pufferfish on the minecraft.wiki</a>
     */
    public static class Pufferfish extends AbstractFish {

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Integer> PUFF_STATE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 15, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 16, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 17, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractFish.SCHEMA.extend(EntityTypes.PUFFERFISH)
            .add(Pufferfish.PUFF_STATE)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Rabbit">Rabbit on the minecraft.wiki</a>
     */
    public static class Rabbit extends Animal {

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Integer> RABBIT_TYPE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 12, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 13, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Integer> TYPE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 15, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 16, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 17, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 18, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = Animal.SCHEMA.extend(EntityTypes.RABBIT)
            .add(Rabbit.RABBIT_TYPE)
            .add(Rabbit.TYPE)
            .build();

    }

    /**
     * @mcversions {@code 1.21.2 - 26.2}
     */
    public static class Raft extends AbstractBoat {

        public static final EntityMetaSchema SCHEMA = AbstractBoat.SCHEMA.extend(null) // TODO Entity Type need mappings
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Ravager">Ravager on the minecraft.wiki</a>
     */
    public static class Ravager extends Raider {

        public static final EntityMetaSchema SCHEMA = Raider.SCHEMA.extend(EntityTypes.RAVAGER)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     */
    public static class RemotePlayer extends AbstractClientPlayer {

        public static final EntityMetaSchema SCHEMA = AbstractClientPlayer.SCHEMA.extend(null) // TODO Entity Type need mappings
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Salmon">Salmon on the minecraft.wiki</a>
     */
    public static class Salmon extends AbstractSchoolingFish {

        /**
         * @view {@link SalmonTypeView}
         * @mcversions {@code 1.21.2 - 26.2}
         */
        public static final ViewField<Integer, SalmonTypeView> TYPE = ViewField.builder(SalmonTypeView::new)
            // TODO type changed from 'String' to 'Integer', converter required
            .addVersionRange(ServerVersion.V_1_21_4, ServerVersion.V_26_2, 17, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractSchoolingFish.SCHEMA.extend(EntityTypes.SALMON)
            .add(Salmon.TYPE)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     */
    public static class ServerPlayer extends Player {

        public static final EntityMetaSchema SCHEMA = Player.SCHEMA.extend(null) // TODO Entity Type need mappings
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Sheep">Sheep on the minecraft.wiki</a>
     */
    public static class Sheep extends Animal {

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Byte> DYE_COLOR = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 12, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 13, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Byte> WOOL = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 15, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 16, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 17, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 18, EntityDataTypes.BYTE)
            .build();

        public static final EntityMetaSchema SCHEMA = Animal.SCHEMA.extend(EntityTypes.SHEEP)
            .add(Sheep.DYE_COLOR)
            .add(Sheep.WOOL)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Shulker">Shulker on the minecraft.wiki</a>
     */
    public static class Shulker extends AbstractGolem {

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<BlockFace> ATTACHED_FACE = SimpleField.<BlockFace>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 11, EntityDataTypes.BLOCK_FACE)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 12, EntityDataTypes.BLOCK_FACE)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<BlockFace> ATTACH_FACE = SimpleField.<BlockFace>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 14, EntityDataTypes.BLOCK_FACE)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 15, EntityDataTypes.BLOCK_FACE)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 16, EntityDataTypes.BLOCK_FACE)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 1.16.2}
         */
        public static final SimpleField<Optional<Vector3i>> ATTACH_POS = SimpleField.<Optional<Vector3i>>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 15, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 16, EntityDataTypes.OPTIONAL_BLOCK_POSITION)
            .build();

        /**
         * @mcversions {@code 1.12.2 - 26.2}
         */
        public static final SimpleField<Byte> COLOR = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_12_2, ServerVersion.V_1_12_2, 14, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 17, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_26_2, 18, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Byte> PEEK = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 16, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_26_2, 17, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Byte> PEEK_TICK = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 12, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 13, EntityDataTypes.BYTE)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractGolem.SCHEMA.extend(EntityTypes.SHULKER)
            .add(Shulker.ATTACHED_FACE)
            .add(Shulker.ATTACH_FACE)
            .add(Shulker.ATTACH_POS)
            .add(Shulker.COLOR)
            .add(Shulker.PEEK)
            .add(Shulker.PEEK_TICK)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Shulker_Bullet">Shulker Bullet on the minecraft.wiki</a>
     */
    public static class ShulkerBullet extends Projectile {

        public static final EntityMetaSchema SCHEMA = Projectile.SCHEMA.extend(EntityTypes.SHULKER_BULLET)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Silverfish">Silverfish on the minecraft.wiki</a>
     */
    public static class Silverfish extends Monster {

        public static final EntityMetaSchema SCHEMA = Monster.SCHEMA.extend(EntityTypes.SILVERFISH)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Skeleton">Skeleton on the minecraft.wiki</a>
     */
    public static class Skeleton extends AbstractSkeleton {

        /**
         * @mcversions {@code 1.9.4 - 1.10}
         */
        public static final SimpleField<Integer> SKELETON_VARIANT = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 11, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.17 - 26.2}
         */
        public static final SimpleField<Boolean> STRAY_CONVERSION = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 16, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.10}
         */
        public static final SimpleField<Boolean> SWINGING_ARMS = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 12, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractSkeleton.SCHEMA.extend(EntityTypes.SKELETON)
            .add(Skeleton.SKELETON_VARIANT)
            .add(Skeleton.STRAY_CONVERSION)
            .add(Skeleton.SWINGING_ARMS)
            .build();

    }

    /**
     * @mcversions {@code 1.11.2 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Skeleton_Horse">Skeleton Horse on the minecraft.wiki</a>
     */
    public static class SkeletonHorse extends AbstractHorse {

        public static final EntityMetaSchema SCHEMA = AbstractHorse.SCHEMA.extend(EntityTypes.SKELETON_HORSE)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Slime">Slime on the minecraft.wiki</a>
     */
    public static class Slime extends AbstractCubeMob {

        /**
         * @mcversions {@code 1.14.4 - 26.1}
         */
        public static final SimpleField<Integer> ID_SIZE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 14, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 15, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_1, 16, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Integer> SLIME_SIZE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 11, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 12, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractCubeMob.SCHEMA.extend(EntityTypes.SLIME)
            .add(Slime.ID_SIZE)
            .add(Slime.SLIME_SIZE)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Small_Fireball">Small Fireball on the minecraft.wiki</a>
     */
    public static class SmallFireball extends Fireball {

        public static final EntityMetaSchema SCHEMA = Fireball.SCHEMA.extend(EntityTypes.SMALL_FIREBALL)
            .build();

    }

    /**
     * @mcversions {@code 1.19.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Sniffer">Sniffer on the minecraft.wiki</a>
     */
    public static class Sniffer extends Animal {

        /**
         * @mcversions {@code 1.19.4 - 26.2}
         */
        public static final SimpleField<Integer> DROP_SEED_AT_TICK = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_21_11, 18, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 19, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.19.4 - 26.2}
         */
        public static final SimpleField<SnifferState> STATE = SimpleField.<SnifferState>builder()
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_21_11, 17, EntityDataTypes.SNIFFER_STATE)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 18, EntityDataTypes.SNIFFER_STATE)
            .build();

        public static final EntityMetaSchema SCHEMA = Animal.SCHEMA.extend(EntityTypes.SNIFFER)
            .add(Sniffer.DROP_SEED_AT_TICK)
            .add(Sniffer.STATE)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Snow_Golem">Snow Golem on the minecraft.wiki</a>
     */
    public static class SnowGolem extends AbstractGolem {

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Byte> PUMPKIN = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 14, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 15, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 16, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Byte> PUMPKIN_EQUIPPED = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 11, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 12, EntityDataTypes.BYTE)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractGolem.SCHEMA.extend(EntityTypes.SNOW_GOLEM)
            .add(SnowGolem.PUMPKIN)
            .add(SnowGolem.PUMPKIN_EQUIPPED)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Snowball">Snowball on the minecraft.wiki</a>
     */
    public static class Snowball extends ThrowableItemProjectile {

        public static final EntityMetaSchema SCHEMA = ThrowableItemProjectile.SCHEMA.extend(EntityTypes.SNOWBALL)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Spectral_Arrow">Spectral Arrow on the minecraft.wiki</a>
     */
    public static class SpectralArrow extends AbstractArrow {

        public static final EntityMetaSchema SCHEMA = AbstractArrow.SCHEMA.extend(EntityTypes.SPECTRAL_ARROW)
            .build();

    }

    /**
     * @mcversions {@code 1.11.2 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Stray">Stray on the minecraft.wiki</a>
     */
    public static class Stray extends AbstractSkeleton {

        public static final EntityMetaSchema SCHEMA = AbstractSkeleton.SCHEMA.extend(EntityTypes.STRAY)
            .build();

    }

    /**
     * @mcversions {@code 1.16 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Strider">Strider on the minecraft.wiki</a>
     */
    public static class Strider extends Animal {

        /**
         * @mcversions {@code 1.16 - 26.2}
         */
        public static final SimpleField<Integer> BOOST_TIME = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_16, ServerVersion.V_1_16_2, 16, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 17, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 18, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.16 - 1.21.4}
         */
        public static final SimpleField<Boolean> SADDLE = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_16, ServerVersion.V_1_16_2, 18, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_4, 19, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.16 - 26.2}
         */
        public static final SimpleField<Boolean> SUFFOCATING = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_16, ServerVersion.V_1_16_2, 17, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 18, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 19, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = Animal.SCHEMA.extend(EntityTypes.STRIDER)
            .add(Strider.BOOST_TIME)
            .add(Strider.SADDLE)
            .add(Strider.SUFFOCATING)
            .build();

    }

    /**
     * @mcversions {@code 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Sulfur_Cube">Sulfur Cube on the minecraft.wiki</a>
     */
    public static class SulfurCube extends AbstractCubeMob {

        /**
         * @mcversions {@code 26.2}
         */
        public static final SimpleField<Boolean> FROM_BUCKET = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_26_2, ServerVersion.V_26_2, 20, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 26.2}
         */
        public static final SimpleField<Integer> MAX_FUSE = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_26_2, ServerVersion.V_26_2, 19, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractCubeMob.SCHEMA.extend(EntityTypes.SULFUR_CUBE)
            .add(SulfurCube.FROM_BUCKET)
            .add(SulfurCube.MAX_FUSE)
            .build();

    }

    /**
     * @mcversions {@code 1.19 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Tadpole">Tadpole on the minecraft.wiki</a>
     */
    public static class Tadpole extends AbstractFish {

        /**
         * @mcversions {@code 26.1 - 26.2}
         */
        public static final SimpleField<Boolean> AGE_LOCKED = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 17, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractFish.SCHEMA.extend(EntityTypes.TADPOLE)
            .add(Tadpole.AGE_LOCKED)
            .build();

    }

    /**
     * @mcversions {@code 1.19.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Text_Display">Text Display on the minecraft.wiki</a>
     */
    public static class TextDisplay extends Display {

        /**
         * @mcversions {@code 1.19.4 - 26.2}
         */
        public static final SimpleField<Integer> BACKGROUND_COLOR = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_19_4, 24, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_20_2, ServerVersion.V_26_2, 25, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.19.4 - 26.2}
         */
        public static final SimpleField<Integer> LINE_WIDTH = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_19_4, 23, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_20_2, ServerVersion.V_26_2, 24, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.19.4 - 26.2}
         */
        public static final SimpleField<Byte> STYLE_FLAGS = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_19_4, 26, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_20_2, ServerVersion.V_26_2, 27, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.19.4 - 26.2}
         */
        public static final SimpleField<Component> TEXT = SimpleField.<Component>builder()
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_19_4, 22, EntityDataTypes.ADV_COMPONENT)
            .addVersionRange(ServerVersion.V_1_20_2, ServerVersion.V_26_2, 23, EntityDataTypes.ADV_COMPONENT)
            .build();

        /**
         * @mcversions {@code 1.19.4 - 26.2}
         */
        public static final SimpleField<Byte> TEXT_OPACITY = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_19_4, ServerVersion.V_1_19_4, 25, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_20_2, ServerVersion.V_26_2, 26, EntityDataTypes.BYTE)
            .build();

        public static final EntityMetaSchema SCHEMA = Display.SCHEMA.extend(EntityTypes.TEXT_DISPLAY)
            .add(TextDisplay.BACKGROUND_COLOR)
            .add(TextDisplay.LINE_WIDTH)
            .add(TextDisplay.STYLE_FLAGS)
            .add(TextDisplay.TEXT)
            .add(TextDisplay.TEXT_OPACITY)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Thrown_Egg">Thrown Egg on the minecraft.wiki</a>
     */
    public static class ThrownEgg extends ThrowableItemProjectile {

        public static final EntityMetaSchema SCHEMA = ThrowableItemProjectile.SCHEMA.extend(EntityTypes.EGG)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class ThrownEnderpearl extends ThrowableItemProjectile {

        public static final EntityMetaSchema SCHEMA = ThrowableItemProjectile.SCHEMA.extend(EntityTypes.ENDER_PEARL)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class ThrownExperienceBottle extends ThrowableItemProjectile {

        public static final EntityMetaSchema SCHEMA = ThrowableItemProjectile.SCHEMA.extend(EntityTypes.EXPERIENCE_BOTTLE)
            .build();

    }

    /**
     * @mcversions {@code 1.21.5 - 26.2}
     */
    public static class ThrownLingeringPotion extends AbstractThrownPotion {

        public static final EntityMetaSchema SCHEMA = AbstractThrownPotion.SCHEMA.extend(EntityTypes.LINGERING_POTION)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 1.21.4}
     */
    public static class ThrownPotion extends ThrowableItemProjectile {

        /**
         * @mcversions {@code 1.14.4 - 1.15}
         */
        public static final SimpleField<ItemStack> ITEM_STACK = SimpleField.<ItemStack>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_15, 7, EntityDataTypes.ITEMSTACK)
            .build();

        public static final EntityMetaSchema SCHEMA = ThrowableItemProjectile.SCHEMA.extend(EntityTypes.POTION)
            .add(ThrownPotion.ITEM_STACK)
            .build();

    }

    /**
     * @mcversions {@code 1.21.5 - 26.2}
     */
    public static class ThrownSplashPotion extends AbstractThrownPotion {

        public static final EntityMetaSchema SCHEMA = AbstractThrownPotion.SCHEMA.extend(EntityTypes.SPLASH_POTION)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     */
    public static class ThrownTrident extends AbstractArrow {

        /**
         * @mcversions {@code 1.15 - 26.2}
         */
        public static final SimpleField<Boolean> ID_FOIL = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_15, 11, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_16, ServerVersion.V_1_16_2, 10, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21, 11, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_21_2, ServerVersion.V_26_2, 12, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Byte> ID_LOYALTY = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_15, 10, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_16, ServerVersion.V_1_16_2, 9, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21, 10, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_21_2, ServerVersion.V_26_2, 11, EntityDataTypes.BYTE)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractArrow.SCHEMA.extend(EntityTypes.TRIDENT)
            .add(ThrownTrident.ID_FOIL)
            .add(ThrownTrident.ID_LOYALTY)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Trader_Llama">Trader Llama on the minecraft.wiki</a>
     */
    public static class TraderLlama extends Llama {

        public static final EntityMetaSchema SCHEMA = Llama.SCHEMA.extend(EntityTypes.TRADER_LLAMA)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Tropical_Fish">Tropical Fish on the minecraft.wiki</a>
     */
    public static class TropicalFish extends AbstractSchoolingFish {

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Integer> TYPE_VARIANT = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 15, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 16, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 17, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractSchoolingFish.SCHEMA.extend(EntityTypes.TROPICAL_FISH)
            .add(TropicalFish.TYPE_VARIANT)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Turtle">Turtle on the minecraft.wiki</a>
     */
    public static class Turtle extends Animal {

        /**
         * @mcversions {@code 1.14.4 - 1.21.4}
         */
        public static final SimpleField<Boolean> GOING_HOME = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 19, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 20, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_4, 21, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Boolean> HAS_EGG = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 16, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 17, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_4, 18, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_21_5, ServerVersion.V_1_21_11, 17, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 18, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 1.21.4}
         */
        public static final SimpleField<Vector3i> HOME_POS = SimpleField.<Vector3i>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 15, EntityDataTypes.BLOCK_POSITION)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 16, EntityDataTypes.BLOCK_POSITION)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_4, 17, EntityDataTypes.BLOCK_POSITION)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Boolean> LAYING_EGG = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 17, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 18, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_4, 19, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_21_5, ServerVersion.V_1_21_11, 18, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 19, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 1.21.4}
         */
        public static final SimpleField<Boolean> TRAVELLING = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 20, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 21, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_4, 22, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 1.21.4}
         */
        public static final SimpleField<Vector3i> TRAVEL_POS = SimpleField.<Vector3i>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 18, EntityDataTypes.BLOCK_POSITION)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 19, EntityDataTypes.BLOCK_POSITION)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_4, 20, EntityDataTypes.BLOCK_POSITION)
            .build();

        public static final EntityMetaSchema SCHEMA = Animal.SCHEMA.extend(EntityTypes.TURTLE)
            .add(Turtle.GOING_HOME)
            .add(Turtle.HAS_EGG)
            .add(Turtle.HOME_POS)
            .add(Turtle.LAYING_EGG)
            .add(Turtle.TRAVELLING)
            .add(Turtle.TRAVEL_POS)
            .build();

    }

    /**
     * @mcversions {@code 1.11.2 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Vex">Vex on the minecraft.wiki</a>
     */
    public static class Vex extends Monster {

        /**
         * @view {@link VexFlagsView}
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final ViewField<Byte, VexFlagsView> FLAGS = ViewField.builder(VexFlagsView::new)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 14, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 15, EntityDataTypes.BYTE)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 16, EntityDataTypes.BYTE)
            .build();

        /**
         * @mcversions {@code 1.12.2}
         */
        public static final SimpleField<Byte> VEX_FLAGS = SimpleField.<Byte>builder()
            .addVersionRange(ServerVersion.V_1_12_2, ServerVersion.V_1_12_2, 12, EntityDataTypes.BYTE)
            .build();

        public static final EntityMetaSchema SCHEMA = Monster.SCHEMA.extend(EntityTypes.VEX)
            .add(Vex.FLAGS)
            .add(Vex.VEX_FLAGS)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Villager">Villager on the minecraft.wiki</a>
     */
    public static class Villager extends AbstractVillager {

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Integer> PROFESSION = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 12, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 13, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<VillagerData> VILLAGER_DATA = SimpleField.<VillagerData>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 16, EntityDataTypes.VILLAGER_DATA)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 17, EntityDataTypes.VILLAGER_DATA)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 18, EntityDataTypes.VILLAGER_DATA)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 19, EntityDataTypes.VILLAGER_DATA)
            .build();

        /**
         * @mcversions {@code 26.1 - 26.2}
         */
        public static final SimpleField<Boolean> VILLAGER_FINALIZED = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 20, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractVillager.SCHEMA.extend(EntityTypes.VILLAGER)
            .add(Villager.PROFESSION)
            .add(Villager.VILLAGER_DATA)
            .add(Villager.VILLAGER_FINALIZED)
            .build();

    }

    /**
     * @mcversions {@code 1.11.2 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Vindicator">Vindicator on the minecraft.wiki</a>
     */
    public static class Vindicator extends AbstractIllager {

        public static final EntityMetaSchema SCHEMA = AbstractIllager.SCHEMA.extend(EntityTypes.VINDICATOR)
            .build();

    }

    /**
     * @mcversions {@code 1.14.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Wandering_Trader">Wandering Trader on the minecraft.wiki</a>
     */
    public static class WanderingTrader extends AbstractVillager {

        public static final EntityMetaSchema SCHEMA = AbstractVillager.SCHEMA.extend(EntityTypes.WANDERING_TRADER)
            .build();

    }

    /**
     * @mcversions {@code 1.19 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Warden">Warden on the minecraft.wiki</a>
     */
    public static class Warden extends Monster {

        /**
         * @mcversions {@code 1.19 - 26.2}
         */
        public static final SimpleField<Integer> CLIENT_ANGER_LEVEL = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_19, ServerVersion.V_26_2, 16, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = Monster.SCHEMA.extend(EntityTypes.WARDEN)
            .add(Warden.CLIENT_ANGER_LEVEL)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 1.12.2}
     */
    public static class WeatherEffect extends Entity {

        public static final EntityMetaSchema SCHEMA = Entity.SCHEMA.extend(null) // TODO Entity Type need mappings
            .build();

    }

    /**
     * @mcversions {@code 1.20.3 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Wind_Charge">Wind Charge on the minecraft.wiki</a>
     */
    public static class WindCharge extends AbstractWindCharge {

        public static final EntityMetaSchema SCHEMA = AbstractWindCharge.SCHEMA.extend(EntityTypes.WIND_CHARGE)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Witch">Witch on the minecraft.wiki</a>
     */
    public static class Witch extends Raider {

        /**
         * @mcversions {@code 1.9.4 - 1.12}
         */
        public static final SimpleField<Boolean> IS_AGGRESSIVE = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 11, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12, 12, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.12.2}
         */
        public static final SimpleField<Boolean> IS_DRINKING = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_12_2, ServerVersion.V_1_12_2, 12, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Boolean> USING_ITEM = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 15, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 16, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 17, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = Raider.SCHEMA.extend(EntityTypes.WITCH)
            .add(Witch.IS_AGGRESSIVE)
            .add(Witch.IS_DRINKING)
            .add(Witch.USING_ITEM)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     */
    public static class WitherBoss extends Monster {

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Integer> FIRST_HEAD_TARGET = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 11, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 12, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Integer> INV = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 17, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 18, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 19, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Integer> INVULNERABILITY_TIME = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 14, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 15, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Integer> SECOND_HEAD_TARGET = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 12, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 13, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Integer> TARGET_A = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 14, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 15, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 16, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Integer> TARGET_B = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 15, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 16, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 17, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Integer> TARGET_C = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 16, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 17, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 18, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Integer> THIRD_HEAD_TARGET = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 13, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 14, EntityDataTypes.INT)
            .build();

        public static final EntityMetaSchema SCHEMA = Monster.SCHEMA.extend(EntityTypes.WITHER)
            .add(WitherBoss.FIRST_HEAD_TARGET)
            .add(WitherBoss.INV)
            .add(WitherBoss.INVULNERABILITY_TIME)
            .add(WitherBoss.SECOND_HEAD_TARGET)
            .add(WitherBoss.TARGET_A)
            .add(WitherBoss.TARGET_B)
            .add(WitherBoss.TARGET_C)
            .add(WitherBoss.THIRD_HEAD_TARGET)
            .build();

    }

    /**
     * @mcversions {@code 1.11.2 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Wither_Skeleton">Wither Skeleton on the minecraft.wiki</a>
     */
    public static class WitherSkeleton extends AbstractSkeleton {

        public static final EntityMetaSchema SCHEMA = AbstractSkeleton.SCHEMA.extend(EntityTypes.WITHER_SKELETON)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Wither_Skull">Wither Skull on the minecraft.wiki</a>
     */
    public static class WitherSkull extends AbstractHurtingProjectile {

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Boolean> DANGEROUS = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 7, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 8, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Boolean> INVULNERABLE = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 5, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 6, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractHurtingProjectile.SCHEMA.extend(EntityTypes.WITHER_SKULL)
            .add(WitherSkull.DANGEROUS)
            .add(WitherSkull.INVULNERABLE)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Wolf">Wolf on the minecraft.wiki</a>
     */
    public static class Wolf extends TamableAnimal {

        /**
         * @mcversions {@code 1.21.11 - 26.2}
         */
        public static final SimpleField<Long> ANGER_END_TIME = SimpleField.<Long>builder()
            .addVersionRange(ServerVersion.V_1_21_11, ServerVersion.V_1_21_11, 21, EntityDataTypes.LONG)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 22, EntityDataTypes.LONG)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.12.2}
         */
        public static final SimpleField<Boolean> BEGGING = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 14, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 15, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 26.2}
         */
        public static final SimpleField<Integer> COLLAR_COLOR = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 15, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 16, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 19, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 20, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 21, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.9.4 - 1.14.4}
         */
        public static final SimpleField<Float> HEALTH = SimpleField.<Float>builder()
            .addVersionRange(ServerVersion.V_1_9_4, ServerVersion.V_1_10, 13, EntityDataTypes.FLOAT)
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 14, EntityDataTypes.FLOAT)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 17, EntityDataTypes.FLOAT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<Boolean> INTERESTED = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_16_2, 18, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_11, 19, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 20, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.16 - 1.21.9}
         */
        public static final SimpleField<Integer> REMAINING_ANGER_TIME = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_16, ServerVersion.V_1_16_2, 20, EntityDataTypes.INT)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_1_21_9, 21, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.21.5 - 26.2}
         */
        public static final SimpleField<WolfSoundVariant> SOUND_VARIANT = SimpleField.<WolfSoundVariant>builder()
            .addVersionRange(ServerVersion.V_1_21_5, ServerVersion.V_1_21_11, 23, EntityDataTypes.WOLF_SOUND_VARIANT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 24, EntityDataTypes.WOLF_SOUND_VARIANT)
            .build();

        /**
         * @mcversions {@code 1.20.5 - 26.2}
         */
        public static final SimpleField<WolfVariant> VARIANT = SimpleField.<WolfVariant>builder()
            .addVersionRange(ServerVersion.V_1_20_5, ServerVersion.V_1_21_11, 22, EntityDataTypes.TYPED_WOLF_VARIANT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 23, EntityDataTypes.TYPED_WOLF_VARIANT)
            .build();

        public static final EntityMetaSchema SCHEMA = TamableAnimal.SCHEMA.extend(EntityTypes.WOLF)
            .add(Wolf.ANGER_END_TIME)
            .add(Wolf.BEGGING)
            .add(Wolf.COLLAR_COLOR)
            .add(Wolf.HEALTH)
            .add(Wolf.INTERESTED)
            .add(Wolf.REMAINING_ANGER_TIME)
            .add(Wolf.SOUND_VARIANT)
            .add(Wolf.VARIANT)
            .build();

    }

    /**
     * @mcversions {@code 1.16 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Zoglin">Zoglin on the minecraft.wiki</a>
     */
    public static class Zoglin extends Monster {

        /**
         * @mcversions {@code 1.16 - 26.2}
         */
        public static final SimpleField<Boolean> BABY = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_16, ServerVersion.V_1_16_2, 15, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 16, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = Monster.SCHEMA.extend(EntityTypes.ZOGLIN)
            .add(Zoglin.BABY)
            .build();

    }

    /**
     * @mcversions {@code 1.11.2 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Zombie_Horse">Zombie Horse on the minecraft.wiki</a>
     */
    public static class ZombieHorse extends AbstractHorse {

        public static final EntityMetaSchema SCHEMA = AbstractHorse.SCHEMA.extend(EntityTypes.ZOMBIE_HORSE)
            .build();

    }

    /**
     * @mcversions {@code 1.21.11 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Zombie_Nautilus">Zombie Nautilus on the minecraft.wiki</a>
     */
    public static class ZombieNautilus extends AbstractNautilus {

        /**
         * @mcversions {@code 1.21.11 - 26.2}
         */
        public static final SimpleField<ZombieNautilusVariant> VARIANT = SimpleField.<ZombieNautilusVariant>builder()
            .addVersionRange(ServerVersion.V_1_21_11, ServerVersion.V_1_21_11, 20, EntityDataTypes.ZOMBIE_NAUTILUS_VARIANT)
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 21, EntityDataTypes.ZOMBIE_NAUTILUS_VARIANT)
            .build();

        public static final EntityMetaSchema SCHEMA = AbstractNautilus.SCHEMA.extend(EntityTypes.ZOMBIE_NAUTILUS)
            .add(ZombieNautilus.VARIANT)
            .build();

    }

    /**
     * @mcversions {@code 1.11.2 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Zombie_Villager">Zombie Villager on the minecraft.wiki</a>
     */
    public static class ZombieVillager extends Zombie {

        /**
         * @mcversions {@code 1.11.2 - 26.2}
         */
        public static final SimpleField<Boolean> CONVERTING = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_1_11_2, ServerVersion.V_1_12_2, 15, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 17, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 18, EntityDataTypes.BOOLEAN)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 19, EntityDataTypes.BOOLEAN)
            .build();

        /**
         * @mcversions {@code 1.12.2}
         */
        public static final SimpleField<Integer> PROFESSION = SimpleField.<Integer>builder()
            .addVersionRange(ServerVersion.V_1_12_2, ServerVersion.V_1_12_2, 16, EntityDataTypes.INT)
            .build();

        /**
         * @mcversions {@code 1.14.4 - 26.2}
         */
        public static final SimpleField<VillagerData> VILLAGER_DATA = SimpleField.<VillagerData>builder()
            .addVersionRange(ServerVersion.V_1_14_4, ServerVersion.V_1_14_4, 18, EntityDataTypes.VILLAGER_DATA)
            .addVersionRange(ServerVersion.V_1_15, ServerVersion.V_1_16_2, 19, EntityDataTypes.VILLAGER_DATA)
            .addVersionRange(ServerVersion.V_1_17, ServerVersion.V_26_2, 20, EntityDataTypes.VILLAGER_DATA)
            .build();

        /**
         * @mcversions {@code 26.1 - 26.2}
         */
        public static final SimpleField<Boolean> VILLAGER_FINALIZED = SimpleField.<Boolean>builder()
            .addVersionRange(ServerVersion.V_26_1, ServerVersion.V_26_2, 21, EntityDataTypes.BOOLEAN)
            .build();

        public static final EntityMetaSchema SCHEMA = Zombie.SCHEMA.extend(EntityTypes.ZOMBIE_VILLAGER)
            .add(ZombieVillager.CONVERTING)
            .add(ZombieVillager.PROFESSION)
            .add(ZombieVillager.VILLAGER_DATA)
            .add(ZombieVillager.VILLAGER_FINALIZED)
            .build();

    }

    /**
     * @mcversions {@code 1.9.4 - 26.2}
     * @mcwiki <a href="https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Zombified_Piglin">Zombified Piglin on the minecraft.wiki</a>
     */
    public static class ZombifiedPiglin extends Zombie {

        public static final EntityMetaSchema SCHEMA = Zombie.SCHEMA.extend(EntityTypes.ZOMBIFIED_PIGLIN)
            .build();

    }

}
