package pl.pisze_czytam.allmybooks.roomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "book_table")
public class BookData {
    @PrimaryKey(autoGenerate = true)
    private long bookID;
    private String bookTitle;
    private String bookAuthor;
    private String bookCase;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] bookImage;

    public long getBookID() {
        return bookID;
    }

    public void setBookID(long bookID) {
        this.bookID = bookID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookCase() {
        return bookCase;
    }

    public void setBookCase(String bookCase) {
        this.bookCase = bookCase;
    }

    public byte[] getBookImage() {
        return bookImage;
    }

    public void setBookImage(byte[] bookImage) {
        this.bookImage = bookImage;
    }
}
