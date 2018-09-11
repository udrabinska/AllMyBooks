package pl.pisze_czytam.allmybooks.roomdatabase;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface BookDao {
    @Delete
    void deleteBook(BookData bookData);

    @Insert
    void insertBook(BookData bookData);

    @Query("SELECT * from book_table ORDER BY bookAuthor ASC, bookTitle ASC")
    LiveData<List<BookData>> getAllBooksAllAsc();

    @Query("SELECT * from book_table ORDER BY bookAuthor ASC, bookTitle DESC")
    LiveData<List<BookData>> getAllBooksTitleDesc();

    @Query("SELECT Count(bookTitle) FROM book_table;")
    Integer countTitleInBookTable();

    @Query("SELECT * from book_table ORDER BY bookID ASC")
    LiveData<List<BookData>> getAllBooksByID();
}
