package ar.com.joaquincampero.apps.vidulum.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

import ar.com.joaquincampero.apps.vidulum.ui.main.SessionViewModel;
import ar.com.joaquincampero.apps.vidulum.ui.factory.SessionActivityFactory;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by Joaquin Campero
 * on 11/26/18.
 */
public abstract class BaseActivity extends DaggerAppCompatActivity {

    private static final String TAG = BaseActivity.class.getCanonicalName();
    private static final int RC_SIGN_IN = 9001;

    @Inject
    GoogleSignInClient googleSignInClient;

    @Inject
    SessionActivityFactory sessionActivityFactory;

    private SessionViewModel sessionViewModel;

    @Override
    protected void onStart() {
        super.onStart();

        sessionViewModel = ViewModelProviders.of(this, sessionActivityFactory).get(SessionViewModel.class);
        sessionViewModel.getCurrentUser().observe(this, getUserObserver());
    }

    protected Observer<FirebaseUser> getUserObserver() {
        return firebaseUser -> {
            if (firebaseUser == null) {
                showSignIn();
            }
        };
    }

    private void showSignIn() {
        startActivityForResult(googleSignInClient.getSignInIntent(), RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                sessionViewModel.firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                Log.w(TAG, "Google Sign In Failed", e);
            }
        }
    }
}
