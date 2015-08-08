package hornero.example.com.py.hornero.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import hornero.example.com.py.hornero.R;

/**
 * Created by Ale on 29/07/2015.
 */
public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG=" MenuActivity ";
    //Inicializacion de las variable correspondientes para trabajar
    Toolbar toolbar;

    //botones que realizaran las acciones deseadas

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate");
        //XML que se encuentra el la carperte /res/layout
        setContentView(R.layout.activity_menu);
        toolbar= (Toolbar) findViewById(R.id.activity_my_toolbar);
        setSupportActionBar(toolbar);

        //ejemplo de inicializacion de un boton para que realizae cierta accion
        //en este caso realizara la llamada a una nueva actividad
        //por lo tanto se utilizara el Intent
        // se podra reconocer al boton con el nombre que se le denomina a continuacipon android:id="@+id/opcion1"
        button1 = (Button) findViewById(R.id.opcion1);
        //ahora relizaea la llamada a la actividad en este caso sera a la actividad correspondiente de "Menu"
        button1.setOnClickListener(this);


    }

    @Override
    public void onBackPressed() {
        Log.e(TAG, "onBackpressed");
        super.onBackPressed();
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.opcion1):
                // ejemplo de llamado a la intencion
                Log.e(TAG, " LLamada a la intencion ProductosActivity");
                Intent intent = new Intent(this, ProductosActivity.class);
                startActivity(intent);
                break;
        }
    }
}
