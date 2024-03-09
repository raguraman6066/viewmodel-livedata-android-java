package com.example.viewmodelstate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//https://developer.android.com/jetpack/androidx/releases/lifecycle
//The ViewModel class is a business logic or screen level state holder
public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    int count;
   MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        mainViewModel=new  ViewModelProvider(this).get(MainViewModel.class);
//        textView.setText("you clicked me "+mainViewModel.getInitial()+" times");
       //using live data get count
        LiveData<Integer> count=mainViewModel.getInitial();
        count.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText("You clicked me "+integer+" times");
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   textView.setText("you clicked me " + mainViewModel.getCount() + " times");
           mainViewModel.getCount();
            }
        });
    }
}