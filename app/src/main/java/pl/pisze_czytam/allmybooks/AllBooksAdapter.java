package pl.pisze_czytam.allmybooks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class AllBooksAdapter extends RecyclerView.Adapter<AllBooksAdapter.BookViewHolder> {
    private ArrayList<Book> books;
    private final OnItemClickListener listener;

    public AllBooksAdapter(ArrayList<Book> books, OnItemClickListener listener) {
        this.books = books;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_item, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.bind(books.get(position), listener);
        holder.cover.setImageDrawable(books.get(position).getCover());
        holder.title.setText(books.get(position).getTitle());
        holder.author.setText(books.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        CardView card;
        ImageView cover;
        TextView title;
        TextView author;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card_view);
            cover = itemView.findViewById(R.id.cover);
            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);
        }

        public void bind(final Book book, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(book);
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClick(Book book);
    }
}
