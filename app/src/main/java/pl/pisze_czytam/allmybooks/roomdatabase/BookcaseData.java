package pl.pisze_czytam.allmybooks.roomdatabase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bookcase_table")
public class BookcaseData {
    @PrimaryKey(autoGenerate = true)
    private long bookcaseID;
    private String bookcaseName;
    private int shelfs;

    public long getBookcaseID() {
        return bookcaseID;
    }

    public void setBookcaseID(long bookcaseID) {
        this.bookcaseID = bookcaseID;
    }

    public String getBookcaseName() {
        return bookcaseName;
    }

    public void setBookcaseName(String bookcaseName) {
        this.bookcaseName = bookcaseName;
    }

    public int getShelfs() {
        return shelfs;
    }

    public void setShelfs(int shelfs) {
        this.shelfs = shelfs;
    }
}
