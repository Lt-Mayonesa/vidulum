package ar.com.joaquincampero.apps.vidulum.ui.main;

import android.os.Bundle;

import ar.com.joaquincampero.apps.vidulum.R;
import ar.com.joaquincampero.apps.vidulum.ui.BaseActivity;
import ar.com.joaquincampero.apps.vidulum.ui.transaction.NewTransactionFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_recent_transactions, MainFragment.newInstance())
                    .replace(R.id.container_new_transaction, NewTransactionFragment.newInstance())
                    .commitNow();
        }
    }
}
