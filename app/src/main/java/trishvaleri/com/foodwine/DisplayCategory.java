//refer to MainActivity for project details.
//Contributors specific for this page: tausiq.wordpress.com

package trishvaleri.com.foodwine;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * DisplayCategory.java - class to launch from intent, displays wine categories associated
 * with chosen food category.
 * @author Trish Valeri
 */
public class DisplayCategory extends AppCompatActivity {
    ClientCursorAdapter customAdapter;
    MySQLiteHelper dbHelper;
    Cursor cursor;
    int intIndex;
    ListView listView;
    private static final String TAG = DisplayCategory.class.getSimpleName();

    /**
     * onCreate gets extras from intent to use in queryDB
     * @param savedInstanceState Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //get extras from intent
        Bundle extras = getIntent().getExtras();
        intIndex = extras.getInt("pos");

        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "clicked on item: " + position);
            }
        });


        //if intIndex == 0 then the custom query is run.
        if (intIndex == 0) {
            //database query is called in another thread
            //queryDB is called using int pos from intent
            //sets the listView ClientCursorAdapter customAdapter
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    customAdapter = new ClientCursorAdapter(DisplayCategory.this,
                            customQueryDB());
                    listView.setAdapter(customAdapter);
                    Log.d(TAG, "int index = 0 ");
                }
            });
        }
        else {
            //database query is called in another thread
            //queryDB is called using int pos from intent
            //sets the listView ClientCursorAdapter customAdapter
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    customAdapter = new ClientCursorAdapter(DisplayCategory.this,
                            queryDB(intIndex));
                    listView.setAdapter(customAdapter);
                }
            });
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /**
     * queryDB uses intent variable to initiate a rawQuery on the database.
     * @param intIndex int
     * @return db.rawQuery (wine categories based on user's food category selection)
     */
    protected Cursor queryDB(int intIndex) {
        MySQLiteHelper dbHelper = new MySQLiteHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String string = String.valueOf(intIndex);
        String[] args = {string};
        return db.rawQuery("select wine_cat_id as _id, wine_cat_name from wine_cat join fw_comp on wine_cat_id = fw_comp_pk2 join food on fw_comp_pk1 = _id where _id = ?", args);

        //cursor.close();
    }

    /**
     * customQueryDB initiates a rawQuery on the database.
     * @return db.rawQuery
     */
    protected Cursor customQueryDB() {
        MySQLiteHelper dbHelper = new MySQLiteHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return db.rawQuery("select custom_id as _id, custom_food, custom_wine from custom", null);

        //TODO add handling to allow both custom_food and custom_wine to ListView. (clientcursoradapter.java) TIME RESTRICTION***
        //cursor.close();
    }
}
