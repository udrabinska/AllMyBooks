package pl.pisze_czytam.allmybooks.roomdatabase;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class BookRepository {
    private BookDao bookDao;
    private LiveData<List<BookData>> allBooksAsc;

    public BookRepository(Application application) {
        //This will create single instance of database named db
        BookRoomDatabase db = BookRoomDatabase.getDatabase(application);
        //This book dao is copied from database entity
        bookDao = db.bookDao();
        //For now there is only one simple book list. We can add more in future.
        allBooksAsc = bookDao.getAllBooksAllAsc();
    }

    public LiveData<List<BookData>> getAllBooksAsc() {
        return allBooksAsc;
    }

    //Method with async task for inserting single book
    public void insertBook(BookData bookData) {
        new insertBookAsyncTask(bookDao).execute(bookData);
    }

    private static class insertBookAsyncTask extends AsyncTask<BookData, Void, Void> {
        private BookDao AsyncTaskDao;

        insertBookAsyncTask(BookDao dao) {
            AsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final BookData... params) {
            AsyncTaskDao.insertBook(params[0]);
            return null;
        }
    }
}
