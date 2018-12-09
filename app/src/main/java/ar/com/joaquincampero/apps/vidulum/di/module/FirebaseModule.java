package ar.com.joaquincampero.apps.vidulum.di.module;

import android.content.Context;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Singleton;

import ar.com.joaquincampero.apps.vidulum.R;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Joaquin Campero
 * on 11/26/18.
 */
@Module
public class FirebaseModule {

    @Singleton
    @Provides
    FirebaseAuth providesFirebaseAuth() {
        return FirebaseAuth.getInstance();
    }

    @Singleton
    @Provides
    GoogleSignInClient providesGoogleSignIn(Context context, GoogleSignInOptions googleSignInOptions) {
        return GoogleSignIn.getClient(context, googleSignInOptions);
    }

    @Singleton
    @Provides
    GoogleSignInOptions providesGoogleSignInOptions(Context context) {
        return new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(context.getString(R.string.firebase_client_id))
                .requestEmail()
                .build();
    }

}
