package com.example.domain;

import java.io.Serializable;

public interface Entity<I extends Identity<?>, E extends Entity<I, E>> extends Cloneable, Serializable {

    public I getIdentity();

    public boolean equals(Object that);

    public int hashCode();

    public E clone();
}
