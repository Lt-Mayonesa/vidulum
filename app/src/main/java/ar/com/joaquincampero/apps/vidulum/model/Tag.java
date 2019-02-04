package ar.com.joaquincampero.apps.vidulum.model;

import android.arch.persistence.room.Entity;

/**
 * Created by Joaquin Campero
 * on 2/3/19.
 */
@Entity
class Tag {

    private String text;

    Tag(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
