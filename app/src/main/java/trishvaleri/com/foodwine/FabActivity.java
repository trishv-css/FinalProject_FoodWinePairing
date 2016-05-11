package trishvaleri.com.foodwine;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

/**
 * FabActivity.java - class from MainActivity Fab button.
 * Used to get custom table values.
 * @author Trish Valeri
 */
public class FabActivity extends AppCompatActivity {
    EditText foodView, wineView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        foodView = (EditText) findViewById(R.id.editText);
        wineView = (EditText) findViewById(R.id.editText2);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    /**
     * save button saves a custom pair in custom list.
     * @param view View
     */
    public void saveButton(View view){
        String food = foodView.getText().toString();
        String wine = wineView.getText().toString();

        //TABLE_CUSTOM enter row data
        String customRows = "INSERT INTO custom ( custom_food, custom_wine)"
                + " VALUES('" +food+ "', '"+wine+"');";

        MySQLiteHelper dbHelper = new MySQLiteHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL(customRows);
        foodView.setText("");
        wineView.setText("");
    }
}
