package com.example.mygym.scenes.exercises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import com.example.mygym.R;
import com.example.mygym.datasources.ExercicesDataSource;
import com.example.mygym.entities.ExercicesEntity;
import com.example.mygym.helpers.CustomCallBack;
import com.example.mygym.scenes.main.MainActivity;

import java.util.ArrayList;

public class ExercisesActivity extends AppCompatActivity {
    ExercicesPresenter presenter;

    public void navigateToDetail(ExercicesEntity exercice){
        //Crate an intent to a private activity --> Exercices
        Intent intent = new Intent( ExercisesActivity.this, ExerciceDetail.class);
        intent.setAction(Intent.ACTION_VIEW);
        intent.putExtra(ExerciceDetail.CONSTANT_ID_EXERCICE, exercice.id);

        ExercisesActivity.this.startActivity(intent);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);
        this.presenter = new ExercicesPresenter(this);


        ExercicesDataSource.shared.fetchAll( new CustomCallBack() {
            @Override
            public void onSuccess(Object responseObject) {
                ArrayList<ExercicesEntity> list  = (ArrayList<ExercicesEntity>) responseObject;
                presenter.UpdateList( list);


                ((GridView) findViewById(R.id.GridView)).setAdapter(ExercisesActivity.this.presenter);

            }

            @Override
            public void onError() {

            }
        },true );

    }
}

