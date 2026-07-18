package dev.threeadd.packetentities.codegen.data.mapping;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

public final class EntityTypesIndex {

    private static final Set<String> CONSTANT_NAMES = loadConstantNames();

    private EntityTypesIndex() {
    }

    private static Set<String> loadConstantNames() {
        Set<String> names = new HashSet<>();
        for (Field field : EntityTypes.class.getFields()) {
            if (Modifier.isStatic(field.getModifiers())
                    && Modifier.isPublic(field.getModifiers())
                    && EntityType.class.isAssignableFrom(field.getType())) {
                names.add(field.getName());
            }
        }
        return Set.copyOf(names);
    }

    public static boolean exists(String constantName) {
        return CONSTANT_NAMES.contains(constantName);
    }

}
