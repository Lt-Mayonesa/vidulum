package ar.com.joaquincampero.apps.vidulum.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import ar.com.joaquincampero.apps.vidulum.dao.UserDao;
import ar.com.joaquincampero.apps.vidulum.model.User;

/**
 * Created by Joaquin Campero
 * on 12/8/18.
 */
@Database(entities = {User.class}, version = 1)
public abstract class UserRoomDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
