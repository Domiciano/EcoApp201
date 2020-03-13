package appmoviles.com.tcpclienteavanzado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etIP;
    private Button btnConectar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etIP = findViewById(R.id.etIP);
        btnConectar = findViewById(R.id.btnConectar);
        btnConectar.setOnClickListener(
                (v) -> {
                    Intent intent = new Intent(this, GameActivity.class);
                    intent.putExtra("IP",etIP.getText().toString());
                    startActivity(intent);
                }
        );

    }
}
