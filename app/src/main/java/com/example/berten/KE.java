package com.example.berten;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class KE extends AppCompatActivity implements View.OnClickListener{


    private Button button_1;
    private Button button_2;

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnNieten) {
            Intent intent3 = new Intent(this, MainActivity3.class);
            startActivity(intent3);
        }
        if (v.getId() == R.id.btnSchweißen) {
            Intent intent4 = new Intent(this, MainActivity4.class);
            startActivity(intent4);
        }
        if (v.getId() == R.id.btnSchrauben) {
            //Intent intent5 = new Intent(this, MainActivity5.class);
            //startActivity(intent5);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button_1 = findViewById(R.id.btnNieten);
        button_1.setOnClickListener(this);

        button_2 = findViewById(R.id.btnSchweißen);
        button_2.setOnClickListener(this);
    }
}