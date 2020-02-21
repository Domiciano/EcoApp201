package com.example.interacciones;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {

    private TextView userTv;
    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String name = getIntent().getExtras().getString("nombre");



        userTv = findViewById(R.id.userTv);
        backBtn = findViewById(R.id.backBtn);

        userTv.setText("Hola "+name);

        backBtn.setOnClickListener(
                (v)->{
                    //1. Cerrar actividad

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Confirmar");
                    builder.setMessage("Desea cerrar la actividad?");
                    builder.setNegativeButton("No", (dialog, which) -> {
                        dialog.dismiss();
                    });
                    builder.setPositiveButton("Si", (dialog, which) -> {
                        finish();
                    });

                    builder.show();




                    //2. Volver a abri actividad
                    //Intent i = new Intent(ProfileActivity.this, MainActivity.class);
                    //startActivity(i);

                    //3. Cerrar una app
                    //System.exit(0);
                }
        );
    }
}

















