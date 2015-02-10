package com.example.domain;

import java.io.Serializable;

public interface ValueObject extends Serializable {

    public boolean equals(Object that);

    public int hashCode();
}
