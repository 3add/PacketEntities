package dev.threeadd.packetentities.codegen.data.mapping;

import com.palantir.javapoet.ClassName;
import java.util.HashMap;
import java.util.Map;

/**
 * Used in {@link DataTypeMapper} to identify specific fields in specific entity metadata types,
 * then to apply a custom view
 */
public record FieldTarget(String owningMetaClass, String fieldName) {

    public static FieldTarget of(String owningMetaClass, String fieldName) {
        return new FieldTarget(owningMetaClass, fieldName);
    }

    public static RegistryBuilder registry() {
        return new RegistryBuilder();
    }

    public static class RegistryBuilder {
        private final Map<FieldTarget, ClassName> registryMap = new HashMap<>();
        private String activePackage = "";

        public RegistryBuilder inPackage(String packageName) {
            this.activePackage = packageName;
            return this;
        }

        public RegistryBuilder add(String metaClass, String fieldName, String viewSimpleName) {
            if (this.activePackage == null || this.activePackage.isBlank()) {
                throw new IllegalStateException("No active package context set. Call .inPackage() first or use the explicit package add() method.");
            }
            return add(metaClass, fieldName, this.activePackage, viewSimpleName);
        }

        public RegistryBuilder add(String metaClass, String fieldName, String packageName, String viewSimpleName) {
            FieldTarget target = new FieldTarget(metaClass, fieldName);
            ClassName viewClass = ClassName.get(packageName, viewSimpleName);
            this.registryMap.put(target, viewClass);
            return this;
        }

        public Map<FieldTarget, ClassName> build() {
            return Map.copyOf(this.registryMap);
        }
    }

}
