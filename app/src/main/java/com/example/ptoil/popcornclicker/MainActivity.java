package com.example.ptoil.popcornclicker;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int popcorn;
    TextView textView;

    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPref = getPreferences(MODE_PRIVATE);

        popcorn = sharedPref.getInt("popcorn", 0);
        textView = (TextView) findViewById(R.id.popcornView);
        textView.setText(String.valueOf(popcorn));

    }

    public void saveData () {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("popcorn", popcorn);
        editor.commit();
    }

    public void addPopcorn (View view) {
        popcorn++;
        textView.setText(String.valueOf(popcorn));
        saveData();
    }
}
