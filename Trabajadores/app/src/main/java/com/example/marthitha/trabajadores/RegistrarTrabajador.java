package com.example.marthitha.trabajadores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marthitha.trabajadores.dao.TrabajadorDAO;
import com.example.marthitha.trabajadores.model.Trabajador;

public class RegistrarTrabajador extends AppCompatActivity implements View.OnClickListener{

    private EditText ID;
    private EditText txtapellidoP;
    private EditText txtapellidoM;
    private EditText txtnombre;
    private EditText txtCURP;
    private EditText txtpuesto;
    private EditText txtdepartamento;

    private RadioButton rbHombre;
    private RadioButton rbMujer;
    private Button Guardar;
    private Button Cancelar;

    private int gen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_trabajador);
        //1. Se relacionan los controles de la actividad con los controles de la vista
         iniciarVariblaes();

        Guardar.setOnClickListener(this);
        //3. Se asigna escuchador de clics al btnCancelar
        Cancelar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Se cierra la vista
                System.exit(0);
            }
        });
    }

    private void iniciarVariblaes(){
        ID = (EditText)findViewById(R.id.txt_ID);
        txtapellidoP = (EditText)findViewById(R.id.txt_apellido_paterno);
        txtapellidoM = (EditText)findViewById(R.id.txt_apellido_materno);
        txtnombre = (EditText)findViewById(R.id.txt_nombre);
        txtCURP = (EditText)findViewById(R.id.txt_CURP);
        txtpuesto = (EditText)findViewById(R.id.txt_puesto);
        txtdepartamento = (EditText)findViewById(R.id.txt_departamento);
        Guardar = (Button)findViewById(R.id.btn_guardar);
        Cancelar = (Button)findViewById(R.id.btn_cancelar);

        rbHombre = (RadioButton)findViewById(R.id.radio_masculino);
        rbMujer = (RadioButton)findViewById(R.id.radio_femenino);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_guardar:
                Toast.makeText(getApplicationContext(), "datos: " , Toast.LENGTH_LONG);
                if (rbHombre.isChecked()){
                    gen = 1;
                }else {
                    if (rbMujer.isChecked()){
                        gen =  0;
                    }
                }
                Trabajador p = new Trabajador();
                //Se asignan los atributos del objeto
//                p.setId(Integer.parseInt(ID.getText().toString()));
                p.setApellidoP(txtapellidoP.getText().toString());
                p.setApellidoM(txtapellidoM.getText().toString());
                p.setNombre(txtnombre.getText().toString());
                p.setCurp(txtCURP.getText().toString());
                p.setSexo(gen);
                p.setPuesto(txtpuesto.getText().toString());
                p.setDepartamento(txtdepartamento.getText().toString());
                //Se crea un objeto DAO para almacenar el objeto
                Toast.makeText(getApplicationContext(), "datos: " + p.toString() , Toast.LENGTH_LONG);
                TrabajadorDAO dao = new TrabajadorDAO(getApplicationContext());
                try {
                    //Se trata de insertar el objeto
                    dao.insert(p);
                    //Se muestra un mensaje ÃƒÂ©xito y se cierra la vista
                    Toast.makeText(getApplicationContext(), "Trabajador almacenado", Toast.LENGTH_SHORT).show();
                    finish();
                    Intent i = new Intent(getApplicationContext(),ListaTrabajador.class);
                    startActivity(i);
                } catch (Exception e) {
                    //En caso de excepciÃƒÂ³n se muestra el mensaje
                    Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_cancelar:
                finish();
                break;

        }
    }
}