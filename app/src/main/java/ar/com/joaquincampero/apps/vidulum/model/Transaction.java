package ar.com.joaquincampero.apps.vidulum.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by Joaquin Campero
 * on 2/3/19.
 */
@Entity
public class Transaction {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String user;
    private Date date;
    private Double amount;
    private String description;
//    private List<Tag> tags;

    public Transaction(String user, Date date, Double amount, String description) {
        this.user = user;
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
