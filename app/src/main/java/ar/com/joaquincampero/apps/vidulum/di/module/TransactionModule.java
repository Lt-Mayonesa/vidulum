package ar.com.joaquincampero.apps.vidulum.di.module;

import javax.inject.Singleton;

import ar.com.joaquincampero.apps.vidulum.dao.TransactionDao;
import ar.com.joaquincampero.apps.vidulum.database.AppDatabase;
import ar.com.joaquincampero.apps.vidulum.repository.TransactionRepository;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Joaquin Campero
 * on 2/4/19.
 */
@Module
public class TransactionModule {

    @Provides
    @Singleton
    TransactionDao providesTransactionDao(AppDatabase database) {
        return database.transactionDao();
    }

    @Provides
    @Singleton
    TransactionRepository providesTransactionRepository(TransactionDao dao) {
        return new TransactionRepository(dao);
    }

}
