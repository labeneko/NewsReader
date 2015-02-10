package com.example.domain;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;

public abstract class AbstractEntity<I extends Identity<?>, E extends Entity<I, E>> implements Entity<I, E> {

    private I identity;

    public AbstractEntity(final I identity) {
        this.identity = identity;
    }

    @Override
    public I getIdentity() {
        return identity;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(final Object obj) {
        if(obj == null || !(obj instanceof Entity)) {
            return false;
        }
        return obj == this || new EqualsBuilder().append(identity, ((Entity) obj).getIdentity()).build();
    }

    @Override
    public int hashCode() {
        return identity.hashCode();
    }

    @Override
    @SuppressWarnings("unchecked")
    public E clone() {
        return SerializationUtils.clone((E) this);
    }
}
