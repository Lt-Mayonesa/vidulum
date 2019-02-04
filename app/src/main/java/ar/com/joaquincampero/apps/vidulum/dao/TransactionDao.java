package ar.com.joaquincampero.apps.vidulum.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import ar.com.joaquincampero.apps.vidulum.model.Transaction;
import ar.com.joaquincampero.apps.vidulum.model.User;

/**
 * Created by Joaquin Campero
 * on 12/8/18.
 */
@Dao
public interface TransactionDao extends BaseDao<Transaction> {

    @Insert
    void insert(Transaction transaction);

    @Query("DELETE FROM `transaction`")
    void deleteAll();

    @Query("SELECT * FROM `transaction` ORDER BY date DESC")
    LiveData<List<Transaction>> getAll();

}
