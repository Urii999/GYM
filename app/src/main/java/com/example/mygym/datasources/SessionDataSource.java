package com.example.mygym.datasources;

import androidx.annotation.NonNull;

import com.example.mygym.helpers.CustomCallBack;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SessionDataSource {

    public static SessionDataSource shared = new SessionDataSource();

    public void signOut() {
        FirebaseAuth.getInstance().signOut();
    }

    public void getCurrentUser(final CustomCallBack callback) {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        callback.onSuccess(currentUser);
    }

    public  Boolean isUserLogedIn() {
        return FirebaseAuth.getInstance().getCurrentUser() != null;
    }

    public void SignIn(final CustomCallBack callback) {
        FirebaseAuth.getInstance().signOut();
        FirebaseAuth.getInstance().signInAnonymously().addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    callback.onSuccess(FirebaseAuth.getInstance().getCurrentUser());
                }else {
                    callback.onError();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                callback.onError();
            }
        });//

    }
}