package com.example.guessnumber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.TextView;

import com.example.guessnumber.databinding.ActivityMainBinding;

public class guessResult extends AppCompatActivity {
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_guess_result);

       textView = findViewById(R.id.result);

       textView.setText("You got the number right!");

    }

}