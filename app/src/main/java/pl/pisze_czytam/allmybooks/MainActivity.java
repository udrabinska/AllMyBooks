package pl.pisze_czytam.allmybooks;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {
    boolean showAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String viewPref = sharedPreferences.getString(getString(R.string.settings_view_key), getString(R.string.settings_view_default));

        if (viewPref.equals(getString(R.string.list_view_value))) {
            setContentView(R.layout.all_books);
        } else {
            setContentView(R.layout.bookcase_main);
            ViewPager viewPager = findViewById(R.id.viewpager);
            BookcasePagerAdapter adapter = new BookcasePagerAdapter(getSupportFragmentManager(), this);
            viewPager.setAdapter(adapter);
        }
        View include = findViewById(R.id.nav_fab);
        BottomAppBar bottomAppBar = include.findViewById(R.id.bottom_bar);
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
                showAll = !showAll;
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
                String viewPref = sharedPreferences.getString(getString(R.string.settings_view_key), getString(R.string.settings_view_default));
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if (viewPref.equals(getString(R.string.list_view_value))) {
                    editor.putString(getString(R.string.settings_view_key), getString(R.string.bookcase_view_value));
                } else {
                    editor.putString(getString(R.string.settings_view_key), getString(R.string.list_view_value));
                }
                editor.commit();
                startActivity(new Intent(MainActivity.this, MainActivity.class));
                return true;
            case R.id.nav_filter:
                Toast.makeText(getApplicationContext(), "clicked and nothing so far", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_settings:
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
