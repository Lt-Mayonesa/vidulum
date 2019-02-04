package ar.com.joaquincampero.apps.vidulum.ui.factory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

import ar.com.joaquincampero.apps.vidulum.repository.TransactionRepository;
import ar.com.joaquincampero.apps.vidulum.ui.transaction.TransactionViewModel;

/**
 * Created by Joaquin Campero
 * on 2/4/19.
 */
@Singleton
public class TransactionVMFactory extends ViewModelProvider.NewInstanceFactory {

    private TransactionRepository mRepository;

    @Inject
    public TransactionVMFactory(TransactionRepository mRepository) {
        this.mRepository = mRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new TransactionViewModel(mRepository);
    }
}
