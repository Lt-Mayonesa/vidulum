package ar.com.joaquincampero.apps.vidulum.di.module;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import ar.com.joaquincampero.apps.vidulum.database.UserRoomDatabase;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Joaquin Campero
 * on 12/8/18.
 */
@Module
public class DatabaseModule {

    @Singleton
    @Provides
    UserRoomDatabase providesUserRoomDatabase(Context context) {
        return Room.databaseBuilder(
                context.getApplicationContext(),
                UserRoomDatabase.class,
                "app_database")
                .build();
    }

}
