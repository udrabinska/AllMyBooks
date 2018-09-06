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

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import pl.pisze_czytam.allmybooks.databinding.AllBooksBinding;
import pl.pisze_czytam.allmybooks.databinding.BookcaseMainBinding;

public class MainActivity extends AppCompatActivity {
    boolean showAll;
    ArrayList<Book> allBooks = new ArrayList<>();
    AllBooksBinding allBooksBinding;
    BookcaseMainBinding bookcaseBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String viewPref = sharedPreferences.getString(getString(R.string.settings_view_key), getString(R.string.settings_view_default));

        if (viewPref.equals(getString(R.string.list_view_value))) {
            setContentView(R.layout.all_books);
            allBooksBinding = DataBindingUtil.setContentView(this, R.layout.all_books);

            allBooks.add(new Book("Upał", "Michał Olszewski", ContextCompat.getDrawable(getApplicationContext(), R.drawable.book_cover_6)));
            allBooks.add(new Book("Duchowe życie zwierząt", "Peter Wohlleben", ContextCompat.getDrawable(getApplicationContext(), R.drawable.book_cover_1)));
            allBooks.add(new Book("Jak przestałem kochać design", "Marcin Wicha", ContextCompat.getDrawable(getApplicationContext(), R.drawable.book_cover_5)));
            allBooks.add(new Book("Międzymorze", "Ziemowit Szczerek", ContextCompat.getDrawable(getApplicationContext(), R.drawable.book_cover_4)));
            allBooks.add(new Book("Osiołkiem", "Andrzej Stasiuk", ContextCompat.getDrawable(getApplicationContext(), R.drawable.book_cover_2)));
            allBooks.add(new Book("Prowadź swój pług przez kości umarłych", "Olga Tokarczuk", ContextCompat.getDrawable(getApplicationContext(), R.drawable.book_cover_3)));

            allBooksBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            allBooksBinding.recyclerView.setAdapter(new AllBooksAdapter(allBooks, new AllBooksAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(Book book) {
                    // without passing Drawable (and implementing Parceable for now, because:
                    // TODO: to change, when we'll have uri to item
                    String author = book.getAuthor();
                    String title = book.getTitle();
                    Intent detailsIntent = new Intent(MainActivity.this, BookDetails.class);
                    detailsIntent.putExtra("author", author);
                    detailsIntent.putExtra("title", title);
                    startActivity(detailsIntent);
                }
            }));
        } else {
            setContentView(R.layout.bookcase_main);
            bookcaseBinding = DataBindingUtil.setContentView(this, R.layout.bookcase_main);
            BookcasePagerAdapter adapter = new BookcasePagerAdapter(getSupportFragmentManager(), this);
            bookcaseBinding.viewpager.setAdapter(adapter);
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
