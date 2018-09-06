package pl.pisze_czytam.allmybooks;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import pl.pisze_czytam.allmybooks.databinding.BookDetailsBinding;

public class BookDetails extends AppCompatActivity {
    BookDetailsBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.book_details);

        String title = getIntent().getStringExtra("title");
        String author = getIntent().getStringExtra("author");
        binding.title.setText(title);
        binding.author.setText(author);
    }
}
