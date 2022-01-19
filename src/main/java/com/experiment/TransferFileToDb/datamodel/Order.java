package com.experiment.TransferFileToDb.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_table")
public class Order {
    @Id
   private long id;
    @Column(name = "user_id")
    private  long userId;
    private double total;
    private LocalDateTime created;

    public Order() {
    }

    public Order(long id, long userId, double total, LocalDateTime created) {
        this.id = id;
        this.userId = userId;
        this.total = total;
        this.created = created;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", total=" + total +
                ", created=" + created +
                '}';
    }
}
