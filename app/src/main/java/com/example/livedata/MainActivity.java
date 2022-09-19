package com.example.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        MainActivityViewModel viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.startTimer();

        // each time there is a change to the value of getSeconds() this part of the code will run and update the view
        viewModel.getSeconds().observe(this, new Observer() {
            @Override
            public void onChanged(Object o) {
                textView.setText(o.toString());
            }
        });
    }
}