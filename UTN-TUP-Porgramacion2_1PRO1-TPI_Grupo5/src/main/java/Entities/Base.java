package Entities;

import java.time.LocalDateTime;

public abstract class Base {

    protected Long id;

    protected boolean eliminado;

    protected LocalDateTime createdAt;

    public Base(Long id, boolean eliminado, LocalDateTime createdAt) {
        this.id = id;
        this.eliminado = eliminado;
        this.createdAt = createdAt;
    }
}
