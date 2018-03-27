package utng.mmendiola.telefonicastrategy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import utng.mmendiola.telefonicastrategy.patronsingleton.MensajeSingleton;
import utng.mmendiola.telefonicastrategy.patronstrategy.Contexto;
import utng.mmendiola.telefonicastrategy.patronstrategy.Movistar;
import utng.mmendiola.telefonicastrategy.patronstrategy.MyCompany;
import utng.mmendiola.telefonicastrategy.patronstrategy.Telcel;
import utng.mmendiola.telefonicastrategy.patronstrategy.Unefon;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener{

    private Button btnCalcular;
    private Button btnMostrar;
    private Button btnLimpiar;
    private Button btnMostrarMensaje;
    private EditText txtMinutosLocal;
    private EditText txtMinutosLD;
    private EditText txtTotal;
    private Spinner cmbOpciones;
    private Contexto contexto;
    private String[] opciones = {"Telcel", "Unefon", "MyCompany", "Movistar"};
    private int op = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Relacionar los controles de la vista
        btnCalcular = (Button)findViewById(R.id.btn_calcular);
        btnMostrar = (Button)findViewById(R.id.btn_mostrar);
        btnLimpiar = (Button)findViewById(R.id.btn_limpiar);
        btnMostrarMensaje = (Button)findViewById(R.id.btn_mostrar_mensaje);
        txtMinutosLocal = (EditText)findViewById(R.id.txt_minutos_local);
        txtMinutosLD = (EditText)findViewById(R.id.txt_minutos_ld);
        txtTotal = (EditText)findViewById(R.id.txt_total);
        cmbOpciones = (Spinner)findViewById(R.id.cmb_opciones);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinner_item,opciones);
        cmbOpciones.setAdapter(adapter);

        cmbOpciones.setOnItemSelectedListener(this);
        btnCalcular.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);
        btnMostrar.setOnClickListener(this);
        btnMostrarMensaje.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        op = (int)cmbOpciones.getSelectedItemId();
        switch (op){
            case 0: //Telcel
                contexto = new Contexto(new Telcel());
                break;
            case 1: //Unefon
                contexto = new Contexto(new Unefon());
                break;
            case 2: //MyCompany
                contexto = new Contexto(new MyCompany());
                break;
            case 3:
                contexto = new Contexto(new Movistar());
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        int minutosLocal = 0;
        int minutosLD = 0;
        double total = 0.0;

        switch (v.getId()){
            case R.id.btn_calcular:
                if(txtMinutosLocal.getText().toString() != ""){
                    if(txtMinutosLD.getText().toString() != ""){
                        minutosLocal = Integer.parseInt(txtMinutosLocal.getText().toString());
                        minutosLD = Integer.parseInt(txtMinutosLD.getText().toString());
                        total = contexto.calcularTarifaLocal(minutosLocal) + contexto.calcularTarifaLD(minutosLD);
                        txtTotal.setText("$" + total);
                    }
                    else{
                        Toast toast = Toast.makeText(this, "Se debe ingresar los minutos LD", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.show();
                    }
                }
                else{
                    Toast toast = Toast.makeText(this, "Se debe ingresar los minutos locales", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                }

                break;
            case R.id.btn_limpiar:
                txtMinutosLocal.setText("");
                txtMinutosLD.setText("");
                txtTotal.setText("");
                break;
            case R.id.btn_mostrar:
                Intent i = new Intent(this, CreditosActivity.class);
                startActivity(i);
                break;
            case R.id.btn_mostrar_mensaje:
                String mensaje = "";
                mensaje = MensajeSingleton.getInstance().getMensaje();
                Toast toast = Toast.makeText(this, mensaje, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                break;
        }
    }
}
