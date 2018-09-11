package pl.pisze_czytam.allmybooks.roomdatabase;

import android.content.Context;
import android.util.Log;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {BookData.class, BookcaseData.class}, version = 1, exportSchema = false)
public abstract class BookRoomDatabase extends RoomDatabase {
    public abstract BookDao bookDao();
    //This item exist just for counting how many of this item is there currently running
    private static BookRoomDatabase INSTANCE;
    //Singleton method FTW
    public static BookRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BookRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BookRoomDatabase.class, "books_data")
                            //Enable and disable this feature for testing more crazy stuff
                            //.allowMainThreadQueries()
                            //This will enable clearing database
                            //.fallbackToDestructiveMigration()
                            .build();
                    Log.v("BookRoomDatabase", "Database created for now ! o_O");
                }
            }
        }
        return INSTANCE;
    }
}
