package hornero.example.com.py.hornero.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import hornero.example.com.py.hornero.R;

/**
 * Created by Ale on 29/07/2015.
 */
public class PerfilActivity  extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        toolbar= (Toolbar) findViewById(R.id.activity_my_toolbar);
        setSupportActionBar(toolbar);
    }
}
