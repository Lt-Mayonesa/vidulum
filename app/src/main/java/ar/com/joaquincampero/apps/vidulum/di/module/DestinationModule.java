package ar.com.joaquincampero.apps.vidulum.di.module;

import ar.com.joaquincampero.apps.vidulum.ui.main.MainActivity;
import ar.com.joaquincampero.apps.vidulum.ui.main.MainFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Joaquin Campero
 * on 11/26/18.
 */
@Module
public abstract class DestinationModule {

    @ContributesAndroidInjector
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector
    abstract MainFragment mainFragment();

}
