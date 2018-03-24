package com.example.marthitha.trabajadores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.marthitha.trabajadores.dao.TrabajadorDAO;
import com.example.marthitha.trabajadores.model.Trabajador;

public class Actualizar extends AppCompatActivity {
    private EditText ID;
    private EditText txtapellidoP;
    private EditText txtapellidoM;
    private EditText txtnombre;
    private EditText txtCURP;
    private EditText txtpuesto;
    private EditText txtdepartamento;
    private Button Actualizar;
    private Button Cancelar;
    private Button Eliminar;

    private RadioButton rbHom;
    private RadioButton rbMej;

    private int gen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        //Se indica la vista a cargar
        setContentView(R.layout.activity_actualizar);
        //1. Se relacionan los controles de la actividad con los controles de la vista
        ID = (EditText)findViewById(R.id.txt_ID);
        txtapellidoP = (EditText)findViewById(R.id.txt_apellidoP);
        txtapellidoM = (EditText)findViewById(R.id.txt_apellidoM);
        txtnombre = (EditText)findViewById(R.id.txt_nombre);
        txtCURP = (EditText)findViewById(R.id.et_curp);
        txtpuesto = (EditText)findViewById(R.id.txt_puesto);
        txtdepartamento = (EditText)findViewById(R.id.txt_departamento);
        Actualizar = (Button)findViewById(R.id.btn_actualizar);
        Cancelar = (Button)findViewById(R.id.btn_cancelar);
        Eliminar = (Button)findViewById(R.id.btn_eliminar);

        rbHom = (RadioButton)findViewById(R.id.rb_masculino);
        rbMej = (RadioButton)findViewById(R.id.rb_femenino);
        //2. Se obtiene el valor CODIGO_DE_BARRAS de un bundle de la actividad
        String id = getIntent().getExtras().getString("id");
        //Toast.makeText(getApplicationContext(), "Error: " + codigoBarras, Toast.LENGTH_SHORT).show();
        //3. Se crea un objeto Producto
        Trabajador p = new Trabajador();
        //Toast.makeText(getApplicationContext(), "Error: " + p.getCodigo(), Toast.LENGTH_SHORT).show();
        //4. Se asigna el codigo de barras del bundle al objeto para buscarlo en la BD
        p.setId(Integer.parseInt(id));
        //Toast.makeText(getApplicationContext(), "Error: " + p.getCodigo(), Toast.LENGTH_SHORT).show();
        //5. Se crea un objeto DAO para buscar el producto
        TrabajadorDAO dao = new TrabajadorDAO(getApplicationContext());
        try {
            p = dao.getById(p);

            switch (p.getSexo()) {
                case 1:
                    rbHom.setChecked(true);
                    break;
                case 0:
                    rbMej.setChecked(true);
                    break;
            }
            //Se asigna el valor a los controles de acuerdo al valor de los atributos del objeto
            ID.setText(String.valueOf(p.getId()));
            txtapellidoP.setText(p.getApellidoP());
            txtapellidoM.setText(p.getApellidoM());
            txtnombre.setText(p.getNombre());
            txtCURP.setText(p.getCurp());
            txtpuesto.setText(p.getPuesto());
            txtdepartamento.setText(p.getDepartamento());
        } catch (Exception e) {
            //En caso de excepciÃƒÂ³n se muestra el mensaje
            Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        //6. Se agrega un escuchador de eventos al btnActualizar
        Actualizar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Se crea un objeto Producto
                Trabajador p = new Trabajador();
                if (rbHom.isChecked()){
                    gen = 1;
                }else {
                    if (rbMej.isChecked()) {
                    } else {
                        gen = 0;
                    }
                }
                //Se asignan los atributos del objeto
                p.setId(Integer.parseInt(ID.getText().toString()));
                p.setApellidoP(txtapellidoP.getText().toString());
                p.setApellidoM(txtapellidoM.getText().toString());
                p.setNombre(txtnombre.getText().toString());
                p.setCurp(txtCURP.getText().toString());
                p.setSexo(gen);
                p.setPuesto(txtpuesto.getText().toString());
                p.setDepartamento(txtdepartamento.getText().toString());
                //Se crea un objeto DAO para almacenar el objeto
                TrabajadorDAO dao = new TrabajadorDAO(getApplicationContext());
                try {
                    //Se trata de insertar el objeto
                    dao.update(p);
                    //Se muestra un mensaje ÃƒÂ©xito y se cierra la vista
                    Toast.makeText(getApplicationContext(), "Trabajador actualizado", Toast.LENGTH_SHORT).show();
                    System.exit(0);
                } catch (Exception e) {
                    //En caso de excepciÃƒÂ³n se muestra el mensaje
                    Toast.makeText(getApplicationContext(), "Error Update: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        //7. Se agrega un escuchador de eventos al btnEliminar
        Eliminar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Se crea un objeto Producto
                Trabajador p = new Trabajador();
                //Se asignan los atributos del objeto
                p.setId(Integer.parseInt(ID.getText().toString()));
                //Se crea un objeto DAO para almacenar el objeto
                TrabajadorDAO dao = new TrabajadorDAO(getApplicationContext());
                try {
                    //Se trata de insertar el objeto
                    dao.delete(p);
                    //Se muestra un mensaje de éxito y se cierra la vista
                    Toast.makeText(getApplicationContext(), "Producto eliminado", Toast.LENGTH_SHORT).show();
                    System.exit(0);
                } catch (Exception e) {
                    //En caso de excepción se muestra el mensaje
                    Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        //8. Se asigna escuchador de clics al btnCancelar
        Cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Se cierra la vista
                System.exit(0);
            }
        });
    }

}
