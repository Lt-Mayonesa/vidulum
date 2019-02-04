package ar.com.joaquincampero.apps.vidulum.ui.transaction.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import ar.com.joaquincampero.apps.vidulum.R;
import ar.com.joaquincampero.apps.vidulum.model.Transaction;
import ar.com.joaquincampero.apps.vidulum.ui.transaction.viewholder.TransactionViewHolder;

/**
 * Created by Joaquin Campero
 * on 2/3/19.
 */
public class TransactionListAdapter extends RecyclerView.Adapter<TransactionViewHolder> {

    private Context mContext;

    private List<Transaction> mTransactions;

    @Inject
    public TransactionListAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.rv_item_transaction, viewGroup, false);
        return new TransactionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder transactionViewHolder, int i) {
        if (mTransactions != null) {
            Transaction transaction = mTransactions.get(i);
            transactionViewHolder.amount.setText(String.format("%s", transaction.getAmount()));
        } else {
            transactionViewHolder.amount.setText("No item");
        }
    }

    @Override
    public int getItemCount() {
        return mTransactions != null ? mTransactions.size() : 0;
    }

    public void setTransactions(List<Transaction> transactions) {
        mTransactions = transactions;
        notifyDataSetChanged();
    }
}
