package com.example.mygym.scenes.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mygym.R;

interface IMainActivity {
    void navigateToPublic();
    void navigateToPrivate();

}

public class MainActivity extends AppCompatActivity implements IMainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        //Detect if user is loged in
        if (SessionDatasource.shared.isUserLogedIn()) {
            this.navigateToPrivate();
        }else {
            this.navigateToPublic();
        }
*/

//hshshshjs
        //
    }

    @Override
    public void navigateToPublic() {
        //Crate an intent to a public activity --> WellcomeActivity

    }

    @Override
    public void navigateToPrivate() {
        //Crate an intent to a private activity --> Exercices
    }
}
