package com.example.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Datos extends AppCompatActivity {
    Button back;
    TextView pnombre;
    TextView pfecha;
    TextView ptel;
    TextView pemail;
    TextView pdescrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        Bundle parametros = getIntent().getExtras();
        final String nombre = parametros.getString("nombre");
        final String fecha = parametros.getString("fecha");
        final String telefono = parametros.getString("telefono");
        final String email = parametros.getString("email");
        final String descripcion = parametros.getString("descripcion");

         pnombre = (TextView) findViewById(R.id.textView8);
         pfecha = (TextView) findViewById(R.id.textView9);
         ptel = (TextView) findViewById(R.id.textView10);
         pemail = (TextView) findViewById(R.id.textView11);
         pdescrip = (TextView) findViewById(R.id.textView12);

        pnombre.setText(nombre);
        pfecha.setText(fecha);
        ptel.setText(telefono);
        pemail.setText(email);
        pdescrip.setText(descripcion);

        back = (Button) findViewById(R.id.button2);
        back.setOnClickListener(view -> {
            Intent i = new Intent(Datos.this,MainActivity.class);
            i.putExtra("nombre2",nombre);
            i.putExtra("fecha2",fecha);
            i.putExtra("telefono2",telefono);
            i.putExtra("email2",email);
            i.putExtra("descripcion2",descripcion);
            startActivity(i);
        });

    }
}
