package dev.threeadd.packetentities.entity.extension;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public class ExtensionManagerBuilder {

    final Map<Class<? extends EntityExtension>, EntityExtension> extensions = new LinkedHashMap<>();

    ExtensionManagerBuilder() {
    }

    /**
     * @param extension An extension to add to this manager
     * @return this builder for chaining
     * @throws NullPointerException if the provided {@code extension} is null
     */
    public ExtensionManagerBuilder extension(EntityExtension extension) {
        return extension(extension, null);
    }

    /**
     * @param extension An extension to add to the extension manager
     * @param config    A config consumer to accept with the provided extension
     * @param <E>       The extension type
     * @return this builder for chaining
     * @throws NullPointerException if the provided {@code extension} is null
     */
    public <E extends EntityExtension> ExtensionManagerBuilder extension(E extension, @Nullable Consumer<E> config) {
        Objects.requireNonNull(extension, "EntityExtension cannot be null");
        if (config != null) {
            config.accept(extension);
        }

        this.extensions.put(extension.getClass(), extension);
        return this;
    }

    public <E extends EntityExtension> @Nullable E getExtension(Class<E> type) {
        EntityExtension ext = this.extensions.get(type);
        return ext != null ? type.cast(ext) : null;
    }

    @ApiStatus.Internal
    public ExtensionManager build() {
        return new ExtensionManager(this);
    }

}
