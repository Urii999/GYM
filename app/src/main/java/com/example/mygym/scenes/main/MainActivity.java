package com.example.mygym.scenes.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mygym.R;
import com.example.mygym.datasources.SessionDataSource;
import com.example.mygym.scenes.exercises.ExercisesActivity;
import com.example.mygym.scenes.wellcome.WellcomeActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ProgressBar;

interface IMainActivity {
    void navigateToPublic();
    void navigateToPrivate();

}

public class MainActivity extends AppCompatActivity implements IMainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Detect if user is loged in
        if (SessionDataSource.shared.isUserLogedIn()) {
            this.navigateToPrivate();
        }else {
            this.navigateToPublic();
        }



        //
    }

    @Override
    public void navigateToPublic() {
        //Crate an intent to a public activity --> WellcomeActivity

        Intent intent = new Intent(MainActivity.this, WellcomeActivity.class);

        intent.setAction(Intent.ACTION_VIEW);

        MainActivity.this.startActivity(intent);
    }

    @Override
    public void navigateToPrivate() {
        //Crate an intent to a private activity --> Exercices
        Intent intent = new Intent(MainActivity.this, ExercisesActivity.class);

        intent.setAction(Intent.ACTION_VIEW);

        MainActivity.this.startActivity(intent);
    }
}
