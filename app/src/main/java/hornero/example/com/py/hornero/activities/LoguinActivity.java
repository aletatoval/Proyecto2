package hornero.example.com.py.hornero.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import hornero.example.com.py.hornero.R;


/**
 * Created by Ale on 27/07/2015.
 */
public class LoguinActivity extends Activity {

    private EditText cedula;
    private EditText contraseña;
    private Button acceder;
    private Button registrarse;

    //1. Creamos las claves a utilizar para guardar las preferencias
    private static final String MIS_PREFERENCIAS = "preferencias";
    private static final String CEDULA = "cedula";
    private static final String CONTRASEÑA = "contraseña";

    //2. Declaramos una variable del tipo SharedPrefences y un editor para manipular los datos
    private SharedPreferences preferencias;
    private SharedPreferences.Editor editor;
    private static final String TAG = " LoguinActivity ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loguin);
        Log.e(TAG,"Oncreate");
        verificarDatos();
        //3. Obtenemos una instancia del objeto SharedPrefences pasandole la clave
        preferencias = getSharedPreferences(MIS_PREFERENCIAS, Context.MODE_PRIVATE);
        editor = preferencias.edit();


        cedula = (EditText) findViewById(R.id.cedula);
        contraseña = (EditText) findViewById(R.id.contraseña);
        acceder = (Button) findViewById(R.id.acceder);
        acceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((cedula.getText().toString() != null && !cedula.getText().toString().isEmpty())
                        && (contraseña.getText().toString() != null && !contraseña.getText().toString().isEmpty())) {
                    guardarDatos();
                    Intent intent = new Intent(LoguinActivity.this, MenuActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoguinActivity.this, "Completar los campos correspondientes", Toast.LENGTH_SHORT).show();
                }
            }
        });
        registrarse = (Button) findViewById(R.id.registrarse);
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoguinActivity.this, PerfilActivity.class);
                startActivity(intent);
            }
        });

    }


    //4. Guardamos los datos
    private void guardarDatos() {
        Log.e(TAG,"guardarDatos");
        editor.putString(CEDULA, cedula.getText().toString());
        editor.putString(CONTRASEÑA, contraseña.getText().toString());

        editor.commit();
    }

    //6. Cargamos los datos guardados
    private void verificarDatos() {
        Log.e(TAG,"verificarDatos");
        preferencias = getSharedPreferences(MIS_PREFERENCIAS, Context.MODE_PRIVATE);

        //7. Recuperamos los valores guardados
        String cedulaRecuperado = preferencias.getString(CEDULA, "");
        String contraseñaRecuperado = preferencias.getString(CONTRASEÑA, "");
        if ((cedulaRecuperado != null && !cedulaRecuperado.isEmpty())
                && (contraseñaRecuperado != null && !contraseñaRecuperado.isEmpty())) {
            Log.e(TAG,"Preferences con datos cedula y pass "+ cedulaRecuperado+" "+contraseñaRecuperado);
            Intent intent = new Intent(LoguinActivity.this, MenuActivity.class);
            startActivity(intent);
            finish();
        }
    }

    //8. Limpiamos todos los datos del usuario
    private void limpiarDatos() {
        editor.clear();
        editor.commit();

        cedula.setText("");
        contraseña.setText("");
    }

    //5. Guardar el estado de una actividad
    //   onCreate -> onStart -> onResume -> onPause -> onStop -> onDestroy
    //   onCreate -> onStart -> onResume -> onPause -> onStop -> onRestart -> onStart -> ....

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        Log.e(TAG,"onResume");
        super.onResume();
        verificarDatos();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        Log.e(TAG,"onPause");
        super.onPause();
        guardarDatos();
    }

    @Override
    public void onBackPressed() {
        Log.e(TAG,"onBackPressed");
        finish();
        super.onBackPressed();
    }
}
