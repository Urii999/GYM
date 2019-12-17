package com.example.mygym.scenes.exercises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mygym.R;
import com.example.mygym.datasources.ExercicesDataSource;
import com.example.mygym.entities.ExercicesEntity;
import com.example.mygym.helpers.CustomCallBack;

import java.util.ArrayList;

public class ExercisesActivity extends AppCompatActivity {
    ExercicesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);
        this.presenter = new ExercicesPresenter();

        ExercicesDataSource.shared.fetchAll( new CustomCallBack() {
            @Override
            public void onSuccess(Object responseObject) {
                ArrayList<ExercicesEntity> list  = (ArrayList<ExercicesEntity>) responseObject;
                presenter.UpdateList( list);


                //((GridView) findViewById(R.id.galleryGrid)).setAdapter(this.presenter);

            }

            @Override
            public void onError() {

            }
        },true );

    }
}

