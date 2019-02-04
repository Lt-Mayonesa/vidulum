package ar.com.joaquincampero.apps.vidulum.repository;

import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import ar.com.joaquincampero.apps.vidulum.dao.TransactionDao;
import ar.com.joaquincampero.apps.vidulum.database.AppDatabase;
import ar.com.joaquincampero.apps.vidulum.model.Transaction;
import ar.com.joaquincampero.apps.vidulum.repository.task.InsertAsyncTask;

/**
 * Created by Joaquin Campero
 * on 2/3/19.
 */
public class TransactionRepository {

    private TransactionDao mTransactionDao;

    private LiveData<List<Transaction>> mAllTransactions;

    @Inject
    public TransactionRepository(TransactionDao mTransactionDao) {
        this.mTransactionDao = mTransactionDao;

        mAllTransactions = mTransactionDao.getAll();
    }

    public LiveData<List<Transaction>> getAllTransactions() {
        return mAllTransactions;
    }

    public void insert(Transaction transaction) {
        new InsertAsyncTask<>(mTransactionDao).execute(transaction);
    }
}
