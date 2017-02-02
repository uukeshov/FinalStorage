package storage.com.finalstorage.service;

/**
 * Created by uukeshov on 01.02.2017.
 */

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseHelper {
    private static final String TAG = "FirebaseHelperlog";
    private DatabaseReference dataReference;
    private DatabaseReference mDatabaseReference = FirebaseDatabase.getInstance().getReference();
    private Boolean isExist = false;
    private FirebaseAuth mFirebaseAuth = FirebaseAuth.getInstance();
    private FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();

    private static FirebaseHelper instance = null;

    public static FirebaseHelper getInstance() {
        if (instance == null) {
            instance = new FirebaseHelper();
        }
        return instance;
    }

    public FirebaseHelper() {
        dataReference = FirebaseDatabase.getInstance().getReference();
    }

    public DatabaseReference getDataReference() {
        return dataReference;
    }

    public String getAuthUserId() {
        return mFirebaseUser.getUid();
    }

    public String getAuthUserDisplayName() {
        return mFirebaseUser.getDisplayName();
    }

    public String getUserById(String userId) {
        return userId;
    }
}