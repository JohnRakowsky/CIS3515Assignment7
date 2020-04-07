package edu.temple.assignment7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class BookListAdapter extends BaseAdapter {

    ArrayList<Book> books;
    Context ctxt;
    LayoutInflater inflater;

    public BookListAdapter(ArrayList<Book> booklist, Context c) {
        books = booklist;
        ctxt = c;
        inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return books.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return books.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        // TODO Create the cell (View) and populate it with an element of the array
        if (view == null) {

            view = inflater.inflate(R.layout.booklistlayout, viewGroup, false);
        }

        TextView book = (TextView) view.findViewById(R.id.book);
        TextView author = (TextView) view.findViewById(R.id.author);
        book.setText(books.get(position).getTitle());
        author.setText(books.get(position).getAuthor());
        return view;
    }

}
