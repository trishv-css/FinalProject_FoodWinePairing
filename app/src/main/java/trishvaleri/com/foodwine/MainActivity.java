//===============================================
//Title: Food&Wine
//Author: Trish Valeri
//Contributors: square.github.io/picasso/, stackoverflow.com
//Date: 5/7/16 - 5/10/16 (I had to scrap first project)
//Purpose: An app that allows you to choose a food category and gives you the type of wine
//      that pairs well with your food choice.
//===============================================

package trishvaleri.com.foodwine;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * MainActivity.java - starting point. Introduces arraylist and fills it with images.
 * @author Trish Valeri
 */
public class MainActivity extends AppCompatActivity {

    ArrayList<Image> images;
    ImagePicassoAdapter adapter;
    GridView gridView;
    ImageView imageView;

    /**
     * adds images to Image ArrayList. sets the GridView adapter (calls on ImagePicassoAdapter).
     * @param savedInstanceState Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gridView = (GridView) findViewById(R.id.gridview);
        //creates ArrayList images
        images = new ArrayList<>();
        //adds a new Image object to ArrayList
        images.add(new Image("Custom"));
        //sets the image poster to specified ArrayList object.
        images.get(0).setPoster("http://i.istockimg.com/file_thumbview_approve/38472112/3/stock-photo-38472112-wine-corks.jpg");
        images.add(new Image("Vegetables"));
        images.get(1).setPoster("http://i.istockimg.com/file_thumbview_approve/59086536/3/stock-photo-59086536-vegetable.jpg");
        images.add(new Image("Roasted Vegetables"));
        images.get(2).setPoster("http://i.istockimg.com/file_thumbview_approve/21060866/3/stock-photo-21060866-roasted-cherry-tomatoes.jpg");
        images.add(new Image("Soft Cheese"));
        images.get(3).setPoster("http://ecx.images-amazon.com/images/I/518M+4TQJPL._AC_US190_.jpg");
        images.add(new Image("Hard Cheese"));
        images.get(4).setPoster("http://cdn3.bigcommerce.com/s-6ra4nz/products/1315/images/1296/51J%25252BhM-vYcL__58151.1430872189.190.285.jpg?c=2");
        images.add(new Image("Starches"));
        images.get(5).setPoster("http://philadelphia.grubstreet.com/20110609_artofbread_190x190.jpg");
        images.add(new Image("Fish"));
        images.get(6).setPoster("http://i.istockimg.com/file_thumbview_approve/19684401/3/stock-photo-19684401-grilled-salmon-steak-with-fresh-salad-and-balsamic-vinegar-sauce.jpg");
        images.add(new Image("Rich Fish"));
        images.get(7).setPoster("http://i.istockimg.com/file_thumbview_approve/566750/3/stock-photo-566750-seafood.jpg");
        images.add(new Image("White Meat"));
        images.get(8).setPoster("http://cdn-image.foodandwine.com/sites/default/files/styles/rd_related_content_190x190/public/201112-xl-brined-roast-chicken-with-olive-bread-panzanella.jpg?itok=8dT6jz4P");
        images.add(new Image("Red Meat"));
        images.get(9).setPoster("http://www.donaldrussell.com/media/catalog/category/190X190/Pave-Rump-Steak_28_1.jpg");
        images.add(new Image("Cured Meat"));
        images.get(10).setPoster("http://i.istockimg.com/file_thumbview_approve/35703294/3/stock-photo-35703294-italian-salami.jpg");
        images.add(new Image("Sweets"));
        images.get(11).setPoster("https://s-media-cache-ak0.pinimg.com/236x/cc/69/85/cc6985d6c0edd2eaa463b67f394609dd.jpg");
        //creates ImagePicassoAdapter adapter
        adapter = new ImagePicassoAdapter(MainActivity.this, R.layout.image_view, images);
        //sets the adapter to gridView
        gridView.setAdapter(adapter);

        imageView = (ImageView) findViewById(R.id.img);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent fabIntent = new Intent(MainActivity.this, FabActivity.class);
                startActivity(fabIntent);
            }
        });
    }

    /**
     * creates MySQLiteHelper dbHelper gets a readable database and then closes the dbHelper.
     */
    @Override
    public void onStart() {
        super.onStart();
        MySQLiteHelper dbHelper = new MySQLiteHelper(getApplicationContext());
        dbHelper.getReadableDatabase();
        dbHelper.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
