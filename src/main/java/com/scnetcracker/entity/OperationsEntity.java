package com.scnetcracker.entity;

import javax.persistence.*;

@Entity
@Table(name = "operations", schema = "promo", catalog = "")
public class OperationsEntity {
    private int id;
    private int operationTypeId;
    private int entityId;
    private int ownerId;
    private Integer commentId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "operationTypeID")
    public int getOperationTypeId() {
        return operationTypeId;
    }

    public void setOperationTypeId(int operationTypeId) {
        this.operationTypeId = operationTypeId;
    }

    @Basic
    @Column(name = "entityID")
    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    @Basic
    @Column(name = "ownerID")
    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Basic
    @Column(name = "commentID")
    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperationsEntity that = (OperationsEntity) o;

        if (id != that.id) return false;
        if (operationTypeId != that.operationTypeId) return false;
        if (entityId != that.entityId) return false;
        if (ownerId != that.ownerId) return false;
        if (commentId != null ? !commentId.equals(that.commentId) : that.commentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + operationTypeId;
        result = 31 * result + entityId;
        result = 31 * result + ownerId;
        result = 31 * result + (commentId != null ? commentId.hashCode() : 0);
        return result;
    }
}
