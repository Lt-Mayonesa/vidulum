package ar.com.joaquincampero.apps.vidulum.di.module;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Singleton;

import ar.com.joaquincampero.apps.vidulum.dao.TransactionDao;
import ar.com.joaquincampero.apps.vidulum.database.AppDatabase;
import ar.com.joaquincampero.apps.vidulum.model.Transaction;
import dagger.Module;
import dagger.Provides;

import static ar.com.joaquincampero.apps.vidulum.database.AppDatabase.DATABASE_NAME;

/**
 * Created by Joaquin Campero
 * on 12/8/18.
 */
@Module
public class DatabaseModule {

    @Singleton
    @Provides
    AppDatabase providesAppRoomDatabase(Context context) {
        return Room.databaseBuilder(
                context.getApplicationContext(),
                AppDatabase.class,
                DATABASE_NAME)
                .build();
    }

}
