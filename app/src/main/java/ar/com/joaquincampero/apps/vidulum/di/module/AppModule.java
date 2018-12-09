package ar.com.joaquincampero.apps.vidulum.di.module;

import android.content.Context;

import javax.inject.Singleton;

import ar.com.joaquincampero.apps.vidulum.App;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Joaquin Campero
 * on 11/26/18.
 */
@Module
public class AppModule {

    @Singleton
    @Provides
    Context providesContext(App app) {
        return app.getApplicationContext();
    }
}
