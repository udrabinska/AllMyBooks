package pl.pisze_czytam.allmybooks.roomdatabase;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class BookViewModel extends AndroidViewModel {
    private BookRepository repository;
    private LiveData<List<BookData>> allBooksAsc;

    public BookViewModel(Application application) {
        super(application);
        repository = new BookRepository(application);
        allBooksAsc = repository.getAllBooksAsc();

    }

    public LiveData<List<BookData>> getAllBooksAsc() {
        return allBooksAsc;
    }

    public void insertBook(BookData book) {
        repository.insertBook(book);
    }
}

