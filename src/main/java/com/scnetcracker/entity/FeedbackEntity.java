package com.scnetcracker.entity;

import javax.persistence.*;

@Entity
@Table(name = "feedback", schema = "prom", catalog = "")
public class FeedbackEntity {
    private int id;
    private int entityId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "entityID")
    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeedbackEntity that = (FeedbackEntity) o;

        if (id != that.id) return false;
        if (entityId != that.entityId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + entityId;
        return result;
    }
}
