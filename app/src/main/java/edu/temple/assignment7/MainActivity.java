package edu.temple.assignment7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements BookListFragment.OnItemSelectedInterface, BookDetailsFragment.OnFragmentInteractionListener {

    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ArrayList<Book> BookList = new ArrayList<Book>();

        BookListFragment bookListFragment = BookListFragment.newInstance(BookList);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container1, bookListFragment);
        fragmentTransaction.addToBackStack(BookListFragment.class.getName());
        fragmentTransaction.commit();

    }




    @Override
    public void itemSelected(Book book) {
        BookDetailsFragment bookDetailsFragment = BookDetailsFragment.newInstance(book);

        if(findViewById(R.id.container2) == null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container1, bookDetailsFragment);
            fragmentTransaction.addToBackStack(BookDetailsFragment.class.getName());
            fragmentTransaction.commit();
        }
        else{
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container2, bookDetailsFragment);
            fragmentTransaction.addToBackStack(BookDetailsFragment.class.getName());
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    @Override
    public void onBackPressed() {

            if(findViewById(R.id.container2) == null) {
                ArrayList<Book> BookList = new ArrayList<Book>();
                BookListFragment bookListFragment = BookListFragment.newInstance(BookList);
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container1, bookListFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }

    }
}
