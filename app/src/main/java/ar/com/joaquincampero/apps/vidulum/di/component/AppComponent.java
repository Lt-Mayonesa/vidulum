package ar.com.joaquincampero.apps.vidulum.di.component;

import javax.inject.Singleton;

import ar.com.joaquincampero.apps.vidulum.App;
import ar.com.joaquincampero.apps.vidulum.di.module.AppModule;
import ar.com.joaquincampero.apps.vidulum.di.module.DatabaseModule;
import ar.com.joaquincampero.apps.vidulum.di.module.DestinationModule;
import ar.com.joaquincampero.apps.vidulum.di.module.FirebaseModule;
import ar.com.joaquincampero.apps.vidulum.di.module.TransactionModule;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Joaquin Campero
 * on 11/26/18.
 */
@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                AppModule.class,
                DestinationModule.class,
                FirebaseModule.class,
                DatabaseModule.class,
                TransactionModule.class
        })
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {
    }

}
