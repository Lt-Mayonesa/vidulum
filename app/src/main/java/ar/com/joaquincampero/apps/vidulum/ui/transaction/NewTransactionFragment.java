package ar.com.joaquincampero.apps.vidulum.ui.transaction;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

import javax.inject.Inject;

import ar.com.joaquincampero.apps.vidulum.R;
import ar.com.joaquincampero.apps.vidulum.model.Transaction;
import ar.com.joaquincampero.apps.vidulum.ui.BaseFragment;
import ar.com.joaquincampero.apps.vidulum.ui.factory.TransactionVMFactory;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NewTransactionFragment extends BaseFragment implements View.OnClickListener {

    @Inject
    TransactionVMFactory mTransactionVMFactory;

    private TransactionViewModel mTransactionViewModel;

    @BindView(R.id.input_transaction_user)
    EditText mInputUser;

    @BindView(R.id.input_transaction_date)
    EditText mInputDate;

    @BindView(R.id.input_transaction_amount)
    EditText mInputAmount;

    @BindView(R.id.input_transaction_description)
    EditText mInputDescription;

    @BindView(R.id.button_transaction_create)
    Button mBtnCreate;

    public static NewTransactionFragment newInstance() {
        return new NewTransactionFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_transaction, container, false);
        ButterKnife.bind(this, view);

        mBtnCreate.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_transaction_create) {
            Transaction t = new Transaction(
                    mInputUser.getText().toString(),
                    new Date(),
                    Double.valueOf(mInputAmount.getText().toString()),
                    mInputDescription.getText().toString()
            );
            if (mTransactionViewModel != null)
                mTransactionViewModel.insert(t);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTransactionViewModel = ViewModelProviders.of(this, mTransactionVMFactory).get(TransactionViewModel.class);
    }
}
