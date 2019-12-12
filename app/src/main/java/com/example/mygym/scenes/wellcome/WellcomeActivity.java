package com.example.mygym.scenes.wellcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mygym.R;
import com.example.mygym.scenes.exercises.ExercisesActivity;


interface IWellcomeActivity {
    void navigateToPrivate();
}


public class WellcomeActivity extends AppCompatActivity implements IWellcomeActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);

            Button btn = (Button) findViewById(R.id.button);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   WellcomeActivity.this.navigateToPrivate();
                }
            });
        }


    @Override
    public void navigateToPrivate() {
        Intent intent = new Intent(WellcomeActivity.this, ExercisesActivity.class);
        startActivityForResult(intent, 0);
    }
}

