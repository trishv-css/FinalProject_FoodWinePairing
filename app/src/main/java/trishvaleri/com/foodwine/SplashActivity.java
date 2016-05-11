//refer to MainActivity for project details.
//Contributors specific for this page: bignerdranch.com

package trishvaleri.com.foodwine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * SplashActivity.java - a class to display to the user during initial load time.
 * @author Trish Valeri
 */
public class SplashActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intentStart = new Intent(this, MainActivity.class);
        startActivity(intentStart);
        finish();
    }
}
