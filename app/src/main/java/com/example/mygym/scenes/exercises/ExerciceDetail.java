package com.example.mygym.scenes.exercises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mygym.R;
import com.example.mygym.datasources.ExercicesDataSource;
import com.example.mygym.entities.ExercicesEntity;

public class ExerciceDetail extends AppCompatActivity {

    private ExercicesEntity entity;
    public static String CONSTANT_ID_EXERCICE = "PARAM_ID_EXERCICE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_exercice_detail );

        String exerciceID = ExerciceDetail.this.getIntent().getStringExtra( CONSTANT_ID_EXERCICE );
        this.entity = ExercicesDataSource.shared.getById( exerciceID );


        ((TextView) this.findViewById(R.id.textView1)).setText(this.entity.name);

    }
}
