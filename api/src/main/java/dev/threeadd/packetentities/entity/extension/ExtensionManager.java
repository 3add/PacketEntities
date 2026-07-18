package dev.threeadd.packetentities.entity.extension;

import dev.threeadd.packetentities.entity.ProtocolEntity;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@ApiStatus.Internal
public final class ExtensionManager {

    private final Map<Class<? extends EntityExtension>, EntityExtension> extensions;

    ExtensionManager(ExtensionManagerBuilder builder) {
        this.extensions = new LinkedHashMap<>(builder.extensions);
    }

    /**
     * @return A new extension builder instance.
     */
    public static ExtensionManagerBuilder builder() {
        return new ExtensionManagerBuilder();
    }

    public <E extends EntityExtension> @Nullable E getExtension(Class<E> clazz) {
        synchronized (this.extensions) {
            EntityExtension ext = this.extensions.get(clazz);
            return ext != null ? clazz.cast(ext) : null;
        }
    }

    public <E extends EntityExtension> void editExtension(Class<E> clazz, Consumer<E> editor) {
        synchronized (this.extensions) {
            E extension = getExtension(clazz);
            if (extension != null) {
                editor.accept(extension);
            }
        }
    }

    public boolean hasExtension(Class<? extends EntityExtension> clazz) {
        synchronized (this.extensions) {
            return this.extensions.containsKey(clazz);
        }
    }

    public @UnmodifiableView Collection<EntityExtension> getAllExtensions() {
        synchronized (this.extensions) {
            return List.copyOf(this.extensions.values());
        }
    }

    @UnmodifiableView
    public Collection<Class<? extends EntityExtension>> getExtensionClasses() {
        synchronized (this.extensions) {
            return List.copyOf(this.extensions.keySet());
        }
    }

    public void attachAll(ProtocolEntity entity) {
        Collection<EntityExtension> snapshot;
        synchronized (this.extensions) {
            snapshot = List.copyOf(this.extensions.values());
        }

        for (EntityExtension extension : snapshot) {
            extension.onAttach(entity);
        }
    }

    public void detachAll(ProtocolEntity entity) {
        Collection<EntityExtension> snapshot;
        synchronized (this.extensions) {
            snapshot = List.copyOf(this.extensions.values());
        }

        for (EntityExtension extension : snapshot) {
            extension.onDetach(entity);
        }
    }

    public void destroy() {
        synchronized (this.extensions) {
            this.extensions.clear();
        }
    }

}
