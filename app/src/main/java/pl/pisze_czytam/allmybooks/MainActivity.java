package pl.pisze_czytam.allmybooks;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_books);
        BottomAppBar bottomAppBar = findViewById(R.id.bottom_bar);
        setSupportActionBar(bottomAppBar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_change_view:
                Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_filter:
                Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_settings:
                Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
