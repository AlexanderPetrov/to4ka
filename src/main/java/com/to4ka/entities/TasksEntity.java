package com.to4ka.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by User on 2/8/2018.
 */
@Entity
@Table(name = "tasks", schema = "to4ka", catalog = "")
public class TasksEntity {
    private int id;
    private String description;
    private Timestamp dueDate;
    private int notifBeforeMinutes;
    private byte finished;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "DUE_DATE")
    public Timestamp getDueDate() {
        return dueDate;
    }

    public void setDueDate(Timestamp dueDate) {
        this.dueDate = dueDate;
    }

    @Basic
    @Column(name = "NOTIF_BEFORE_MINUTES")
    public int getNotifBeforeMinutes() {
        return notifBeforeMinutes;
    }

    public void setNotifBeforeMinutes(int notifBeforeMinutes) {
        this.notifBeforeMinutes = notifBeforeMinutes;
    }

    @Basic
    @Column(name = "FINISHED")
    public byte getFinished() {
        return finished;
    }

    public void setFinished(byte finished) {
        this.finished = finished;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TasksEntity that = (TasksEntity) o;

        if (id != that.id) return false;
        if (notifBeforeMinutes != that.notifBeforeMinutes) return false;
        if (finished != that.finished) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (dueDate != null ? !dueDate.equals(that.dueDate) : that.dueDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
        result = 31 * result + notifBeforeMinutes;
        result = 31 * result + (int) finished;
        return result;
    }
}
