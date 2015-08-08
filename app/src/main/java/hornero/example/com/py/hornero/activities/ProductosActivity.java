package hornero.example.com.py.hornero.activities;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.GridView;

import java.util.ArrayList;

import hornero.example.com.py.hornero.Adapter.GridViewMenuAdapter;
import hornero.example.com.py.hornero.Model.ImageItem;
import hornero.example.com.py.hornero.R;

/**
 * Created by Ale on 03/08/2015.
 */
public class ProductosActivity extends AppCompatActivity {

    private static final String TAG=" ProductosActivity ";
    private GridView gridView;
    private GridViewMenuAdapter gridViewMenuAdapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, " oncreate");
        setContentView(R.layout.grilla_menu);
        toolbar= (Toolbar) findViewById(R.id.include);
        setSupportActionBar(toolbar);


        gridView = (GridView) findViewById(R.id.gridView);
        gridViewMenuAdapter = new GridViewMenuAdapter(this, R.layout.item_menu, getData());
        gridView.setAdapter(gridViewMenuAdapter);

    }

    private ArrayList<ImageItem> getData() {
        Log.e(TAG," getData");
        final ArrayList<ImageItem> imageItems = new ArrayList<>();

        TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
        for (int i = 0; i < imgs.length(); i++){
            Log.e(TAG," carga de imagenes "+i);
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap, "Image#" + i));
        }

        return imageItems;
    }
}