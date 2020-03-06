package appmoviles.com.tcpclienteavanzado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class GameActivity extends AppCompatActivity {

    String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);



        String ip = getIntent().getExtras().getString("IP");
        ComunicacionTCP comm = new ComunicacionTCP(this);
        comm.solicitarConexion( ip );



    }
}
