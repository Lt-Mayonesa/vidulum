package ar.com.joaquincampero.apps.vidulum.ui.main;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import ar.com.joaquincampero.apps.vidulum.R;
import ar.com.joaquincampero.apps.vidulum.ui.BaseFragment;
import ar.com.joaquincampero.apps.vidulum.ui.factory.SessionActivityFactory;
import ar.com.joaquincampero.apps.vidulum.ui.factory.TransactionVMFactory;
import ar.com.joaquincampero.apps.vidulum.ui.transaction.TransactionViewModel;
import ar.com.joaquincampero.apps.vidulum.ui.transaction.adapter.TransactionListAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragment extends BaseFragment {

    @Inject
    SessionActivityFactory mSessionActivityFactory;

    @Inject
    TransactionVMFactory mTransactionVMFactory;

    @Inject
    TransactionListAdapter transactionListAdapter;

    private SessionViewModel mSessionVM;

    private TransactionViewModel mTransactionVM;

    @BindView(R.id.message)
    TextView mTxtMessage;

    @BindView(R.id.recycler_view_transactions)
    RecyclerView mRecyclerTransactions;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        ButterKnife.bind(this, view);

        mRecyclerTransactions.setAdapter(transactionListAdapter);
        mRecyclerTransactions.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSessionVM = ViewModelProviders.of(this, mSessionActivityFactory).get(SessionViewModel.class);
        mTransactionVM = ViewModelProviders.of(this, mTransactionVMFactory).get(TransactionViewModel.class);

        mSessionVM.getCurrentUser().observe(this,
                firebaseUser ->
                        mTxtMessage.setText(firebaseUser != null ?
                                firebaseUser.getDisplayName() : "Not Signed In"));

        mTransactionVM.getTransactions().observe(this,
                transactions -> transactionListAdapter.setTransactions(transactions));
    }
}
