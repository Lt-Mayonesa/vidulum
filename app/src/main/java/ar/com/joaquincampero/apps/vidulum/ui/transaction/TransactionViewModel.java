package ar.com.joaquincampero.apps.vidulum.ui.transaction;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import ar.com.joaquincampero.apps.vidulum.model.Transaction;
import ar.com.joaquincampero.apps.vidulum.repository.TransactionRepository;

/**
 * Created by Joaquin Campero
 * on 2/3/19.
 */
public class TransactionViewModel extends ViewModel {

    private TransactionRepository mTransactionRepository;

    private LiveData<List<Transaction>> mTransactions;

    @Inject
    public TransactionViewModel(TransactionRepository mTransactionRepository) {
        this.mTransactionRepository = mTransactionRepository;
        mTransactions = this.mTransactionRepository.getAllTransactions();
    }

    public LiveData<List<Transaction>> getTransactions() {
        return mTransactions;
    }

    public void insert(Transaction transaction) {
        mTransactionRepository.insert(transaction);
    }
}
