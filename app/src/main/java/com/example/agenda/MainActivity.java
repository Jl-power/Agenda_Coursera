package com.example.agenda;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private int dia,mes,anio;
    Calendar c = Calendar.getInstance();
    EditText nombre,fecha,tel,email,descrip;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dia = c.get(Calendar.DAY_OF_MONTH);
        mes = c.get(Calendar.MONTH);
        anio = c.get(Calendar.YEAR);

        nombre =  findViewById(R.id.editTextTextPersonName);
        tel =  findViewById(R.id.editTextPhone);
        email = findViewById(R.id.editTextTextEmailAddress);
        descrip = findViewById(R.id.editTextTextMultiLine);
        fecha = findViewById(R.id.editTextDate);
        next = findViewById(R.id.button);



        fecha.setOnClickListener(view -> {
            DatePickerDialog pickerdeFecha = new DatePickerDialog(MainActivity.this, (view1, year, month, day) -> {
                month = month+1;
                String date = day+"/"+month+"/"+year;
                fecha.setText(date);

            },anio,mes,dia);
            pickerdeFecha.show();
        });


        next.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this,Datos.class);
            i.putExtra("nombre",nombre.getText().toString());
            i.putExtra("fecha",fecha.getText().toString());
            i.putExtra("telefono",tel.getText().toString());
            i.putExtra("email",email.getText().toString());
            i.putExtra("descripcion",descrip.getText().toString());
            startActivity(i);
        });

        if(getIntent().getExtras()!=null) {
            Bundle parametros2 = getIntent().getExtras();
            final String nombre2 = parametros2.getString("nombre2");
            final String fecha2 = parametros2.getString("fecha2");
            final String telefono2 = parametros2.getString("telefono2");
            final String email2 = parametros2.getString("email2");
            final String descripcion2 = parametros2.getString("descripcion2");

            nombre.setText(nombre2);
            fecha.setText(fecha2);
            tel.setText(telefono2);
            email.setText(email2);
            descrip.setText(descripcion2);
            }
    }

}