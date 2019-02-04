package ar.com.joaquincampero.apps.vidulum.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import ar.com.joaquincampero.apps.vidulum.dao.TransactionDao;
import ar.com.joaquincampero.apps.vidulum.database.converter.DateConverter;
import ar.com.joaquincampero.apps.vidulum.model.Transaction;

/**
 * Created by Joaquin Campero
 * on 12/8/18.
 */
@Database(entities = {Transaction.class}, version = 2)
@TypeConverters({DateConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "app_database";

    public abstract TransactionDao transactionDao();
}
