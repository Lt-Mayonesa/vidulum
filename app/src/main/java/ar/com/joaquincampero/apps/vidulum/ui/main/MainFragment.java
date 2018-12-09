package ar.com.joaquincampero.apps.vidulum.ui.main;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import ar.com.joaquincampero.apps.vidulum.R;
import ar.com.joaquincampero.apps.vidulum.ui.BaseFragment;
import ar.com.joaquincampero.apps.vidulum.vm.factory.SessionActivityFactory;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragment extends BaseFragment {

    @Inject
    SessionActivityFactory sessionActivityFactory;
    private SessionViewModel mViewModel;

    @BindView(R.id.message)
    TextView mTxtMessage;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this, sessionActivityFactory).get(SessionViewModel.class);

        mViewModel.getCurrentUser().observe(this, firebaseUser -> {
            mTxtMessage.setText(firebaseUser != null ? firebaseUser.getDisplayName() : "Not Signed In");
        });
    }

}
