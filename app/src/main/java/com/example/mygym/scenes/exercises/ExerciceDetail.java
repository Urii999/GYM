package com.example.mygym.scenes.exercises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mygym.R;
import com.example.mygym.datasources.ExercicesDataSource;
import com.example.mygym.entities.ExercicesEntity;
import com.squareup.picasso.Picasso;

public class ExerciceDetail extends AppCompatActivity {

    private ExercicesEntity entity;
    public static String CONSTANT_ID_EXERCICE = "PARAM_ID_EXERCICE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_exercice_detail );

        String exerciceID = ExerciceDetail.this.getIntent().getStringExtra( CONSTANT_ID_EXERCICE );
        this.entity = ExercicesDataSource.shared.getById( exerciceID );


        ((TextView) this.findViewById(R.id.textViewN)).setText(this.entity.name);
        ((TextView) this.findViewById(R.id.textViewH)).setText(this.entity.hores);
        ((TextView) this.findViewById(R.id.textViewD)).setText(this.entity.description);
        ((TextView) this.findViewById(R.id.textViewD)).setMovementMethod(new ScrollingMovementMethod());


        //Using Picasso to cache the image
        Picasso.get().load(this.entity.iconurl).into((ImageView) this.findViewById(R.id.imageView2));

    }
}
