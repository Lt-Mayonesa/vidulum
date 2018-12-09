package ar.com.joaquincampero.apps.vidulum;


import ar.com.joaquincampero.apps.vidulum.di.component.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by Joaquin Campero
 * on 11/26/18.
 */
public class App extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }
}
