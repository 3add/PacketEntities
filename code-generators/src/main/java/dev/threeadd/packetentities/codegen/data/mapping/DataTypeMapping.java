package dev.threeadd.packetentities.codegen.data.mapping;

import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.ParameterizedTypeName;
import com.palantir.javapoet.TypeName;
import java.util.Arrays;
import java.util.Optional;

public record DataTypeMapping(TypeName typeName, String packetEventsDataType, boolean isExcluded) {

    public DataTypeMapping(TypeName typeName, String dataType) {
        this(typeName, dataType, false);
    }

    public static DataTypeMapping of(Class<?> clazz, String dataType) {
        return new DataTypeMapping(ClassName.get(clazz), dataType);
    }

    public static DataTypeMapping of(TypeName typeName, String dataType) {
        return new DataTypeMapping(typeName, dataType);
    }

    public static DataTypeMapping optionalOf(Class<?> clazz, String dataType) {
        return new DataTypeMapping(ParameterizedTypeName.get(Optional.class, clazz), dataType);
    }

    public static DataTypeMapping optionalOf(TypeName typeName, String dataType) {
        return new DataTypeMapping(ParameterizedTypeName.get(ClassName.get(Optional.class), typeName), dataType);
    }

    public static DataTypeMapping excluded() {
        return new DataTypeMapping(ClassName.get(Object.class), null, true);
    }

    public static Builder builder(Class<?> baseClass) {
        return new Builder(ClassName.get(baseClass));
    }

    // only used for Particle<?> currently but hey why not add it
    public static class Builder {
        private TypeName typeName;
        private String packetEventsDataType;
        private boolean isExcluded = false;

        private Builder(TypeName typeName) {
            this.typeName = typeName;
        }

        public Builder parameterizedWith(Class<?>... typeArgs) {
            TypeName[] typeNames = Arrays.stream(typeArgs).map(ClassName::get).toArray(TypeName[]::new);
            return parameterizedWith(typeNames);
        }

        public Builder parameterizedWith(TypeName... typeArgs) {
            if (this.typeName instanceof ClassName className) {
                this.typeName = ParameterizedTypeName.get(className, typeArgs);
                return this;
            }
            throw new IllegalStateException("Cannot parameterize a type that isn't a base ClassName");
        }

        public Builder peDataType(String packetEventsDataType) {
            this.packetEventsDataType = packetEventsDataType;
            return this;
        }

        public Builder exclude() {
            this.isExcluded = true;
            return this;
        }

        public DataTypeMapping build() {
            return new DataTypeMapping(this.typeName, this.packetEventsDataType, this.isExcluded);
        }
    }

}
