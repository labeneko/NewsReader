package com.example.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public abstract class AbstractIdentity<V> extends AbstractValueObject implements Identity<V> {

    private V value;

    public AbstractIdentity(final V value) {
        this.value = value;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(final Object obj) {
        if(!(obj instanceof Identity)) {
            return false;
        }
        return obj == this || new EqualsBuilder().append(value, ((Identity) obj).getValue()).build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(value).build();
    }

    public String toString() {
        return new ToStringBuilder(this).append(value).build();
    }
}
