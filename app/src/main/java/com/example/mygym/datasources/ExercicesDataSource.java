package com.example.mygym.datasources;

import androidx.annotation.NonNull;


import com.example.mygym.helpers.CustomCallBack;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class ExercicesDataSource {

    public static ExercicesDataSource shared = new ExercicesDataSource();

    private ArrayList<ExercicesDataSource> assetsList = new ArrayList<ExercicesDataSource>();
    private String id;
    private ArrayList<ExercicesDataSource> ExercicesList;


    public ExercicesDataSource getById(String id){

        for (ExercicesDataSource asset : this.assetsList) {
            if (asset.id.equals(id)) {
                return asset;
            }
        }

        return null;
    }

    public void subscribe(final CustomCallBack callback) {
        this.fetch(true, callback);

    }

    public void fetchAll(final CustomCallBack callback, final Boolean subscribe) {
        this.fetch(false, callback);

    }

    private void fetch(final  Boolean subscribeCallback, final CustomCallBack callback){

        final DatabaseReference databaseReference =
                FirebaseDatabase.getInstance().getReference().child("exercices");

        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<ExercicesDataSource> ExercicesList = new ArrayList<ExercicesDataSource>();

                for (DataSnapshot item_snapshot : dataSnapshot.getChildren()) {

                    ExercicesList.add(snapshotToAssetModel(item_snapshot));
                }

                ExercicesDataSource.this.ExercicesList = ExercicesList;

                if(!subscribeCallback){
                    databaseReference.removeEventListener(this);
                }

                callback.onSuccess(ExercicesList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
               callback.onError();
            }
        };

        databaseReference.addValueEventListener(eventListener);
    }

    private ExercicesDataSource snapshotToAssetModel(DataSnapshot item_snapshot) {

        String id = item_snapshot.getKey().toString();

        Integer name = item_snapshot.child("name").exists() ? Integer.parseInt(item_snapshot.child("name").getValue().toString()) : 0;
    


        return new ExercicesDataSource();

    }
}





