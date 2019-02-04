package ar.com.joaquincampero.apps.vidulum.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Joaquin Campero
 * on 12/8/18.
 */
@Entity
public class User {

    @PrimaryKey
    @NonNull
    private String id;
    private String displayName;

    public User(@NonNull String id, @NonNull String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
