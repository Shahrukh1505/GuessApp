package com.example.guessnumber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.guessnumber.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
private int randomNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomNumber = (int)(Math.random()*20 + 1);
            }
        });
        binding.guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    if (randomNumber != 0) {
                        int n = Integer.parseInt(binding.number.getText().toString());
                        if (n == randomNumber) {
                            Intent intent = new Intent(MainActivity.this, guessResult.class);
                            intent.putExtra("correct", n);
                            startActivity(intent);


                        } else if (n < randomNumber) {
                            binding.status.setText(" Too Low");
                        } else if (n > randomNumber) {
                            binding.status.setText(" Too high");
                        }

                    }
                    else {
                        binding.status.setText("You have not entered the number");
                    }

            }
        });
        binding.reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomNumber = 0;

                binding.status.setText("");
            }
        });

    }
}