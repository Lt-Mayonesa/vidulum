package ar.com.joaquincampero.apps.vidulum.ui.main;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class SessionViewModel extends ViewModel {
    private static final String TAG = SessionViewModel.class.getCanonicalName();

    private FirebaseAuth firebaseAuth;

    private MutableLiveData<FirebaseUser> mCurrentUser;

    public SessionViewModel(FirebaseAuth firebaseAuth) {
        this.firebaseAuth = firebaseAuth;
    }

    public MutableLiveData<FirebaseUser> getCurrentUser() {
        if (mCurrentUser == null) {
            mCurrentUser = new MutableLiveData<>();
            mCurrentUser.setValue(firebaseAuth.getCurrentUser());
        }
        return mCurrentUser;
    }

    public void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithCredential:success");
                        mCurrentUser.setValue(firebaseAuth.getCurrentUser());
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithCredential:failure", task.getException());
//                            Snackbar.make(findViewById(R.id.main_layout), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
//                            updateUI(null);
                    }
                });
    }
}
