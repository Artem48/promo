package com.scnetcracker.entity;

import javax.persistence.*;

@Entity
@Table(name = "operation_types", schema = "promo", catalog = "")
public class OperationTypesEntity {
    private int id;
    private String operationType;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "operationType")
    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperationTypesEntity that = (OperationTypesEntity) o;

        if (id != that.id) return false;
        if (operationType != null ? !operationType.equals(that.operationType) : that.operationType != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (operationType != null ? operationType.hashCode() : 0);
        return result;
    }
}
