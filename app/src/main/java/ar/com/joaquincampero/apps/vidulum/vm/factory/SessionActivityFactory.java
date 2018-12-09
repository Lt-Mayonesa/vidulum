package ar.com.joaquincampero.apps.vidulum.vm.factory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Inject;
import javax.inject.Singleton;

import ar.com.joaquincampero.apps.vidulum.ui.main.SessionViewModel;

/**
 * Created by Joaquin Campero
 * on 12/7/18.
 */
@Singleton
public class SessionActivityFactory extends ViewModelProvider.NewInstanceFactory {

    private FirebaseAuth firebaseAuth;

    @Inject
    public SessionActivityFactory(FirebaseAuth firebaseAuth) {
        this.firebaseAuth = firebaseAuth;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new SessionViewModel(firebaseAuth);
    }
}
