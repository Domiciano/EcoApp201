package com.example.interacciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView labelTv;
    private EditText nameEt;
    private Button actionBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        labelTv = findViewById(R.id.labelTv);
        nameEt = findViewById(R.id.nameEt);
        actionBtn = findViewById(R.id.actionBtn);

        actionBtn.setOnClickListener(

                (v) -> {
                    String name = nameEt.getText().toString();
                    //labelTv.setText(name);
                    Intent i = new Intent(MainActivity.this, ProfileActivity.class);
                    i.putExtra("nombre", name);
                    startActivity(i);
                }

        );

    }
}















