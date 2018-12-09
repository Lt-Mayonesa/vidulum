package ar.com.joaquincampero.apps.vidulum.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import ar.com.joaquincampero.apps.vidulum.model.User;

/**
 * Created by Joaquin Campero
 * on 12/8/18.
 */
@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Query("DELETE FROM user")
    void deleteAll();

    @Query("SELECT * from user")
    LiveData<List<User>> getAllUsers();

}
