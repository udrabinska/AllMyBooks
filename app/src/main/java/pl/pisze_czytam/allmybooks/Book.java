package pl.pisze_czytam.allmybooks;

import android.graphics.drawable.Drawable;

public class Book {
    private String title;
    private String author;
    private Drawable cover;

    public Book(String title, String author, Drawable cover) {
        this.title = title;
        this.author = author;
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Drawable getCover() {
        return cover;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCover(Drawable cover) {
        this.cover = cover;
    }
}
